package com.banca.dominio.entidades;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "cuentas", indexes = {
    @Index(name = "idx_cuenta_numero", columnList = "numero_cuenta", unique = true),
    @Index(name = "idx_cuenta_cliente", columnList = "cliente_id")
})
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "numero_cuenta", nullable = false, unique = true, length = 20)
    private String numeroCuenta;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cuenta", nullable = false, length = 15)
    private TipoCuenta tipoCuenta;

    @Column(name = "saldo", nullable = false, precision = 19, scale = 4)
    private BigDecimal saldo;

    @Column(name = "saldo_minimo", precision = 19, scale = 4)
    private BigDecimal saldoMinimo;

    @Column(name = "limite_credito", precision = 19, scale = 4)
    private BigDecimal limiteCredito;

    @Enumerated(EnumType.STRING)
    @Column(name = "moneda", nullable = false, length = 3)
    private Moneda moneda;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 15)
    private EstadoCuenta estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;

    @Column(name = "fecha_ultima_operacion")
    private LocalDateTime fechaUltimaOperacion;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaccion> transacciones = new ArrayList<>();

    public Cuenta() {
    }

    public Cuenta(String numeroCuenta, TipoCuenta tipoCuenta, Cliente cliente, Moneda moneda) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.cliente = cliente;
        this.moneda = moneda;
        this.saldo = BigDecimal.ZERO;
        this.estado = EstadoCuenta.ACTIVA;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = LocalDateTime.now();
    }

    @PrePersist
    protected void onCreate() {
        if (fechaCreacion == null) {
            fechaCreacion = LocalDateTime.now();
        }
        if (fechaActualizacion == null) {
            fechaActualizacion = LocalDateTime.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now();
    }

    public void acreditar(BigDecimal monto) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a acreditar debe ser mayor a cero");
        }
        this.saldo = this.saldo.add(monto);
        this.fechaUltimaOperacion = LocalDateTime.now();
    }

    public void debitar(BigDecimal monto) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a debitar debe ser mayor a cero");
        }
        BigDecimal saldoDisponible = obtenerSaldoDisponible();
        if (saldoDisponible.compareTo(monto) < 0) {
            throw new IllegalStateException("Saldo insuficiente para debitar");
        }
        this.saldo = this.saldo.subtract(monto);
        this.fechaUltimaOperacion = LocalDateTime.now();
    }

    public BigDecimal obtenerSaldoDisponible() {
        BigDecimal disponible = saldo;
        if (limiteCredito != null) {
            disponible = disponible.add(limiteCredito);
        }
        return disponible;
    }

    public boolean puedeDebitar(BigDecimal monto) {
        return obtenerSaldoDisponible().compareTo(monto) >= 0;
    }

    public boolean estaActiva() {
        return EstadoCuenta.ACTIVA.equals(this.estado);
    }

    public void cerrar() {
        if (saldo.compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalStateException("No se puede cerrar una cuenta con saldo diferente de cero");
        }
        this.estado = EstadoCuenta.CERRADA;
    }

    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
        transaccion.setCuenta(this);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldoMinimo() {
        return saldoMinimo;
    }

    public void setSaldoMinimo(BigDecimal saldoMinimo) {
        this.saldoMinimo = saldoMinimo;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public EstadoCuenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoCuenta estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public LocalDateTime getFechaUltimaOperacion() {
        return fechaUltimaOperacion;
    }

    public void setFechaUltimaOperacion(LocalDateTime fechaUltimaOperacion) {
        this.fechaUltimaOperacion = fechaUltimaOperacion;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return Objects.equals(id, cuenta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", tipoCuenta=" + tipoCuenta +
                ", saldo=" + saldo +
                ", moneda=" + moneda +
                ", estado=" + estado +
                '}';
    }

    public enum TipoCuenta {
        AHORROS, CORRIENTE, PLAZO_FIJO, VIRTUAL
    }

    public enum Moneda {
        USD, EUR, COP
    }

    public enum EstadoCuenta {
        ACTIVA, INACTIVA, CERRADA, BLOQUEADA
    }
}