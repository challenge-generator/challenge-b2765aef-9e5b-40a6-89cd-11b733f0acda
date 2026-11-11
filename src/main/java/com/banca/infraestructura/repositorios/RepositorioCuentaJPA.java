package com.banca.infraestructura.repositorios;

import com.banca.dominio.entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioCuentaJPA extends JpaRepository<Cuenta, Long> {

    Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);

    List<Cuenta> findByClienteId(Long clienteId);

    List<Cuenta> findByActivaTrue();

    List<Cuenta> findByActivaFalse();

    @Query("SELECT c FROM Cuenta c WHERE c.saldo >= :saldoMinimo AND c.saldo <= :saldoMaximo")
    List<Cuenta> buscarCuentasPorRangoSaldo(@Param("saldoMinimo") BigDecimal saldoMinimo, 
                                              @Param("saldoMaximo") BigDecimal saldoMaximo);

    @Query("SELECT c FROM Cuenta c WHERE c.fechaApertura >= :fechaInicio AND c.fechaApertura <= :fechaFin")
    List<Cuenta> buscarCuentasPorRangoFechas(@Param("fechaInicio") LocalDate fechaInicio, 
                                               @Param("fechaFin") LocalDate fechaFin);

    @Query("SELECT c FROM Cuenta c WHERE c.cliente.id = :clienteId AND c.activa = true")
    List<Cuenta> buscarCuentasActivasPorCliente(@Param("clienteId") Long clienteId);

    @Query("SELECT SUM(c.saldo) FROM Cuenta c WHERE c.cliente.id = :clienteId")
    BigDecimal calcularSaldoTotalPorCliente(@Param("clienteId") Long clienteId);

    @Query("SELECT c FROM Cuenta c WHERE c.tipoCuenta = :tipo")
    List<Cuenta> buscarPorTipo(@Param("tipo") String tipo);

    boolean existsByNumeroCuenta(String numeroCuenta);

    @Query("SELECT COUNT(c) FROM Cuenta c WHERE c.activa = true")
    long contarCuentasActivas();

    @Query("SELECT c FROM Cuenta c JOIN c.transacciones t WHERE t.id = :transaccionId")
    Optional<Cuenta> findByTransaccionId(@Param("transaccionId") Long transaccionId);
}