-- Script de migracion Flyway para crear el esquema de banca
-- Version: V1__Crear_esquema_banca.sql
-- Descripcion: Crea las tablas principales del sistema de banca con normalizacion en 3FN
-- Autor: Sistema de migraciones Flyway
-- Fecha: 2024

-- Tabla de clientes
CREATE TABLE clientes (
    id BIGSERIAL PRIMARY KEY,
    identificacion VARCHAR(50) NOT NULL UNIQUE,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    telefono VARCHAR(20),
    direccion VARCHAR(500),
    fecha_registro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(20) NOT NULL DEFAULT 'ACTIVO' CHECK (estado IN ('ACTIVO', 'INACTIVO', 'BLOQUEADO')),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_clientes_identificacion ON clientes(identificacion);
CREATE INDEX idx_clientes_email ON clientes(email);
CREATE INDEX idx_clientes_estado ON clientes(estado);

-- Tabla de cuentas
CREATE TABLE cuentas (
    id BIGSERIAL PRIMARY KEY,
    numero_cuenta VARCHAR(50) NOT NULL UNIQUE,
    cliente_id BIGINT NOT NULL REFERENCES clientes(id) ON DELETE RESTRICT,
    tipo_cuenta VARCHAR(20) NOT NULL CHECK (tipo_cuenta IN ('AHORROS', 'CORRIENTE', 'PLAZO_FIJO')),
    saldo DECIMAL(19, 4) NOT NULL DEFAULT 0 CHECK (saldo >= 0),
    limite_sobregiro DECIMAL(19, 4) DEFAULT 0 CHECK (limite_sobregiro >= 0),
    tasa_interes DECIMAL(5, 4) DEFAULT 0 CHECK (tasa_interes >= 0),
    fecha_apertura TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_cierre TIMESTAMP,
    estado VARCHAR(20) NOT NULL DEFAULT 'ACTIVA' CHECK (estado IN ('ACTIVA', 'CERRADA', 'BLOQUEADA', 'SUSPENDIDA')),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_cuenta_numero UNIQUE (numero_cuenta)
);

CREATE INDEX idx_cuentas_numero ON cuentas(numero_cuenta);
CREATE INDEX idx_cuentas_cliente ON cuentas(cliente_id);
CREATE INDEX idx_cuentas_estado ON cuentas(estado);
CREATE INDEX idx_cuentas_tipo ON cuentas(tipo_cuenta);

-- Tabla de transacciones
CREATE TABLE transacciones (
    id BIGSERIAL PRIMARY KEY,
    cuenta_origen_id BIGINT NOT NULL REFERENCES cuentas(id) ON DELETE RESTRICT,
    cuenta_destino_id BIGINT REFERENCES cuentas(id) ON DELETE RESTRICT,
    tipo_transaccion VARCHAR(20) NOT NULL CHECK (tipo_transaccion IN ('DEPOSITO', 'RETIRO', 'TRANSFERENCIA', 'PAGO_SERVICIO', 'INTERES', 'COMISION')),
    monto DECIMAL(19, 4) NOT NULL CHECK (monto > 0),
    saldo_anterior DECIMAL(19, 4) NOT NULL,
    saldo_posterior DECIMAL(19, 4) NOT NULL,
    descripcion VARCHAR(500),
    referencia_externa VARCHAR(100),
    estado VARCHAR(20) NOT NULL DEFAULT 'COMPLETADA' CHECK (estado IN ('PENDIENTE', 'COMPLETADA', 'FALLIDA', 'CANCELADA', 'REVERTIDA')),
    fecha_ejecucion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_reversion TIMESTAMP,
    motivo_reversion VARCHAR(500),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_transacciones_cuenta_origen ON transacciones(cuenta_origen_id);
CREATE INDEX idx_transacciones_cuenta_destino ON transacciones(cuenta_destino_id);
CREATE INDEX idx_transacciones_fecha ON transacciones(fecha_ejecucion);
CREATE INDEX idx_transacciones_estado ON transacciones(estado);
CREATE INDEX idx_transacciones_tipo ON transacciones(tipo_transaccion);
CREATE INDEX idx_transacciones_referencia ON transacciones(referencia_externa);

-- Tabla de movimientos (historial detallado para auditoria)
CREATE TABLE movimientos (
    id BIGSERIAL PRIMARY KEY,
    transaccion_id BIGINT NOT NULL REFERENCES transacciones(id) ON DELETE CASCADE,
    cuenta_id BIGINT NOT NULL REFERENCES cuentas(id) ON DELETE RESTRICT,
    tipo_movimiento VARCHAR(20) NOT NULL CHECK (tipo_movimiento IN ('DEBITO', 'CREDITO')),
    monto DECIMAL(19, 4) NOT NULL CHECK (monto > 0),
    saldo_anterior DECIMAL(19, 4) NOT NULL,
    saldo_posterior DECIMAL(19, 4) NOT NULL,
    descripcion VARCHAR(500),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_movimientos_transaccion ON movimientos(transaccion_id);
CREATE INDEX idx_movimientos_cuenta ON movimientos(cuenta_id);
CREATE INDEX idx_movimientos_fecha ON movimientos(created_at);

-- Tabla de servicios (pagos de servicios)
CREATE TABLE servicios (
    id BIGSERIAL PRIMARY KEY,
    codigo_servicio VARCHAR(50) NOT NULL UNIQUE,
    nombre_servicio VARCHAR(255) NOT NULL,
    proveedor VARCHAR(255) NOT NULL,
    categoria VARCHAR(50) NOT NULL CHECK (categoria IN ('SERVICIOS_PUBLICOS', 'TELECOMUNICACIONES', 'SEGUROS', 'EDUCACION', 'OTROS')),
    comision_percentage DECIMAL(5, 2) DEFAULT 0 CHECK (comision_percentage >= 0 AND comision_percentage <= 100),
    comision_fija DECIMAL(19, 4) DEFAULT 0 CHECK (comision_fija >= 0),
    estado VARCHAR(20) NOT NULL DEFAULT 'ACTIVO' CHECK (estado IN ('ACTIVO', 'INACTIVO')),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_servicios_codigo ON servicios(codigo_servicio);
CREATE INDEX idx_servicios_categoria ON servicios(categoria);

-- Tabla de bitacora de operaciones (auditoria completa)
CREATE TABLE bitacora_operaciones (
    id BIGSERIAL PRIMARY KEY,
    entidad VARCHAR(100) NOT NULL,
    entidad_id BIGINT NOT NULL,
    operacion VARCHAR(20) NOT NULL CHECK (operacion IN ('INSERT', 'UPDATE', 'DELETE')),
    datos_anteriores JSONB,
    datos_nuevos JSONB,
    usuario VARCHAR(255),
    ip_origen VARCHAR(45),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_bitacora_entidad ON bitacora_operaciones(entidad, entidad_id);
CREATE INDEX idx_bitacora_fecha ON bitacora_operaciones(created_at);
CREATE INDEX idx_bitacora_usuario ON bitacora_operaciones(usuario);

-- Funcion para actualizar timestamps automaticamente
CREATE OR REPLACE FUNCTION actualizar_updated_at()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Triggers para actualizar timestamps
CREATE TRIGGER trigger_clientes_updated
    BEFORE UPDATE ON clientes
    FOR EACH ROW EXECUTE FUNCTION actualizar_updated_at();

CREATE TRIGGER trigger_cuentas_updated
    BEFORE UPDATE ON cuentas
    FOR EACH ROW EXECUTE FUNCTION actualizar_updated_at();

CREATE TRIGGER trigger_transacciones_updated
    BEFORE UPDATE ON transacciones
    FOR EACH ROW EXECUTE FUNCTION actualizar_updated_at();

CREATE TRIGGER trigger_servicios_updated
    BEFORE UPDATE ON servicios
    FOR EACH ROW EXECUTE FUNCTION actualizar_updated_at();

-- Funcion para registrar en bitacora
CREATE OR REPLACE FUNCTION registrar_bitacora()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO bitacora_operaciones (entidad, entidad_id, operacion, datos_anteriores, datos_nuevos)
    VALUES (
        TG_TABLE_NAME,
        NEW.id,
        TG_OP,
        CASE WHEN TG_OP = 'DELETE' THEN to_jsonb(OLD) ELSE NULL END,
        CASE WHEN TG_OP != 'DELETE' THEN to_jsonb(NEW) ELSE NULL END
    );
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger de bitacora para clientes
CREATE TRIGGER trigger_bitacora_clientes
    AFTER INSERT OR UPDATE OR DELETE ON clientes
    FOR EACH ROW EXECUTE FUNCTION registrar_bitacora();

-- Trigger de bitacora para cuentas
CREATE TRIGGER trigger_bitacora_cuentas
    AFTER INSERT OR UPDATE OR DELETE ON cuentas
    FOR EACH ROW EXECUTE FUNCTION registrar_bitacora();

-- Trigger de bitacora para transacciones
CREATE TRIGGER trigger_bitacora_transacciones
    AFTER INSERT OR UPDATE OR DELETE ON transacciones
    FOR EACH ROW EXECUTE FUNCTION registrar_bitacora();

-- Comentarios para documentacion
COMMENT ON TABLE clientes IS 'Almacena la informacion de los clientes del sistema bancario';
COMMENT ON TABLE cuentas IS 'Almacena las cuentas bancarias de los clientes';
COMMENT ON TABLE transacciones IS 'Registra todas las transacciones financieras del sistema';
COMMENT ON TABLE movimientos IS 'Historial detallado de movimientos por cuenta para auditoria';
COMMENT ON TABLE servicios IS 'Catalogo de servicios disponibles para pagos';
COMMENT ON TABLE bitacora_operaciones IS 'Bitacora de auditoria para todas las operaciones del sistema';