package com.banca.aplicacion.casosdeuso;


import com.banca.dominio.entidades.Cliente;
import com.banca.dominio.entidades.Cuenta;
import com.banca.dominio.repositorios.RepositorioCuenta;
import com.banca.dominio.repositorios.RepositorioCliente;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CasoDeUsoCuenta {

    private final RepositorioCuenta repositorioCuenta;
    private final RepositorioCliente repositorioCliente;

    public CasoDeUsoCuenta(RepositorioCuenta repositorioCuenta, RepositorioCliente repositorioCliente) {
        this.repositorioCuenta = repositorioCuenta;
        this.repositorioCliente = repositorioCliente;
    }

    public Cuenta abrirCuenta(String idCliente, String tipoCuenta, BigDecimal saldoInicial) {
        if (idCliente == null || idCliente.isBlank()) {
            throw new IllegalArgumentException("El ID del cliente es obligatorio");
        }
        
        Optional<com.banca.dominio.entidades.Cliente> cliente = repositorioCliente.buscarPorId(idCliente);
        if (cliente.isEmpty()) {
            throw new IllegalArgumentException("No existe el cliente con ID: " + idCliente);
        }
        
        if (!cliente.get().isActivo()) {
            throw new IllegalStateException("No se puede abrir una cuenta para un cliente inactivo");
        }
        
        if (tipoCuenta == null || tipoCuenta.isBlank()) {
            throw new IllegalArgumentException("El tipo de cuenta es obligatorio");
        }
        
        if (saldoInicial == null) {
            throw new IllegalArgumentException("El saldo inicial es obligatorio");
        }
        
        if (saldoInicial.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        
        String numeroCuenta = generarNumeroCuenta(tipoCuenta);
        
        Cuenta cuenta = new Cuenta(
            UUID.randomUUID().toString(),
            numeroCuenta,
            idCliente,
            tipoCuenta,
            saldoInicial,
            LocalDateTime.now(),
            true
        );
        
        return repositorioCuenta.guardar(cuenta);
    }

    public void cerrarCuenta(String idCuenta) {
        Optional<Cuenta> cuentaExistente = repositorioCuenta.buscarPorId(idCuenta);
        
        if (cuentaExistente.isEmpty()) {
            throw new IllegalArgumentException("Cuenta no encontrada con ID: " + idCuenta);
        }
        
        Cuenta cuenta = cuentaExistente.get();
        
        if (cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0) {
            throw new IllegalStateException("No se puede cerrar una cuenta con saldo pendiente");
        }
        
        cuenta.setActiva(false);
        repositorioCuenta.guardar(cuenta);
    }

    public Optional<Cuenta> buscarCuentaPorId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID de la cuenta no puede estar vacío");
        }
        return repositorioCuenta.buscarPorId(id);
    }

    public Optional<Cuenta> buscarCuentaPorNumero(String numeroCuenta) {
        if (numeroCuenta == null || numeroCuenta.isBlank()) {
            throw new IllegalArgumentException("El número de cuenta no puede estar vacío");
        }
        return repositorioCuenta.buscarPorNumero(numeroCuenta);
    }

    public List<Cuenta> listarCuentasDeCliente(String idCliente) {
        if (idCliente == null || idCliente.isBlank()) {
            throw new IllegalArgumentException("El ID del cliente es obligatorio");
        }
        return repositorioCuenta.buscarPorIdCliente(idCliente);
    }

    public List<Cuenta> listarTodasLasCuentas() {
        return repositorioCuenta.buscarTodos();
    }

    public List<Cuenta> listarCuentasActivas() {
        return repositorioCuenta.buscarCuentasActivas();
    }

    public void depositar(String idCuenta, BigDecimal monto) {
        Optional<Cuenta> cuentaExistente = repositorioCuenta.buscarPorId(idCuenta);
        
        if (cuentaExistente.isEmpty()) {
            throw new IllegalArgumentException("Cuenta no encontrada con ID: " + idCuenta);
        }
        
        Cuenta cuenta = cuentaExistente.get();
        
        if (!cuenta.isActiva()) {
            throw new IllegalStateException("No se puede depositar en una cuenta inactiva");
        }
        
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor que cero");
        }
        
        BigDecimal nuevoSaldo = cuenta.getSaldo().add(monto);
        cuenta.setSaldo(nuevoSaldo);
        repositorioCuenta.guardar(cuenta);
    }

    public void retirar(String idCuenta, BigDecimal monto) {
        Optional<Cuenta> cuentaExistente = repositorioCuenta.buscarPorId(idCuenta);
        
        if (cuentaExistente.isEmpty()) {
            throw new IllegalArgumentException("Cuenta no encontrada con ID: " + idCuenta);
        }
        
        Cuenta cuenta = cuentaExistente.get();
        
        if (!cuenta.isActiva()) {
            throw new IllegalStateException("No se puede retirar de una cuenta inactiva");
        }
        
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor que cero");
        }
        
        if (cuenta.getSaldo().compareTo(monto) < 0) {
            throw new IllegalStateException("Saldo insuficiente para realizar el retiro");
        }
        
        BigDecimal nuevoSaldo = cuenta.getSaldo().subtract(monto);
        cuenta.setSaldo(nuevoSaldo);
        repositorioCuenta.guardar(cuenta);
    }

    private String generarNumeroCuenta(String tipoCuenta) {
        String prefijo = tipoCuenta.substring(0, Math.min(3, tipoCuenta.length())).toUpperCase();
        String numeroAleatorio = UUID.randomUUID().toString().replace("-", "").substring(0, 10).toUpperCase();
        return prefijo + "-" + numeroAleatorio;
    }
}