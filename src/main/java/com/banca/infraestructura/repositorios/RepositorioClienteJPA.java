package com.banca.infraestructura.repositorios;

import com.banca.dominio.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioClienteJPA extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByIdentificacion(String identificacion);

    Optional<Cliente> findByCorreoElectronico(String correoElectronico);

    List<Cliente> findByActivoTrue();

    List<Cliente> findByActivoFalse();

    @Query("SELECT c FROM Cliente c WHERE c.nombre LIKE %:nombreParcial%")
    List<Cliente> buscarPorNombreParcial(@Param("nombreParcial") String nombreParcial);

    @Query("SELECT c FROM Cliente c JOIN c.cuentas cuenta WHERE cuenta.saldo > :saldoMinimo")
    List<Cliente> buscarClientesConCuentasSaldoMayorA(@Param("saldoMinimo") java.math.BigDecimal saldoMinimo);

    boolean existsByIdentificacion(String identificacion);

    boolean existsByCorreoElectronico(String correoElectronico);

    @Query("SELECT COUNT(c) FROM Cliente c WHERE c.activo = true")
    long contarClientesActivos();
}