package com.banca.dominio.entidades;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Tests para la entidad Transaccion")
class TransaccionTest {

    @Nested
    @DisplayName("Creación de Transacción")
    class CreacionTransaccion {

        @Test
        @DisplayName("Debe crear una transacción de depósito con atributos válidos")
        void debeCrearTransaccionDeposito() {
            UUID id = UUID.randomUUID();
            String tipo = "DEPOSITO";
            BigDecimal monto = new BigDecimal("1500.00");
            UUID cuentaId = UUID.randomUUID();
            String descripcion = "Depósito de nómina";

            Transaccion transaccion = new Transaccion(id, tipo, monto, cuentaId, null, descripcion);

            assertThat(transaccion.getId()).isEqualTo(id);
            assertThat(transaccion.getTipo()).isEqualTo(tipo);
            assertThat(transaccion.getMonto()).isEqualByComparingTo(monto);
            assertThat(transaccion.getCuentaId()).isEqualTo(cuentaId);
            assertThat(transaccion.getCuentaDestinoId()).isNull();
            assertThat(transaccion.getDescripcion()).isEqualTo(descripcion);
            assertThat(transaccion.getFecha()).isNotNull();
        }

        @Test
        @DisplayName("Debe crear una transacción de transferencia con cuenta destino")
        void debeCrearTransaccionTransferencia() {
            UUID cuentaOrigenId = UUID.randomUUID();
            UUID cuentaDestinoId = UUID.randomUUID();

            Transaccion transaccion = new Transaccion(
                "TRANSFERENCIA",
                new BigDecimal("200.00"),
                cuentaOrigenId,
                cuentaDestinoId,
                "Pago de servicio"
            );

            assertThat(transaccion.getTipo()).isEqualTo("TRANSFERENCIA");
            assertThat(transaccion.getCuentaId()).isEqualTo(cuentaOrigenId);
            assertThat(transaccion.getCuentaDestinoId()).isEqualTo(cuentaDestinoId);
        }

        @Test
        @DisplayName("Debe generar fecha automáticamente si no se proporciona")
        void debeGenerarFechaAutomatica() {
            Transaccion transaccion = new Transaccion(
                "RETIRO",
                new BigDecimal("100.00"),
                UUID.randomUUID(),
                null,
                "Retiro en cajero"
            );

            LocalDateTime ahora = LocalDateTime.now();
            assertThat(transaccion.getFecha()).isBetween(
                ahora.minusSeconds(5),
                ahora.plusSeconds(5)
            );
        }
    }

    @Nested
    @DisplayName("Validación de atributos")
    class ValidacionAtributos {

        @ParameterizedTest
        @ValueSource(strings = {"", "   ", "TIPODESCONOCIDO", "deposito", "transfer"})
        @DisplayName("Debe rechazar tipo de transacción no válido")
        void debeRechazarTipoInvalido(String tipoInvalido) {
            assertThatThrownBy(() -> new Transaccion(
                tipoInvalido,
                new BigDecimal("100.00"),
                UUID.randomUUID(),
                null,
                "Test"
            )).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("tipo");
        }

        @Test
        @DisplayName("Debe rechazar monto cero o negativo")
        void debeRechazarMontoInvalido() {
            assertThatThrownBy(() -> new Transaccion(
                "DEPOSITO",
                BigDecimal.ZERO,
                UUID.randomUUID(),
                null,
                "Test"
            )).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("monto");

            assertThatThrownBy(() -> new Transaccion(
                "RETIRO",
                new BigDecimal("-50.00"),
                UUID.randomUUID(),
                null,
                "Test"
            )).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("monto");
        }

        @Test
        @DisplayName("Debe rechazar cuenta origen nula")
        void debeRechazarCuentaOrigenNula() {
            assertThatThrownBy(() -> new Transaccion(
                "DEPOSITO",
                new BigDecimal("100.00"),
                null,
                null,
                "Test"
            )).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("cuenta");
        }

        @Test
        @DisplayName("Debe requerir cuenta destino para transferencias")
        void debeRequerirCuentaDestinoParaTransferencia() {
            assertThatThrownBy(() -> new Transaccion(
                "TRANSFERENCIA",
                new BigDecimal("100.00"),
                UUID.randomUUID(),
                null,
                "Test"
            )).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("destino");
        }
    }

    @Nested
    @DisplayName("Integridad referencial")
    class IntegridadReferencial {

        @Test
        @DisplayName("Debe mantener la relación con cuenta origen")
        void debeMantenerRelacionCuentaOrigen() {
            UUID cuentaId = UUID.randomUUID();
            Transaccion transaccion = new Transaccion(
                "DEPOSITO",
                new BigDecimal("500.00"),
                cuentaId,
                null,
                "Test"
            );

            assertThat(transaccion.getCuentaId()).isEqualTo(cuentaId);
        }

        @Test
        @DisplayName("Debe mantener la relación con cuenta destino en transferencias")
        void debeMantenerRelacionCuentaDestino() {
            UUID cuentaOrigenId = UUID.randomUUID();
            UUID cuentaDestinoId = UUID.randomUUID();
            Transaccion transaccion = new Transaccion(
                "TRANSFERENCIA",
                new BigDecimal("300.00"),
                cuentaOrigenId,
                cuentaDestinoId,
                "Test"
            );

            assertThat(transaccion.getCuentaDestinoId()).isEqualTo(cuentaDestinoId);
        }

        @ParameterizedTest
        @CsvSource({
            "DEPOSITO, false",
            "RETIRO, false",
            "TRANSFERENCIA, true",
            "PAGO, false"
        })
        @DisplayName("Debe identificar correctamente si es transferencia")
        void debeIdentificarSiEsTransferencia(String tipo, boolean esTransferencia) {
            UUID cuentaOrigen = UUID.randomUUID();
            UUID cuentaDestino = esTransferencia ? UUID.randomUUID() : null;

            Transaccion transaccion = new Transaccion(
                tipo,
                new BigDecimal("100.00"),
                cuentaOrigen,
                cuentaDestino,
                "Test"
            );

            assertThat(transaccion.esTransferencia()).isEqualTo(esTransferencia);
        }

        @Test
        @DisplayName("No debe permitir transferencia a la misma cuenta")
        void debeRechazarTransferenciaMismaCuenta() {
            UUID cuentaId = UUID.randomUUID();

            assertThatThrownBy(() -> new Transaccion(
                "TRANSFERENCIA",
                new BigDecimal("100.00"),
                cuentaId,
                cuentaId,
                "Test"
            )).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("misma cuenta");
        }
    }

    @Nested
    @DisplayName("Comportamiento de negocio")
    class ComportamientoNegocio {

        @Test
        @DisplayName("Debe calcular correctamente el signo del monto según tipo")
        void debeCalcularSignoSegunTipo() {
            Transaccion deposito = new Transaccion(
                "DEPOSITO",
                new BigDecimal("1000.00"),
                UUID.randomUUID(),
                null,
                "Depósito"
            );

            Transaccion retiro = new Transaccion(
                "RETIRO",
                new BigDecimal("500.00"),
                UUID.randomUUID(),
                null,
                "Retiro"
            );

            assertThat(deposito.getMonto()).isPositive();
            assertThat(retiro.getMonto()).isPositive();
        }

        @Test
        @DisplayName("Dos transacciones con mismo ID deben ser iguales")
        void debeCompararPorId() {
            UUID id = UUID.randomUUID();
            Transaccion t1 = new Transaccion(id, "DEPOSITO", new BigDecimal("100"), UUID.randomUUID(), null, "Test");
            Transaccion t2 = new Transaccion(id, "RETIRO", new BigDecimal("200"), UUID.randomUUID(), null, "Otro");

            assertThat(t1).isEqualTo(t2);
        }

        @Test
        @DisplayName("HashCode debe ser consistente con equals")
        void debeGenerarHashCodeConsistente() {
            UUID id = UUID.randomUUID();
            Transaccion t1 = new Transaccion(id, "DEPOSITO", new BigDecimal("100"), UUID.randomUUID(), null, "Test");
            Transaccion t2 = new Transaccion(id, "RETIRO", new BigDecimal("200"), UUID.randomUUID(), null, "Otro");

            assertThat(t1.hashCode()).isEqualTo(t2.hashCode());
        }
    }
}