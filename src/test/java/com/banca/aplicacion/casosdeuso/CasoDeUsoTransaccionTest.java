package com.banca.aplicacion.casosdeuso;

import com.banca.dominio.entidades.Cliente;
import com.banca.dominio.entidades.Cuenta;
import com.banca.dominio.entidades.Transaccion;
import com.banca.dominio.repositorios.RepositorioCliente;
import com.banca.dominio.repositorios.RepositorioCuenta;
import com.banca.dominio.repositorios.RepositorioTransaccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class CasoDeUsoTransaccionTest {

    @Autowired
    private CasoDeUsoTransaccion casoDeUsoTransaccion;

    @Autowired
    private RepositorioCliente repositorioCliente;

    @Autowired
    private RepositorioCuenta repositorioCuenta;

    @Autowired
    private RepositorioTransaccion repositorioTransaccion;

    private Cliente clientePrueba;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;

    @BeforeEach
    void setUp() {
        repositorioTransaccion.deleteAll();
        repositorioCuenta.deleteAll();
        repositorioCliente.deleteAll();

        clientePrueba = new Cliente();
        clientePrueba.setId(UUID.randomUUID().toString());
        clientePrueba.setNombre("Juan Pérez");
        clientePrueba.setEmail("juan.perez@banca.com");
        clientePrueba.setTelefono("+5491155551234");
        repositorioCliente.guardar(clientePrueba);

        cuentaOrigen = new Cuenta();
        cuentaOrigen.setId(UUID.randomUUID().toString());
        cuentaOrigen.setNumero("ACC-001-000001");
        cuentaOrigen.setSaldo(new BigDecimal("5000.00"));
        cuentaOrigen.setTipo("CUENTA_CORRIENTE");
        cuentaOrigen.setClienteId(clientePrueba.getId());
        cuentaOrigen.setActiva(true);
        repositorioCuenta.guardar(cuentaOrigen);

        cuentaDestino = new Cuenta();
        cuentaDestino.setId(UUID.randomUUID().toString());
        cuentaDestino.setNumero("ACC-001-000002");
        cuentaDestino.setSaldo(new BigDecimal("1000.00"));
        cuentaDestino.setTipo("CAJA_AHORRO");
        cuentaDestino.setClienteId(clientePrueba.getId());
        cuentaDestino.setActiva(true);
        repositorioCuenta.guardar(cuentaDestino);
    }

    @Test
    @DisplayName("Debe realizar una transferencia exitosa entre cuentas")
    void debeRealizarTransferenciaExitosa() {
        BigDecimal montoTransferencia = new BigDecimal("1000.00");

        Optional<Transaccion> resultado = casoDeUsoTransaccion.realizarTransferencia(
                cuentaOrigen.getId(),
                cuentaDestino.getId(),
                montoTransferencia,
                "Transferencia de prueba"
        );

        assertThat(resultado).isPresent();

        Optional<Cuenta> cuentaOrigenActualizada = repositorioCuenta.buscarPorId(cuentaOrigen.getId());
        Optional<Cuenta> cuentaDestinoActualizada = repositorioCuenta.buscarPorId(cuentaDestino.getId());

        assertThat(cuentaOrigenActualizada).isPresent();
        assertThat(cuentaDestinoActualizada).isPresent();
        assertThat(cuentaOrigenActualizada.get().getSaldo())
                .isEqualByComparingTo(new BigDecimal("4000.00"));
        assertThat(cuentaDestinoActualizada.get().getSaldo())
                .isEqualByComparingTo(new BigDecimal("2000.00"));

        List<Transaccion> transacciones = repositorioTransaccion.buscarPorCuentaId(cuentaOrigen.getId());
        assertThat(transacciones).hasSize(1);
        assertThat(transacciones.get(0).getMonto())
                .isEqualByComparingTo(montoTransferencia.negate());
    }

    @Test
    @DisplayName("Debe rechazar transferencia por saldo insuficiente")
    void debeRechazarTransferenciaPorSaldoInsuficiente() {
        BigDecimal montoExcedente = new BigDecimal("6000.00");

        Optional<Transaccion> resultado = casoDeUsoTransaccion.realizarTransferencia(
                cuentaOrigen.getId(),
                cuentaDestino.getId(),
                montoExcedente,
                "Intento de transferencia fallida"
        );

        assertThat(resultado).isEmpty();

        Optional<Cuenta> cuentaOrigenActualizada = repositorioCuenta.buscarPorId(cuentaOrigen.getId());
        assertThat(cuentaOrigenActualizada).isPresent();
        assertThat(cuentaOrigenActualizada.get().getSaldo())
                .isEqualByComparingTo(new BigDecimal("5000.00"));
    }

    @Test
    @DisplayName("Debe rechazar transferencia desde cuenta inactiva")
    void debeRechazarTransferenciaDesdeCuentaInactiva() {
        cuentaOrigen.setActiva(false);
        repositorioCuenta.guardar(cuentaOrigen);

        BigDecimal monto = new BigDecimal("100.00");

        Optional<Transaccion> resultado = casoDeUsoTransaccion.realizarTransferencia(
                cuentaOrigen.getId(),
                cuentaDestino.getId(),
                monto,
                "Transferencia desde cuenta inactiva"
        );

        assertThat(resultado).isEmpty();
    }

    @Test
    @DisplayName("Debe rechazar transferencia a cuenta inactiva")
    void debeRechazarTransferenciaACuentaInactiva() {
        cuentaDestino.setActiva(false);
        repositorioCuenta.guardar(cuentaDestino);

        BigDecimal monto = new BigDecimal("100.00");

        Optional<Transaccion> resultado = casoDeUsoTransaccion.realizarTransferencia(
                cuentaOrigen.getId(),
                cuentaDestino.getId(),
                monto,
                "Transferencia a cuenta inactiva"
        );

        assertThat(resultado).isEmpty();
    }

    @Test
    @DisplayName("Debe registrar depósito exitoso")
    void debeRegistrarDepositoExitoso() {
        BigDecimal montoDeposito = new BigDecimal("2500.00");

        Optional<Transaccion> resultado = casoDeUsoTransaccion.realizarDeposito(
                cuentaDestino.getId(),
                montoDeposito,
                "Depósito de nómina"
        );

        assertThat(resultado).isPresent();
        assertThat(resultado.get().getMonto())
                .isEqualByComparingTo(montoDeposito);
        assertThat(resultado.get().getTipo())
                .isEqualTo("DEPOSITO");

        Optional<Cuenta> cuentaActualizada = repositorioCuenta.buscarPorId(cuentaDestino.getId());
        assertThat(cuentaActualizada).isPresent();
        assertThat(cuentaActualizada.get().getSaldo())
                .isEqualByComparingTo(new BigDecimal("3500.00"));
    }

    @Test
    @DisplayName("Debe registrar extracción exitosa")
    void debeRegistrarExtraccionExitosa() {
        BigDecimal montoExtraccion = new BigDecimal("500.00");

        Optional<Transaccion> resultado = casoDeUsoTransaccion.realizarExtraccion(
                cuentaOrigen.getId(),
                montoExtraccion,
                "Extracción en cajero"
        );

        assertThat(resultado).isPresent();
        assertThat(resultado.get().getMonto())
                .isEqualByComparingTo(montoExtraccion.negate());
        assertThat(resultado.get().getTipo())
                .isEqualTo("EXTRACCION");

        Optional<Cuenta> cuentaActualizada = repositorioCuenta.buscarPorId(cuentaOrigen.getId());
        assertThat(cuentaActualizada).isPresent();
        assertThat(cuentaActualizada.get().getSaldo())
                .isEqualByComparingTo(new BigDecimal("4500.00"));
    }

    @Test
    @DisplayName("Debe rechazar extracción por saldo insuficiente")
    void debeRechazarExtraccionPorSaldoInsuficiente() {
        BigDecimal montoExcedente = new BigDecimal("5500.00");

        Optional<Transaccion> resultado = casoDeUsoTransaccion.realizarExtraccion(
                cuentaOrigen.getId(),
                montoExcedente,
                "Intento de extracción fallido"
        );

        assertThat(resultado).isEmpty();

        Optional<Cuenta> cuentaActualizada = repositorioCuenta.buscarPorId(cuentaOrigen.getId());
        assertThat(cuentaActualizada).isPresent();
        assertThat(cuentaActualizada.get().getSaldo())
                .isEqualByComparingTo(new BigDecimal("5000.00"));
    }

    @Test
    @DisplayName("Debe consultar historial de transacciones de una cuenta")
    void debeConsultarHistorialDeTransacciones() {
        casoDeUsoTransaccion.realizarDeposito(cuentaOrigen.getId(), new BigDecimal("1000.00"), "Depósito 1");
        casoDeUsoTransaccion.realizarDeposito(cuentaOrigen.getId(), new BigDecimal("2000.00"), "Depósito 2");
        casoDeUsoTransaccion.realizarExtraccion(cuentaOrigen.getId(), new BigDecimal("500.00"), "Extracción 1");

        List<Transaccion> historial = casoDeUsoTransaccion.consultarHistorial(cuentaOrigen.getId());

        assertThat(historial).hasSize(3);
    }

    @Test
    @DisplayName("Debe retornar lista vacía para cuenta sin transacciones")
    void debeRetornarListaVaciaParaCuentaSinTransacciones() {
        List<Transaccion> historial = casoDeUsoTransaccion.consultarHistorial(cuentaOrigen.getId());
        assertThat(historial).isEmpty();
    }

    @Test
    @DisplayName("Debe rechazar transferencia a la misma cuenta")
    void debeRechazarTransferenciaAMismaCuenta() {
        BigDecimal monto = new BigDecimal("100.00");

        Optional<Transaccion> resultado = casoDeUsoTransaccion.realizarTransferencia(
                cuentaOrigen.getId(),
                cuentaOrigen.getId(),
                monto,
                "Transferencia a misma cuenta"
        );

        assertThat(resultado).isEmpty();
    }

    @Test
    @DisplayName("Debe rechazar monto negativo en transferencia")
    void debeRechazarMontoNegativoEnTransferencia() {
        BigDecimal montoNegativo = new BigDecimal("-100.00");

        Optional<Transaccion> resultado = casoDeUsoTransaccion.realizarTransferencia(
                cuentaOrigen.getId(),
                cuentaDestino.getId(),
                montoNegativo,
                "Transferencia con monto negativo"
        );

        assertThat(resultado).isEmpty();
    }
}