-- Script Flyway V2: Inserción de datos de prueba para validar el modelo normalizado
-- Este script populate las tablas Cliente, Cuenta y Transaccion con datos representativos
-- del dominio bancario para verificar la integridad referencial y el funcionamiento del modelo.

-- =============================================================================
-- INSERCIÓN DE CLIENTES
-- =============================================================================
INSERT INTO clientes (id, nombre, email, telefono, direccion, fecha_creacion, estado)
VALUES 
    ('a1b2c3d4-e5f6-7890-abcd-ef1234567890', 'Juan Pérez Gómez', 'juan.perez@email.com', '+34911234567', 'Calle Mayor 123, Madrid, 28013', '2024-01-15 09:30:00', 'ACTIVO'),
    ('b2c3d4e5-f6a7-8901-bcde-f12345678901', 'María López Fernández', 'maria.lopez@email.com', '+34911234568', 'Avenida Barcelona 45, Barcelona, 08010', '2024-02-20 14:15:00', 'ACTIVO'),
    ('c3d4e5f6-a7b8-9012-cdef-123456789012', 'Carlos Rodríguez Torres', 'carlos.rodriguez@email.com', '+34911234569', 'Plaza España 78, Sevilla, 41001', '2024-03-10 11:45:00', 'ACTIVO'),
    ('d4e5f6a7-b8c9-0123-defa-234567890123', 'Ana Martínez Sánchez', 'ana.martinez@email.com', '+34911234570', 'Calle Gran Vía 90, Bilbao, 48001', '2024-03-25 16:20:00', 'ACTIVO'),
    ('e5f6a7b8-c9d0-1234-efab-345678901234', 'Pedro García López', 'pedro.garcia@email.com', '+34911234571', 'Avenida Madrid 15, Valencia, 46001', '2024-04-05 10:00:00', 'INACTIVO'),
    ('f6a7b8c9-d0e1-2345-fabc-456789012345', 'Laura Díaz Ruiz', 'laura.diaz@email.com', '+34911234572', 'Calle Serrano 200, Madrid, 28006', '2024-04-18 13:30:00', 'ACTIVO'),
    ('g7b8c9d0-e1f2-3456-gbcd-567890123456', 'Miguel Hernández Castro', 'miguel.hernandez@email.com', '+34911234573', 'Calle Alcalá 50, Madrid, 28014', '2024-05-02 09:15:00', 'ACTIVO'),
    ('h8c9d0e1-f2a3-4567-hcde-678901234567', 'Sofia Jiménez Morales', 'sofia.jimenez@email.com', '+34911234574', 'Avenida Diagonal 300, Barcelona, 08006', '2024-05-20 15:45:00', 'ACTIVO'),
    ('i9d0e1f2-a3b4-5678-idef-789012345678', 'David Romero Vargas', 'david.romero@email.com', '+34911234575', 'Calle Larios 25, Málaga, 29001', '2024-06-01 12:00:00', 'ACTIVO'),
    ('j0e1f2a3-b4c5-6789-jefg-890123456789', 'Carmen Núñez Castillo', 'carmen.nunez@email.com', '+34911234576', 'Plaza Santa María 10, Santiago de Compostela, 15704', '2024-06-15 10:30:00', 'SUSPENDIDO');

-- =============================================================================
-- INSERCIÓN DE CUENTAS
-- =============================================================================
INSERT INTO cuentas (id, numero_cuenta, saldo, tipo_cuenta, cliente_id, fecha_creacion, estado)
VALUES 
    ('c1a1b2c3-d4e5-f6a7-b8c9-d0e1f2a3b4c5', 'ES7621001122334455667788', 15000.00, 'CUENTA_AHORRO', 'a1b2c3d4-e5f6-7890-abcd-ef1234567890', '2024-01-16 10:00:00', 'ACTIVA'),
    ('c2b2c3d4-e5f6-a7b8-c9d0-e1f2a3b4c5d6', 'ES9821002233445566778899', 5000.00, 'CUENTA_CORRIENTE', 'a1b2c3d4-e5f6-7890-abcd-ef1234567890', '2024-01-17 11:30:00', 'ACTIVA'),
    ('c3c3d4e5-f6a7-b8c9-d0e1-f2a3b4c5d6e7', 'ES7621003344556677889900', 25000.50, 'CUENTA_AHORRO', 'b2c3d4e5-f6a7-8901-bcde-f12345678901', '2024-02-21 09:00:00', 'ACTIVA'),
    ('c4d4e5f6-a7b8-c9d0-e1f2-a3b4c5d6e7f8', 'ES7621004455667788990011', 1200.75, 'CUENTA_SALARIO', 'b2c3d4e5-f6a7-8901-bcde-f12345678901', '2024-02-22 10:15:00', 'ACTIVA'),
    ('c5e5f6a7-b8c9-d0e1-f2a3-b4c5d6e7f8a9', 'ES9821005566778899001122', 8000.00, 'CUENTA_CORRIENTE', 'c3d4e5f6-a7b8-9012-cdef-123456789012', '2024-03-11 14:00:00', 'ACTIVA'),
    ('c6f6a7b8-c9d0-e1f2-a3b4-c5d6e7f8a9b0', 'ES7621006677889900112233', 45000.25, 'CUENTA_AHORRO', 'd4e5f6a7-b8c9-0123-defa-234567890123', '2024-03-26 09:30:00', 'ACTIVA'),
    ('c7a7b8c9-d0e1-f2a3-b4c5-d6e7f8a9b0c1', 'ES9821007788990011223344', 0.00, 'CUENTA_CORRIENTE', 'e5f6a7b8-c9d0-1234-efab-345678901234', '2024-04-06 11:00:00', 'BLOQUEADA'),
    ('c8b8c9d0-e1f2-a3b4-c5d6-e7f8a9b0c1d2', 'ES7621008899001122334455', 35000.00, 'CUENTA_AHORRO', 'f6a7b8c9-d0e1-2345-fabc-456789012345', '2024-04-19 15:00:00', 'ACTIVA'),
    ('c9c9d0e1-f2a3-b4c5-d6e7-f8a9b0c1d2e3', 'ES9821009900112233445566', 15000.00, 'CUENTA_SALARIO', 'g7b8c9d0-e1f2-3456-gbcd-567890123456', '2024-05-03 10:30:00', 'ACTIVA'),
    ('c0d0e1f2-a3b4-c5d6-e7f8-a9b0c1d2e3f4', 'ES7621000011223344556677', 22000.00, 'CUENTA_CORRIENTE', 'h8c9d0e1-f2a3-4567-hcde-678901234567', '2024-05-21 12:00:00', 'ACTIVA'),
    ('c1d1e1f2-a3b4-c5d6-e7f8-a9b0-c1d2e3f4a5', 'ES9821001122334455667789', 500.00, 'CUENTA_AHORRO', 'i9d0e1f2-a3b4-5678-idef-789012345678', '2024-06-02 09:45:00', 'ACTIVA'),
    ('c2e2f2a3-b4c5-d6e7-f8a9-b0c1-d2e3f4a5b6', 'ES7621002233445566778890', 100.00, 'CUENTA_CORRIENTE', 'j0e1f2a3-b4c5-6789-jefg-890123456789', '2024-06-16 14:00:00', 'SUSPENDIDA');

-- =============================================================================
-- INSERCIÓN DE TRANSACCIONES
-- =============================================================================
INSERT INTO transacciones (id, cuenta_id, tipo_transaccion, monto, descripcion, fecha_transaccion, estado, referencia_externa)
VALUES 
    ('t1a1b2c3-d4e5-f6a7-b8c9-d0e1f2a3b4c5', 'c1a1b2c3-d4e5-f6a7-b8c9-d0e1f2a3b4c5', 'DEPOSITO', 5000.00, 'Depósito inicial cuenta ahorro', '2024-01-16 10:15:00', 'COMPLETADA', 'DEP-2024-001'),
    ('t2b2c3d4-e5f6-a7b8-c9d0-e1f2a3b4c5d6', 'c1a1b2c3-d4e5-f6a7-b8c9-d0e1f2a3b4c5', 'TRANSFERENCIA_ENTRADA', 2500.00, 'Transferencia recibida de María López', '2024-01-20 11:30:00', 'COMPLETADA', 'TRF-2024-002'),
    ('t3c3d4e5-f6a7-b8c9-d0e1-f2a3b4c5d6e7', 'c1a1b2c3-d4e5-f6a7-b8c9-d0e1f2a3b4c5', 'RETIRO', 1000.00, 'Retiro en cajero automático', '2024-02-05 16:45:00', 'COMPLETADA', 'RET-2024-003'),
    ('t4d4e5f6-a7b8-c9d0-e1f2-a3b4c5d6e7f8', 'c2b2c3d4-e5f6-a7b8-c9d0-e1f2a3b4c5d6', 'PAGO', 150.75, 'Pago servicios luz', '2024-01-25 09:00:00', 'COMPLETADA', 'PAG-2024-004'),
    ('t5e5f6a7-b8c9-d0e1-f2a3-b4c5d6e7f8a9', 'c2b2c3d4-e5f6-a7b8-c9d0-e1f2a3b4c5d6', 'DEPOSITO', 3500.00, 'Depósito nómina enero', '2024-01-30 08:00:00', 'COMPLETADA', 'NOM-2024-005'),
    ('t6f6a7b8-c9d0-e1f2-a3b4-c5d6e7f8a9b0', 'c3c3d4e5-f6a7-b8c9-d0e1-f2a3b4c5d6e7', 'DEPOSITO', 15000.00, 'Depósito inicial cuenta ahorro', '2024-02-21 09:30:00', 'COMPLETADA', 'DEP-2024-006'),
    ('t7a7b8c9-d0e1-f2a3-b4c5-d6e7f8a9b0c1', 'c3c3d4e5-f6a7-b8c9-d0e1-f2a3b4c5d6e7', 'TRANSFERENCIA_SALIDA', 5000.00, 'Transferencia a cuenta corriente', '2024-02-25 14:00:00', 'COMPLETADA', 'TRF-2024-007'),
    ('t8b8c9d0-e1f2-a3b4-c5d6-e7f8a9b0c1d2', 'c4d4e5f6-a7b8-c9d0-e1f2-a3b4c5d6e7f8', 'PAGO', 450.00, 'Pago alquiler marzo', '2024-03-01 10:00:00', 'COMPLETADA', 'PAG-2024-008'),
    ('t9c9d0e1-f2a3-b4c5-d6e7-f8a9b0c1d2e3', 'c4d4e5f6-a7b8-c9d0-e1f2-a3b4c5d6e7f8', 'DEPOSITO', 1200.75, 'Depósito nómina febrero', '2024-02-28 08:15:00', 'COMPLETADA', 'NOM-2024-009'),
    ('t0d0e1f2-a3b4-c5d6-e7f8-a9b0c1d2e3f4', 'c5e5f6a7-b8c9-d0e1-f2a3-b4c5d6e7f8a9', 'DEPOSITO', 8000.00, 'Depósito inicial cuenta corriente', '2024-03-11 14:30:00', 'COMPLETADA', 'DEP-2024-010'),
    ('t1e1f2a3-b4c5-d6e7-f8a9-b0c1-d2e3f4a5b6', 'c5e5f6a7-b8c9-d0e1-f2a3-b4c5d6e7f8a9', 'TRANSFERENCIA_ENTRADA', 3000.00, 'Transferencia recibida de Juan Pérez', '2024-03-15 17:00:00', 'COMPLETADA', 'TRF-2024-011'),
    ('t2f2a3b4-c5d6-e7f8-a9b0-c1d2e3f4a5b6c7', 'c6f6a7b8-c9d0-e1f2-a3b4-c5d6e7f8a9b0', 'DEPOSITO', 45000.25, 'Depósito inicial cuenta ahorro', '2024-03-26 10:00:00', 'COMPLETADA', 'DEP-2024-012'),
    ('t3a3b4c5-d6e7-f8a9-b0c1-d2e3f4a5b6c7d8', 'c6f6a7b8-c9d0-e1f2-a3b4-c5d6e7f8a9b0', 'RETIRO', 5000.00, 'Retiro parcial cuenta ahorro', '2024-04-10 11:00:00', 'COMPLETADA', 'RET-2024-013'),
    ('t4b4c5d6-e7f8-a9b0-c1d2-e3f4a5b6c7d8e9', 'c7a7b8c9-d0e1-f2a3-b4c5-d6e7f8a9b0c1', 'PAGO', 200.00, 'Pago servicios agua', '2024-04-10 09:30:00', 'COMPLETADA', 'PAG-2024-014'),
    ('t5c5d6e7-f8a9-b0c1-d2e3-f4a5b6c7d8e9f0', 'c8b8c9d0-e1f2-a3b4-c5d6-e7f8a9b0c1d2', 'DEPOSITO', 35000.00, 'Depósito inicial cuenta ahorro', '2024-04-19 15:30:00', 'COMPLETADA', 'DEP-2024-015'),
    ('t6d6e7f8-a9b0c1-d2e3-f4a5-b6c7d8e9f0a1', 'c8b8c9d0-e1f2-a3b4-c5d6-e7f8a9b0c1d2', 'TRANSFERENCIA_SALIDA', 10000.00, 'Transferencia a cuenta inversión', '2024-05-05 12:00:00', 'COMPLETADA', 'TRF-2024-016'),
    ('t7e7f8a9-b0c1-d2e3-f4a5-b6c7-d8e9f0a1b2', 'c9c9d0e1-f2a3-b4c5-d6e7-f8a9b0c1d2e3', 'DEPOSITO', 15000.00, 'Depósito nómina mayo', '2024-05-31 08:30:00', 'COMPLETADA', 'NOM-2024-017'),
    ('t8f8a9b0-c1d2-e3f4-a5b6-c7d8e9f0a1b2c3', 'c0d0e1f2-a3b4-c5d6-e7f8-a9b0c1d2e3f4', 'DEPOSITO', 22000.00, 'Depósito inicial cuenta corriente', '2024-05-21 12:30:00', 'COMPLETADA', 'DEP-2024-018'),
    ('t9a9b0c1-d2e3-f4a5b6-c7d8e9f0a1b2c3d4', 'c0d0e1f2-a3b4-c5d6-e7f8-a9b0c1d2e3f4', 'PAGO', 500.50, 'Pago tarjeta crédito', '2024-06-01 10:00:00', 'COMPLETADA', 'PAG-2024-019'),
    ('t0b0c1d2-e3f4-a5b6-c7d8-e9f0a1b2c3d4e5', 'c1d1e1f2-a3b4-c5d6-e7f8-a9b0-c1d2e3f4a5', 'DEPOSITO', 500.00, 'Depósito inicial cuenta ahorro', '2024-06-02 10:00:00', 'COMPLETADA', 'DEP-2024-020'),
    ('t1c1d1e2-f3a4-b5c6-d7e8-f9a0b1c2d3e4f5', 'c1d1e1f2-a3b4-c5d6-e7f8-a9b0-c1d2e3f4a5', 'RETIRO', 200.00, 'Retiro cajero automático', '2024-06-10 15:00:00', 'COMPLETADA', 'RET-2024-021'),
    ('t2d2e2f3-a4b5-c6d7-e8f9-a0b1-c2d3e4f5a6b7', 'c2e2f2a3-b4c5-d6e7-f8a9-b0c1-d2e3f4a5b6', 'DEPOSITO', 100.00, 'Depósito inicial cuenta corriente', '2024-06-16 14:30:00', 'PENDIENTE', 'DEP-2024-022'),
    ('t3e3f3a4-b5c6-d7e8-f9a0-b1c2d3e4f5a6b7c8', 'c3c3d4e5-f6a7-b8c9-d0e1-f2a3b4c5d6e7', 'TRANSFERENCIA_SALIDA', 1000.00, 'Transferencia a cuenta terceros', '2024-06-18 11:00:00', 'FALLIDA', 'TRF-2024-023'),
    ('t4f4a4b5-c6d7-e8f9-a0b1-c2d3e4f5a6b7c8d9', 'c4d4e5f6-a7b8-c9d0-e1f2-a3b4c5d6e7f8', 'PAGO', 1200.75, 'Pago alquiler abril', '2024-04-01 09:00:00', 'COMPLETADA', 'PAG-2024-024'),
    ('t5a5b5c6-d7e8-f9a0b1-c2d3-e4f5a6b7c8d9e0', 'c4d4e5f6-a7b8-c9d0-e1f2-a3b4c5d6e7f8', 'PAGO', 1200.75, 'Pago alquiler mayo', '2024-05-01 09:00:00', 'COMPLETADA', 'PAG-2024-025');

-- =============================================================================
-- VERIFICACIÓN DE INTEGRIDAD REFERENCIAL
-- =============================================================================
-- Verificar que todas las cuentas tienen cliente válido
SELECT COUNT(*) AS cuentas_sin_cliente 
FROM cuentas c 
LEFT JOIN clientes cl ON c.cliente_id = cl.id 
WHERE cl.id IS NULL;

-- Verificar que todas las transacciones tienen cuenta válida
SELECT COUNT(*) AS transacciones_sin_cuenta 
FROM transacciones t 
LEFT JOIN cuentas c ON t.cuenta_id = c.id 
WHERE c.id IS NULL;

-- =============================================================================
-- CONSULTAS DE VERIFICACIÓN DEL MODELO NORMALIZADO
-- =============================================================================
-- Total de clientes por estado
SELECT estado, COUNT(*) AS total 
FROM clientes 
GROUP BY estado;

-- Total de cuentas por tipo y estado
SELECT tipo_cuenta, estado, COUNT(*) AS total, SUM(saldo) AS saldo_total 
FROM cuentas 
GROUP BY tipo_cuenta, estado 
ORDER BY tipo_cuenta, estado;

-- Transacciones por tipo
SELECT tipo_transaccion, COUNT(*) AS total, SUM(monto) AS monto_total 
FROM transacciones 
GROUP BY tipo_transaccion 
ORDER BY total DESC;

-- Promedio de saldo por tipo de cuenta
SELECT tipo_cuenta, AVG(saldo) AS promedio_saldo, MIN(saldo) AS saldo_minimo, MAX(saldo) AS saldo_maximo 
FROM cuentas 
WHERE estado = 'ACTIVA' 
GROUP BY tipo_cuenta;