package com.banca.aplicacion.casosdeuso;

import com.banca.dominio.entidades.Cuenta;
import com.banca.dominio.entidades.Transaccion;
import com.banca.dominio.repositorios.RepositorioCuenta;
import com.banca.dominio.repositorios.RepositorioTransaccion;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CasoDeUsoTransaccion {

    private final RepositorioTransaccion repositorioTransaccion;
    private final RepositorioCuenta repositorioCuenta;

    public CasoDeUsoTransaccion(RepositorioTransaccion repositorioTransaccion, RepositorioCuenta repositorioCuenta) {
        this.repositorioTransaccion = repositorioTransaccion;
        this.repositorioCuenta = repositorioCuenta;
    }

    public Transaccion realizarTransferencia(String idCuentaOrigen, String idCuentaDestino, BigDecimal monto, String descripcion) {
        validarTransferencia(idCuentaOrigen, idCuentaDestino, monto);
        
        Optional<Cuenta> cuentaOrigenOpt = repositorioCuenta.buscarPorId(idCuentaOrigen);
        Optional<Cuenta> cuentaDestinoOpt = repositorioCuenta.buscarPorId(idCuentaDestino);
        
        Cuenta cuentaOrigen = cuentaOrigenOpt.get();
        Cuenta cuentaDestino = cuentaDestinoOpt.get();
        
        if (cuentaOrigen.getSaldo().compareTo(monto) < 0) {
            throw new IllegalStateException("Saldo insuficiente en la cuenta de origen para la transferencia");
        }
        
        BigDecimal nuevoSaldoOrigen = cuentaOrigen.getSaldo().subtract(monto);
        cuentaOrigen.setSaldo(nuevoSaldoOrigen);
        repositorioCuenta.guardar(cuentaOrigen);
        
        BigDecimal nuevoSaldoDestino = cuentaDestino.getSaldo().add(monto);
        cuentaDestino.setSaldo(nuevoSaldoDestino);
        repositorioCuenta.guardar(cuentaDestino);
        
        String idTransaccion = UUID.randomUUID().toString();
        LocalDateTime ahora = LocalDateTime.now();
        
        Transaccion transaccionOrigen = new Transaccion(
            idTransaccion,
            idCuentaOrigen,
            "TRANSFERENCIA_ENVIADA",
            monto.negate(),
            cuentaOrigen.getSaldo(),
            ahora,
            descripcion != null ? descripcion : "Transferencia enviada"
        );
        
        Transaccion transaccionDestino = new Transaccion(
            UUID.randomUUID().toString(),
            idCuentaDestino,
            "TRANSFERENCIA_RECIBIDA",
            monto,
            cuentaDestino.getSaldo(),
            ahora,
            descripcion != null ? descripcion : "Transferencia recibida"
        );
        
        repositorioTransaccion.guardar(transaccionOrigen);
        repositorioTransaccion.guardar(transaccionDestino);
        
        return transaccionOrigen;
    }

    public Transaccion registrarDeposito(String idCuenta, BigDecimal monto, String descripcion) {
        Optional<Cuenta> cuentaOpt = repositorioCuenta.buscarPorId(idCuenta);
        
        if (cuentaOpt.isEmpty()) {
            throw new IllegalArgumentException("Cuenta no encontrada con ID: " + idCuenta);
        }
        
        Cuenta cuenta = cuentaOpt.get();
        
        if (!cuenta.isActiva()) {
            throw new IllegalStateException("No se puede depositar en una cuenta inactiva");
        }
        
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto del depósito debe ser mayor que cero");
        }
        
        BigDecimal nuevoSaldo = cuenta.getSaldo().add(monto);
        cuenta.setSaldo(nuevoSaldo);
        repositorioCuenta.guardar(cuenta);
        
        Transaccion transaccion = new Transaccion(
            UUID.randomUUID().toString(),
            idCuenta,
            "DEPOSITO",
            monto,
            nuevoSaldo,
            LocalDateTime.now(),
            descripcion != null ? descripcion : "Depósito en efectivo"
        );
        
        return repositorioTransaccion.guardar(transaccion);
    }

    public Transaccion registrarRetiro(String idCuenta, BigDecimal monto, String descripcion) {
        Optional<Cuenta> cuentaOpt = repositorioCuenta.buscarPorId(idCuenta);
        
        if (cuentaOpt.isEmpty()) {
            throw new IllegalArgumentException("Cuenta no encontrada con ID: " + idCuenta);
        }
        
        Cuenta cuenta = cuentaOpt.get();
        
        if (!cuenta.isActiva()) {
            throw new IllegalStateException("No se puede retirar de una cuenta inactiva");
        }
        
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto del retiro debe ser mayor que cero");
        }
        
        if (cuenta.getSaldo().compareTo(monto) < 0) {
            throw new IllegalStateException("Saldo insuficiente para realizar el retiro");
        }
        
        BigDecimal nuevoSaldo = cuenta.getSaldo().subtract(monto);
        cuenta.setSaldo(nuevoSaldo);
        repositorioCuenta.guardar(cuenta);
        
        Transaccion transaccion = new Transaccion(
            UUID.randomUUID().toString(),
            idCuenta,
            "RETIRO",
            monto.negate(),
            nuevoSaldo,
            LocalDateTime.now(),
            descripcion != null ? descripcion : "Retiro en efectivo"
        );
        
        return repositorioTransaccion.guardar(transaccion);
    }

    public List<Transaccion> listarTransaccionesDeCuenta(String idCuenta) {
        if (idCuenta == null || idCuenta.isBlank()) {
            throw new IllegalArgumentException("El ID de la cuenta es obligatorio");
        }
        
        Optional<Cuenta> cuentaOpt = repositorioCuenta.buscarPorId(idCuenta);
        if (cuentaOpt.isEmpty()) {
            throw new IllegalArgumentException("Cuenta no encontrada con ID: " + idCuenta);
        }
        
        return repositorioTransaccion.buscarPorIdCuenta(idCuenta);
    }

    public Optional<Transaccion> buscarTransaccionPorId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID de la transacción no puede estar vacío");
        }
        return repositorioTransaccion.buscarPorId(id);
    }

    public List<Transaccion> listarTransaccionesPorTipo(String idCuenta, String tipo) {
        if (idCuenta == null || idCuenta.isBlank()) {
            throw new IllegalArgumentException("El ID de la cuenta es obligatorio");
        }
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("El tipo de transacción es obligatorio");
        }
        return repositorioTransaccion.buscarPorIdCuentaYTipo(idCuenta, tipo);
    }

    private void validarTransferencia(String idCuentaOrigen, String idCuentaDestino, BigDecimal monto) {
        if (idCuentaOrigen == null || idCuentaOrigen.isBlank()) {
            throw new IllegalArgumentException("El ID de la cuenta de origen es obligatorio");
        }
        if (idCuentaDestino == null || idCuentaDestino.isBlank()) {
            throw new IllegalArgumentException("El ID de la cuenta de destino es obligatorio");
        }
        if (idCuentaOrigen.equals(idCuentaDestino)) {
            throw new IllegalArgumentException("No se puede realizar una transferencia a la misma cuenta");
        }
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto de la transferencia debe ser mayor que cero");
        }
        
        Optional<Cuenta> cuentaOrigenOpt = repositorioCuenta.buscarPorId(idCuentaOrigen);
        Optional<Cuenta> cuentaDestinoOpt = repositorioCuenta.buscarPorId(idCuentaDestino);
        
        if (cuentaOrigenOpt.isEmpty()) {
            throw new IllegalArgumentException("Cuenta de origen no encontrada");
        }
        if (cuentaDestinoOpt.isEmpty()) {
            throw new IllegalArgumentException("Cuenta de destino no encontrada");
        }
        
        if (!cuentaOrigenOpt.get().isActiva()) {
            throw new IllegalStateException("La cuenta de origen está inactiva");
        }
        if (!cuentaDestinoOpt.get().isActiva()) {
            throw new IllegalStateException("La cuenta de destino está inactiva");
        }
    }
}