package com.banca.dominio.entidades;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Tests para la entidad Cuenta")
class CuentaTest {

    @Nested
    @DisplayName("Creación de Cuenta")
    class CreacionCuenta {

        @Test
        @DisplayName("Debe crear una cuenta con todos los atributos válidos")
        void debeCrearCuentaConAtributosValidos() {
            UUID id = UUID.randomUUID();
            String numeroCuenta = "ES9121000418450200051332";
            String tipoCuenta = "AHORRO";
            BigDecimal saldoInicial = new BigDecimal("1000.00");
            UUID clienteId = UUID.randomUUID();

            Cuenta cuenta = new Cuenta(id, numeroCuenta, tipoCuenta, saldoInicial, clienteId);

            assertThat(cuenta.getId()).isEqualTo(id);
            assertThat(cuenta.getNumeroCuenta()).isEqualTo(numeroCuenta);
            assertThat(cuenta.getTipoCuenta()).isEqualTo(tipoCuenta);
            assertThat(cuenta.getSaldo()).isEqualByComparingTo(saldoInicial);
            assertThat(cuenta.getClienteId()).isEqualTo(clienteId);
            assertThat(cuenta.isActiva()).isTrue();
        }

        @Test
        @DisplayName("Debe crear cuenta con saldo cero por defecto")
        void debeCrearCuentaConSaldoCero() {
            Cuenta cuenta = new Cuenta(
                "ES9121000418450200051333",
                "CORRIENTE",
                UUID.randomUUID()
            );

            assertThat(cuenta.getSaldo()).isEqualByComparingTo(BigDecimal.ZERO);
            assertThat(cuenta.isActiva()).isTrue();
        }
    }

    @Nested
    @DisplayName("Validación de atributos")
    class ValidacionAtributos {

        @ParameterizedTest
        @ValueSource(strings = {"", "   ", "123", "ES00"})
        @DisplayName("Debe rechazar número de cuenta con formato IBAN inválido")
        void debeRechazarNumeroCuentaInvalido(String numeroInvalido) {
            assertThatThrownBy(() -> new Cuenta(
                numeroInvalido,
                "AHORRO",
                UUID.randomUUID()
            )).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("número de cuenta");
        }

        @ParameterizedTest
        @ValueSource(strings = {"", "   ", "TIPODESCONOCIDO", "ahorro"})
        @DisplayName("Debe rechazar tipo de cuenta no válido")
        void debeRechazarTipoCuentaInvalido(String tipoInvalido) {
            assertThatThrownBy(() -> new Cuenta(
                "ES9121000418450200051334",
                tipoInvalido,
                UUID.randomUUID()
            )).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("tipo de cuenta");
        }

        @Test
        @DisplayName("Debe rechazar saldo negativo")
        void debeRechazarSaldoNegativo() {
            BigDecimal saldoNegativo = new BigDecimal("-100.00");

            assertThatThrownBy(() -> new Cuenta(
                UUID.randomUUID(),
                "ES9121000418450200051335",
                "AHORRO",
                saldoNegativo,
                UUID.randomUUID()
            )).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("saldo");
        }

        @Test
        @DisplayName("Debe rechazar cliente ID nulo")
        void debeRechazarClienteIdNulo() {
            assertThatThrownBy(() -> new Cuenta(
                "ES9121000418450200051336",
                "AHORRO",
                null
            )).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("cliente");
        }
    }

    @Nested
    @DisplayName("Operaciones de cuenta")
    class OperacionesCuenta {

        @Test
        @DisplayName("Debe permitir depósitos positivos")
        void debePermitirDepositos() {
            Cuenta cuenta = new Cuenta(
                "ES9121000418450200051337",
                "AHORRO",
                UUID.randomUUID()
            );
            BigDecimal deposito = new BigDecimal("500.00");

            cuenta.depositar(deposito);

            assertThat(cuenta.getSaldo()).isEqualByComparingTo(new BigDecimal("500.00"));
        }

        @Test
        @DisplayName("Debe rechazar depósitos negativos o cero")
        void debeRechazarDepositosInvalidos() {
            Cuenta cuenta = new Cuenta(
                "ES9121000418450200051338",
                "AHORRO",
                UUID.randomUUID()
            );

            assertThatThrownBy(() -> cuenta.depositar(BigDecimal.ZERO))
                .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> cuenta.depositar(new BigDecimal("-100")))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("Debe permitir retiros cuando hay saldo suficiente")
        void debePermitirRetiros() {
            Cuenta cuenta = new Cuenta(
                UUID.randomUUID(),
                "ES9121000418450200051339",
                "AHORRO",
                new BigDecimal("1000.00"),
                UUID.randomUUID()
            );
            BigDecimal retiro = new BigDecimal("300.00");

            cuenta.retirar(retiro);

            assertThat(cuenta.getSaldo()).isEqualByComparingTo(new BigDecimal("700.00"));
        }

        @Test
        @DisplayName("Debe rechazar retiro que exceda el saldo")
        void debeRechazarRetiroMayorQueSaldo() {
            Cuenta cuenta = new Cuenta(
                "ES9121000418450200051340",
                "AHORRO",
                UUID.randomUUID()
            );

            assertThatThrownBy(() -> cuenta.retirar(new BigDecimal("100.00")))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("saldo");
        }

        @Test
        @DisplayName("No debe permitir retiros de cuentas inactivas")
        void debeRechazarRetiroDeCuentaInactiva() {
            Cuenta cuenta = new Cuenta(
                "ES9121000418450200051341",
                "AHORRO",
                UUID.randomUUID()
            );
            cuenta.desactivar();

            assertThatThrownBy(() -> cuenta.retirar(new BigDecimal("50.00")))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("inactiva");
        }
    }

    @Nested
    @DisplayName("Integridad referencial simulada")
    class IntegridadReferencial {

        @Test
        @DisplayName("Debe verificar que el cliente asociado existe lógicamente")
        void debeVerificarClienteAsociado() {
            UUID clienteId = UUID.randomUUID();
            Cuenta cuenta = new Cuenta(
                "ES9121000418450200051342",
                "CORRIENTE",
                clienteId
            );

            assertThat(cuenta.getClienteId()).isNotNull();
            assertThat(cuenta.getClienteId()).isEqualTo(clienteId);
        }

        @ParameterizedTest
        @CsvSource({
            "ES9121000418450200051343, AHORRO",
            "ES9121000418450200051344, CORRIENTE",
            "ES9121000418450200051345, PLAZO"
        })
        @DisplayName("Debe aceptar tipos de cuenta válidos del dominio bancario")
        void debeAceptarTiposValidos(String numero, String tipo) {
            Cuenta cuenta = new Cuenta(numero, tipo, UUID.randomUUID());

            assertThat(cuenta.getTipoCuenta()).isEqualTo(tipo);
        }
    }
}