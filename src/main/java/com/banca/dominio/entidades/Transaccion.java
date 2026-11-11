package com.banca.dominio.entidades;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "transacciones", indexes = {
    @Index(name = "idx_transaccion_cuenta", columnList = "cuenta_id"),
    @Index(name = "idx_transaccion_cliente", columnList = "cliente_id"),
    @Index(name = "idx_transaccion_fecha", columnList = "fecha_transaccion"),
    @Index(name = "idx_transaccion_referencia", columnList = "referencia_externa", unique = true)
})
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "referencia_externa", unique = true, length = 50)
    private String referenciaExterna;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_transaccion", nullable = false, length = 20)
    private TipoTransaccion tipoTransaccion;

    @Column(name = "monto", nullable = false, precision = 19, scale = 4)
    private BigDecimal monto;

    @Enumerated(EnumType.STRING)
    @Column(name = "moneda", nullable = false, length = 3)
    private Cuenta.Moneda moneda;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 15)
    private EstadoTransaccion estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_id", nullable = false)
    private Cuenta cuenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "cuenta_origen")
    private String cuentaOrigen;

    @Column(name = "cuenta_destino")
    private String cuentaDestino;

    @Column(name = "fecha_transaccion", nullable = false)
    private LocalDateTime fechaTransaccion;

    @Column(name = "fecha_procesamiento")
    private LocalDateTime fechaProcesamiento;

    @Column(name = "canal", length = 20)
    private String canal;

    @Column(name = "codigo_respuesta", length = 10)
    private String codigoRespuesta;

    public Transaccion() {
    }

    public Transaccion(TipoTransaccion tipoTransaccion, BigDecimal monto, Cuenta.Moneda moneda,
                       Cuenta cuenta, Cliente cliente) {
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.moneda = moneda;
        this.cuenta = cuenta;
        this.cliente = cliente;
        this.estado = EstadoTransaccion.PENDIENTE;
        this.fechaTransaccion = LocalDateTime.now();
    }

    @PrePersist
    protected void onCreate() {
        if (fechaTransaccion == null) {
            fechaTransaccion = LocalDateTime.now();
        }
    }

    public void ejecutar() {
        if (this.estado != EstadoTransaccion.PENDIENTE) {
            throw new IllegalStateException("Solo se pueden ejecutar transacciones pendientes");
        }

        switch (tipoTransaccion) {
            case DEPOSITO -> cuenta.acreditar(monto);
            case RETIRO -> cuenta.debitar(monto);
            case TRANSFERENCIA -> {
                cuenta.debitar(monto);
            }
            case PAGO -> cuenta.debitar(monto);
            default -> throw new IllegalArgumentException("Tipo de transacción no soportado: " + tipoTransaccion);
        }

        this.estado = EstadoTransaccion.COMPLETADA;
        this.fechaProcesamiento = LocalDateTime.now();
    }

    public void rechazar(String codigoRespuesta) {
        this.estado = EstadoTransaccion.RECHAZADA;
        this.codigoRespuesta = codigoRespuesta;
        this.fechaProcesamiento = LocalDateTime.now();
    }

    public void reversar(String motivo) {
        if (this.estado != EstadoTransaccion.COMPLETADA) {
            throw new IllegalStateException("Solo se pueden reversar transacciones completadas");
        }

        switch (tipoTransaccion) {
            case DEPOSITO -> cuenta.debitar(monto);
            case RETIRO -> cuenta.acreditar(monto);
            case TRANSFERENCIA -> cuenta.acreditar(monto);
            case PAGO -> cuenta.acreditar(monto);
            default -> throw new IllegalArgumentException("Tipo de transacción no soportado para reverso: " + tipoTransaccion);
        }

        this.estado = EstadoTransaccion.REVERSADA;
        this.descripcion = "Reversión: " + motivo;
        this.fechaProcesamiento = LocalDateTime.now();
    }

    public boolean estaCompletada() {
        return EstadoTransaccion.COMPLETADA.equals(this.estado);
    }

    public boolean estaPendiente() {
        return EstadoTransaccion.PENDIENTE.equals(this.estado);
    }

    public boolean puedeReversarse() {
        return estaCompletada() && fechaTransaccion.plusHours(24).isAfter(LocalDateTime.now());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getReferenciaExterna() {
        return referenciaExterna;
    }

    public void setReferenciaExterna(String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Cuenta.Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Cuenta.Moneda moneda) {
        this.moneda = moneda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoTransaccion getEstado() {
        return estado;
    }

    public void setEstado(EstadoTransaccion estado) {
        this.estado = estado;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public LocalDateTime getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDateTime fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public LocalDateTime getFechaProcesamiento() {
        return fechaProcesamiento;
    }

    public void setFechaProcesamiento(LocalDateTime fechaProcesamiento) {
        this.fechaProcesamiento = fechaProcesamiento;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(String codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaccion that = (Transaccion) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "id=" + id +
                ", referenciaExterna='" + referenciaExterna + '\'' +
                ", tipoTransaccion=" + tipoTransaccion +
                ", monto=" + monto +
                ", moneda=" + moneda +
                ", estado=" + estado +
                ", fechaTransaccion=" + fechaTransaccion +
                '}';
    }

    public enum TipoTransaccion {
        DEPOSITO, RETIRO, TRANSFERENCIA, PAGO, COMPRA
    }

    public enum EstadoTransaccion {
        PENDIENTE, COMPLETADA, RECHAZADA, REVERSADA, CANCELADA
    }
}