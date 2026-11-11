package com.banca.dominio.repositorios;

import com.banca.dominio.entidades.Transaccion;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositorioTransaccion {
    
    Optional<Transaccion> buscarPorId(UUID id);
    
    List<Transaccion> buscarTodos();
    
    Transaccion guardar(Transaccion transaccion);
    
    void eliminar(UUID id);
    
    boolean existePorId(UUID id);
    
    long contar();
    
    List<Transaccion> buscarPorCuentaId(UUID cuentaId);
    
    List<Transaccion> buscarPorCuentaIdYFechaBetween(UUID cuentaId, LocalDateTime fechaInicio, LocalDateTime fechaFin);
    
    List<Transaccion> buscarPorTipoTransaccion(String tipoTransaccion);
    
    Optional<Transaccion> buscarPorReferencia(String referencia);
    
    BigDecimal sumatoriaMontoPorCuentaYFecha(UUID cuentaId, LocalDateTime fechaInicio, LocalDateTime fechaFin);
    
    List<Transaccion> buscarUltimasTransaccionesPorCuenta(UUID cuentaId, int limite);
}