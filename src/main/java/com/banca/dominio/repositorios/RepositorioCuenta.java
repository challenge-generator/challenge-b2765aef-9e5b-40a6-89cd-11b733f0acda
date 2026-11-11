package com.banca.dominio.repositorios;

import com.banca.dominio.entidades.Cuenta;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositorioCuenta {
    
    Optional<Cuenta> buscarPorId(UUID id);
    
    List<Cuenta> buscarTodos();
    
    Cuenta guardar(Cuenta cuenta);
    
    void eliminar(UUID id);
    
    boolean existePorId(UUID id);
    
    long contar();
    
    Optional<Cuenta> buscarPorNumeroCuenta(String numeroCuenta);
    
    List<Cuenta> buscarPorClienteId(UUID clienteId);
    
    List<Cuenta> buscarPorTipoCuenta(String tipoCuenta);
    
    List<Cuenta> buscarPorEstado(String estado);
    
    boolean existePorNumeroCuenta(String numeroCuenta);
    
    List<Cuenta> buscarCuentasConSaldoMayorQue(BigDecimal saldo);
    
    List<Cuenta> buscarCuentasConSaldoMenorQue(BigDecimal saldo);
}