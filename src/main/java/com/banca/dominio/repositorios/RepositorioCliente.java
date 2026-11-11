package com.banca.dominio.repositorios;

import com.banca.dominio.entidades.Cliente;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositorioCliente {
    
    Optional<Cliente> buscarPorId(UUID id);
    
    List<Cliente> buscarTodos();
    
    Cliente guardar(Cliente cliente);
    
    void eliminar(UUID id);
    
    boolean existePorId(UUID id);
    
    long contar();
    
    Optional<Cliente> buscarPorNumeroDocumento(String numeroDocumento);
    
    List<Cliente> buscarPorTipoDocumento(String tipoDocumento);
    
    List<Cliente> buscarPorEstado(String estado);
    
    boolean existePorNumeroDocumento(String numeroDocumento);
}