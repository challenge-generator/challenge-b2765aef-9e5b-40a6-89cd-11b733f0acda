package com.banca.dominio.entidades;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Tests para la entidad Cliente")
class ClienteTest {

    @Nested
    @DisplayName("Creación de Cliente")
    class CreacionCliente {

        @Test
        @DisplayName("Debe crear un cliente con todos los atributos válidos")
        void debeCrearClienteConAtributosValidos() {
            UUID id = UUID.randomUUID();
            String nombre = "Juan Pérez";
            String email = "juan.perez@banca.com";
            String telefono = "+34612345678";
            String direccion = "Calle Mayor 123, Madrid";
            String identificadorFiscal = "12345678A";

            Cliente cliente = new Cliente(id, nombre, email, telefono, direccion, identificadorFiscal);

            assertThat(cliente.getId()).isEqualTo(id);
            assertThat(cliente.getNombre()).isEqualTo(nombre);
            assertThat(cliente.getEmail()).isEqualTo(email);
            assertThat(cliente.getTelefono()).isEqualTo(telefono);
            assertThat(cliente.getDireccion()).isEqualTo(direccion);
            assertThat(cliente.getIdentificadorFiscal()).isEqualTo(identificadorFiscal);
        }

        @Test
        @DisplayName("Debe crear un cliente con ID generado automáticamente")
        void debeCrearClienteConIdAutomatico() {
            String nombre = "María García";
            String email = "maria.garcia@banca.com";

            Cliente cliente = new Cliente(nombre, email);

            assertThat(cliente.getId()).isNotNull();
            assertThat(cliente.getNombre()).isEqualTo(nombre);
            assertThat(cliente.getEmail()).isEqualTo(email);
        }
    }

    @Nested
    @DisplayName("Validación de atributos")
    class ValidacionAtributos {

        @ParameterizedTest
        @ValueSource(strings = {"", "   "})
        @DisplayName("Debe rechazar nombre vacío o en blanco")
        void debeRechazarNombreVacio(String nombreInvalido) {
            assertThatThrownBy(() -> new Cliente(
                UUID.randomUUID(),
                nombreInvalido,
                "test@banca.com",
                "+34612345678",
                "Direccion 123",
                "12345678A"
            )).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("nombre");
        }

        @ParameterizedTest
        @ValueSource(strings = {"", "   ", "sinArroba", "sin@dominio", "@sin.local"})
        @DisplayName("Debe rechazar email con formato inválido")
        void debeRechazarEmailInvalido(String emailInvalido) {
            assertThatThrownBy(() -> new Cliente(
                UUID.randomUUID(),
                "Test User",
                emailInvalido,
                "+34612345678",
                "Direccion 123",
                "12345678A"
            )).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("email");
        }

        @ParameterizedTest
        @ValueSource(strings = {"", "   ", "abc"})
        @DisplayName("Debe rechazar identificador fiscal con formato inválido")
        void debeRechazarIdentificadorFiscalInvalido(String identificadorInvalido) {
            assertThatThrownBy(() -> new Cliente(
                UUID.randomUUID(),
                "Test User",
                "test@banca.com",
                "+34612345678",
                "Direccion 123",
                identificadorInvalido
            )).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("identificador");
        }

        @Test
        @DisplayName("Debe aceptar teléfono con formato internacional válido")
        void debeAceptarTelefonoInternacional() {
            String[] telefonosValidos = {
                "+34612345678",
                "+1-555-123-4567",
                "+44 20 7946 0958"
            };

            for (String telefono : telefonosValidos) {
                Cliente cliente = new Cliente(
                    UUID.randomUUID(),
                    "Test User",
                    "test@banca.com",
                    telefono,
                    "Direccion 123",
                    "12345678A"
                );
                assertThat(cliente.getTelefono()).isEqualTo(telefono);
            }
        }
    }

    @Nested
    @DisplayName("Modificación de Cliente")
    class ModificacionCliente {

        @Test
        @DisplayName("Debe permitir actualizar la dirección")
        void debePermitirActualizarDireccion() {
            Cliente cliente = new Cliente(
                "Test User",
                "test@banca.com"
            );
            String nuevaDireccion = "Nueva Calle 456, Barcelona";

            cliente.setDireccion(nuevaDireccion);

            assertThat(cliente.getDireccion()).isEqualTo(nuevaDireccion);
        }

        @Test
        @DisplayName("Debe permitir actualizar el teléfono")
        void debePermitirActualizarTelefono() {
            Cliente cliente = new Cliente(
                "Test User",
                "test@banca.com"
            );
            String nuevoTelefono = "+34987654321";

            cliente.setTelefono(nuevoTelefono);

            assertThat(cliente.getTelefono()).isEqualTo(nuevoTelefono);
        }

        @Test
        @DisplayName("Debe rechazar actualización de email a formato inválido")
        void debeRechazarEmailInvalidoEnActualizacion() {
            Cliente cliente = new Cliente(
                "Test User",
                "test@banca.com"
            );

            assertThatThrownBy(() -> cliente.setEmail("email-invalido"))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("Comportamiento de negocio")
    class ComportamientoNegocio {

        @Test
        @DisplayName("Dos clientes con mismo ID deben ser iguales")
        void debeCompararPorId() {
            UUID id = UUID.randomUUID();
            Cliente cliente1 = new Cliente(id, "Juan", "juan@banca.com");
            Cliente cliente2 = new Cliente(id, "Otro", "otro@banca.com");

            assertThat(cliente1).isEqualTo(cliente2);
        }

        @Test
        @DisplayName("Cliente con diferentes IDs no deben ser iguales")
        void debeDiferenciarPorDistintoId() {
            Cliente cliente1 = new Cliente("Juan", "juan@banca.com");
            Cliente cliente2 = new Cliente("Juan", "juan@banca.com");

            assertThat(cliente1).isNotEqualTo(cliente2);
        }

        @Test
        @DisplayName("HashCode debe ser consistente con equals")
        void debeGenerarHashCodeConsistente() {
            UUID id = UUID.randomUUID();
            Cliente cliente1 = new Cliente(id, "Juan", "juan@banca.com");
            Cliente cliente2 = new Cliente(id, "Juan", "juan@banca.com");

            assertThat(cliente1.hashCode()).isEqualTo(cliente2.hashCode());
        }
    }
}