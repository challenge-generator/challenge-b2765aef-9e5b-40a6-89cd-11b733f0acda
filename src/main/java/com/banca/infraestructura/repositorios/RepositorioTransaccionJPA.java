package com.banca.infraestructura.repositorios;

import com.banca.dominio.entidades.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioTransaccionJPA extends JpaRepository<Transaccion, Long> {

    List<Transaccion> findByCuentaOrigenId(Long cuentaOrigenId);

    List<Transaccion> findByCuentaDestinoId(Long cuentaDestinoId);

    @Query("SELECT t FROM Transaccion t WHERE t.cuentaOrigen.id = :cuentaId OR t.cuentaDestino.id = :cuentaId")
    List<Transaccion> findAllByCuentaId(@Param("cuentaId") Long cuentaId);

    @Query("SELECT t FROM Transaccion t WHERE t.fechaTransaccion >= :inicio AND t.fechaTransaccion <= :fin")
    List<Transaccion> buscarPorRangoFechas(@Param("inicio") LocalDateTime inicio, 
                                            @Param("fin") LocalDateTime fin);

    @Query("SELECT t FROM Transaccion t WHERE t.cuentaOrigen.id = :cuentaId AND t.fechaTransaccion >= :inicio AND t.fechaTransaccion <= :fin")
    List<Transaccion> buscarPorCuentaYRangoFechas(@Param("cuentaId") Long cuentaId, 
                                                    @Param("inicio") LocalDateTime inicio, 
                                                    @Param("fin") LocalDateTime fin);

    @Query("SELECT t FROM Transaccion t WHERE t.tipo = :tipo")
    List<Transaccion> buscarPorTipo(@Param("tipo") String tipo);

    @Query("SELECT t FROM Transaccion t WHERE t.monto >= :montoMinimo")
    List<Transaccion> buscarPorMontoMayorA(@Param("montoMinimo") BigDecimal montoMinimo);

    @Query("SELECT SUM(t.monto) FROM Transaccion t WHERE t.cuentaOrigen.id = :cuentaId AND t.tipo = 'DEBITO'")
    BigDecimal sumatoriaDebitosPorCuenta(@Param("cuentaId") Long cuentaId);

    @Query("SELECT SUM(t.monto) FROM Transaccion t WHERE t.cuentaDestino.id = :cuentaId AND t.tipo = 'CREDITO'")
    BigDecimal sumatoriaCreditosPorCuenta(@Param("cuentaId") Long cuentaId);

    @Query("SELECT t FROM Transaccion t WHERE t.estado = :estado")
    List<Transaccion> buscarPorEstado(@Param("estado") String estado);

    @Query("SELECT t FROM Transaccion t WHERE t.referencia like %:referenciaParcial%")
    List<Transaccion> buscarPorReferenciaParcial(@Param("referenciaParcial") String referenciaParcial);

    @Query("SELECT COUNT(t) FROM Transaccion t WHERE t.fechaTransaccion >= :inicio AND t.fechaTransaccion <= :fin")
    long contarTransaccionesEnRango(@Param("inicio") LocalDateTime inicio, 
                                     @Param("fin") LocalDateTime fin);

    @Query("SELECT t FROM Transaccion t WHERE t.cuentaOrigen.id = :cuentaId ORDER BY t.fechaTransaccion DESC")
    List<Transaccion> findUltimasTransaccionesOrigen(@Param("cuentaId") Long cuentaId);

    @Query("SELECT t FROM Transaccion t WHERE t.cuentaDestino.id = :cuentaId ORDER BY t.fechaTransaccion DESC")
    List<Transaccion> findUltimasTransaccionesDestino(@Param("cuentaId") Long cuentaId);
}