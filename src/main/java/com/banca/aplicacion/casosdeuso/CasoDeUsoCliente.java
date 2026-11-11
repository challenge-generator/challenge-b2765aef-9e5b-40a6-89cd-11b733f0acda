package com.banca.aplicacion.casosdeuso;

import com.banca.dominio.entidades.Cliente;
import com.banca.dominio.repositorios.RepositorioCliente;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CasoDeUsoCliente {

    private final RepositorioCliente repositorioCliente;

    public CasoDeUsoCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Cliente registrarCliente(String nombre, String correo, String telefono, String direccion) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del cliente es obligatorio");
        }
        if (correo == null || correo.isBlank()) {
            throw new IllegalArgumentException("El correo del cliente es obligatorio");
        }
        if (!correo.contains("@")) {
            throw new IllegalArgumentException("El correo debe tener un formato válido");
        }
        
        Cliente cliente = new Cliente(
            UUID.randomUUID().toString(),
            nombre,
            correo,
            telefono,
            direccion,
            java.time.LocalDateTime.now(),
            true
        );
        
        return repositorioCliente.guardar(cliente);
    }

    public Cliente actualizarCliente(String id, String nombre, String correo, String telefono, String direccion) {
        Optional<Cliente> clienteExistente = repositorioCliente.buscarPorId(id);
        
        if (clienteExistente.isEmpty()) {
            throw new IllegalArgumentException("Cliente no encontrado con ID: " + id);
        }
        
        Cliente cliente = clienteExistente.get();
        
        if (nombre != null && !nombre.isBlank()) {
            cliente.setNombre(nombre);
        }
        if (correo != null && !correo.isBlank()) {
            if (!correo.contains("@")) {
                throw new IllegalArgumentException("El correo debe tener un formato válido");
            }
            cliente.setCorreo(correo);
        }
        if (telefono != null) {
            cliente.setTelefono(telefono);
        }
        if (direccion != null) {
            cliente.setDireccion(direccion);
        }
        
        return repositorioCliente.guardar(cliente);
    }

    public Optional<Cliente> buscarClientePorId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID del cliente no puede estar vacío");
        }
        return repositorioCliente.buscarPorId(id);
    }

    public List<Cliente> listarTodosLosClientes() {
        return repositorioCliente.buscarTodos();
    }

    public List<Cliente> buscarClientesPorNombre(String nombreParcial) {
        if (nombreParcial == null || nombreParcial.isBlank()) {
            return repositorioCliente.buscarTodos();
        }
        return repositorioCliente.buscarPorNombreContiene(nombreParcial);
    }

    public void desactivarCliente(String id) {
        Optional<Cliente> clienteExistente = repositorioCliente.buscarPorId(id);
        
        if (clienteExistente.isEmpty()) {
            throw new IllegalArgumentException("Cliente no encontrado con ID: " + id);
        }
        
        Cliente cliente = clienteExistente.get();
        cliente.setActivo(false);
        repositorioCliente.guardar(cliente);
    }

    public void activarCliente(String id) {
        Optional<Cliente> clienteExistente = repositorioCliente.buscarPorId(id);
        
        if (clienteExistente.isEmpty()) {
            throw new IllegalArgumentException("Cliente no encontrado con ID: " + id);
        }
        
        Cliente cliente = clienteExistente.get();
        cliente.setActivo(true);
        repositorioCliente.guardar(cliente);
    }
}