# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Normalización de Datos en una Base de Datos de Banca**.

| | |
|---|---|
| Tema | Diseño e Implementación de un Modelo de Datos Normalizado |
| Nivel | senior-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | capas estándar con dominio aislado (hexagonal ligero) |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web n/a
- org.springframework.boot:spring-boot-starter-data-jpa n/a
- org.springframework.boot:spring-boot-starter-validation n/a
- org.postgresql:postgresql 42.7.3
- org.flywaydb:flyway-core 10.14.0
- org.springframework.boot:spring-boot-starter-test n/a
- org.junit.jupiter:junit-jupiter-api 5.10.2
- org.assertj:assertj-core 3.25.3

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Análisis de Requisitos y Modelado Inicial**: Modelo Entidad-Relación inicial.
- **Fase 2 — Aplicación de Formas Normales**: Modelo de datos normalizado.
- **Fase 3 — Implementación y Verificación**: Base de datos normalizada y verificada.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Lo que falta y tenes que completar

### 1. Referencias colgando (57)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCliente.java` — `Cliente.setCorreo`
      Se invoca `setCorreo` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCliente.java` — `RepositorioCliente.buscarPorNombreContiene`
      Se invoca `buscarPorNombreContiene` sobre `RepositorioCliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCliente.java` — `Cliente.setActivo`
      Se invoca `setActivo` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCuenta.java` — `Cuenta.setActiva`
      Se invoca `setActiva` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCuenta.java` — `RepositorioCuenta.buscarPorNumero`
      Se invoca `buscarPorNumero` sobre `RepositorioCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCuenta.java` — `RepositorioCuenta.buscarPorIdCliente`
      Se invoca `buscarPorIdCliente` sobre `RepositorioCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCuenta.java` — `RepositorioCuenta.buscarCuentasActivas`
      Se invoca `buscarCuentasActivas` sobre `RepositorioCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCuenta.java` — `Cuenta.isActiva`
      Se invoca `isActiva` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccion.java` — `Cuenta.isActiva`
      Se invoca `isActiva` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccion.java` — `RepositorioTransaccion.buscarPorIdCuenta`
      Se invoca `buscarPorIdCuenta` sobre `RepositorioTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccion.java` — `RepositorioTransaccion.buscarPorIdCuentaYTipo`
      Se invoca `buscarPorIdCuentaYTipo` sobre `RepositorioTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorCliente.java` — `CasoDeUsoCliente.obtenerTodos`
      Se invoca `obtenerTodos` sobre `CasoDeUsoCliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorCliente.java` — `CasoDeUsoCliente.buscarPorId`
      Se invoca `buscarPorId` sobre `CasoDeUsoCliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorCliente.java` — `CasoDeUsoCliente.guardar`
      Se invoca `guardar` sobre `CasoDeUsoCliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorCliente.java` — `CasoDeUsoCliente.actualizar`
      Se invoca `actualizar` sobre `CasoDeUsoCliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorCliente.java` — `CasoDeUsoCliente.eliminar`
      Se invoca `eliminar` sobre `CasoDeUsoCliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorCliente.java` — `CasoDeUsoCliente.buscarPorNumeroDocumento`
      Se invoca `buscarPorNumeroDocumento` sobre `CasoDeUsoCliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorCliente.java` — `CasoDeUsoCliente.contar`
      Se invoca `contar` sobre `CasoDeUsoCliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorCuenta.java` — `CasoDeUsoCuenta.obtenerTodas`
      Se invoca `obtenerTodas` sobre `CasoDeUsoCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorCuenta.java` — `CasoDeUsoCuenta.buscarPorId`
      Se invoca `buscarPorId` sobre `CasoDeUsoCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorCuenta.java` — `CasoDeUsoCuenta.guardar`
      Se invoca `guardar` sobre `CasoDeUsoCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorCuenta.java` — `CasoDeUsoCuenta.actualizar`
      Se invoca `actualizar` sobre `CasoDeUsoCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorCuenta.java` — `CasoDeUsoCuenta.eliminar`
      Se invoca `eliminar` sobre `CasoDeUsoCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorCuenta.java` — `CasoDeUsoCuenta.buscarPorClienteId`
      Se invoca `buscarPorClienteId` sobre `CasoDeUsoCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorCuenta.java` — `CasoDeUsoCuenta.buscarPorNumeroCuenta`
      Se invoca `buscarPorNumeroCuenta` sobre `CasoDeUsoCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorCuenta.java` — `CasoDeUsoCuenta.contar`
      Se invoca `contar` sobre `CasoDeUsoCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `CasoDeUsoTransaccion.obtenerTodas`
      Se invoca `obtenerTodas` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `CasoDeUsoTransaccion.buscarPorId`
      Se invoca `buscarPorId` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `CasoDeUsoTransaccion.guardar`
      Se invoca `guardar` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `CasoDeUsoTransaccion.actualizar`
      Se invoca `actualizar` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `CasoDeUsoTransaccion.eliminar`
      Se invoca `eliminar` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `CasoDeUsoTransaccion.buscarPorCuentaId`
      Se invoca `buscarPorCuentaId` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `CasoDeUsoTransaccion.buscarPorTipo`
      Se invoca `buscarPorTipo` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `CasoDeUsoTransaccion.contar`
      Se invoca `contar` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `CasoDeUsoTransaccion.calcularSaldo`
      Se invoca `calcularSaldo` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/dominio/entidades/ClienteTest.java` — `Cliente.getIdentificadorFiscal`
      Se invoca `getIdentificadorFiscal` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/dominio/entidades/CuentaTest.java` — `Cuenta.getClienteId`
      Se invoca `getClienteId` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/dominio/entidades/CuentaTest.java` — `Cuenta.isActiva`
      Se invoca `isActiva` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/dominio/entidades/CuentaTest.java` — `Cuenta.depositar`
      Se invoca `depositar` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/dominio/entidades/CuentaTest.java` — `Cuenta.retirar`
      Se invoca `retirar` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/dominio/entidades/CuentaTest.java` — `Cuenta.desactivar`
      Se invoca `desactivar` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/dominio/entidades/TransaccionTest.java` — `Transaccion.getTipo`
      Se invoca `getTipo` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/dominio/entidades/TransaccionTest.java` — `Transaccion.getCuentaId`
      Se invoca `getCuentaId` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/dominio/entidades/TransaccionTest.java` — `Transaccion.getCuentaDestinoId`
      Se invoca `getCuentaDestinoId` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/dominio/entidades/TransaccionTest.java` — `Transaccion.getFecha`
      Se invoca `getFecha` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/dominio/entidades/TransaccionTest.java` — `Transaccion.esTransferencia`
      Se invoca `esTransferencia` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `RepositorioTransaccion.deleteAll`
      Se invoca `deleteAll` sobre `RepositorioTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `RepositorioCuenta.deleteAll`
      Se invoca `deleteAll` sobre `RepositorioCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `RepositorioCliente.deleteAll`
      Se invoca `deleteAll` sobre `RepositorioCliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `Cuenta.setNumero`
      Se invoca `setNumero` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `Cuenta.setTipo`
      Se invoca `setTipo` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `Cuenta.setClienteId`
      Se invoca `setClienteId` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `Cuenta.setActiva`
      Se invoca `setActiva` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `CasoDeUsoTransaccion.realizarDeposito`
      Se invoca `realizarDeposito` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `CasoDeUsoTransaccion.realizarExtraccion`
      Se invoca `realizarExtraccion` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `CasoDeUsoTransaccion.consultarHistorial`
      Se invoca `consultarHistorial` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (30)

- `pom.xml`
- `src/main/java/com/banca/Application.java`
- `src/main/resources/application.yml`
- `src/main/java/com/banca/dominio/entidades/Cliente.java`
- `src/main/java/com/banca/dominio/entidades/Cuenta.java`
- `src/main/java/com/banca/dominio/entidades/Transaccion.java`
- `src/main/java/com/banca/dominio/repositorios/RepositorioCliente.java`
- `src/main/java/com/banca/dominio/repositorios/RepositorioCuenta.java`
- `src/main/java/com/banca/dominio/repositorios/RepositorioTransaccion.java`
- `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCliente.java`
- `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCuenta.java`
- `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccion.java`
- `src/main/java/com/banca/infraestructura/adaptadores/AdaptadorClienteJPA.java`
- `src/main/java/com/banca/infraestructura/adaptadores/AdaptadorCuentaJPA.java`
- `src/main/java/com/banca/infraestructura/adaptadores/AdaptadorTransaccionJPA.java`
- `src/main/java/com/banca/infraestructura/repositorios/RepositorioClienteJPA.java`
- `src/main/java/com/banca/infraestructura/repositorios/RepositorioCuentaJPA.java`
- `src/main/java/com/banca/infraestructura/repositorios/RepositorioTransaccionJPA.java`
- `src/main/java/com/banca/infraestructura/controladores/ControladorCliente.java`
- `src/main/java/com/banca/infraestructura/controladores/ControladorCuenta.java`
- `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java`
- `src/main/java/com/banca/infraestructura/config/ConfiguracionJPA.java`
- `src/main/java/com/banca/infraestructura/excepciones/ManejadorGlobalExcepciones.java`
- `src/main/resources/db/migration/V1__Crear_esquema_banca.sql`
- `src/main/resources/db/migration/V2__Insertar_datos_prueba.sql`
- `src/test/java/com/banca/dominio/entidades/ClienteTest.java`
- `src/test/java/com/banca/dominio/entidades/CuentaTest.java`
- `src/test/java/com/banca/dominio/entidades/TransaccionTest.java`
- `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java`
- `README.md`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/banca/dominio`
- `src/main/java/com/banca/aplicacion`
- `src/main/java/com/banca/infraestructura`
- `src/main/java/com/banca/infraestructura/adaptadores`
- `src/main/java/com/banca/infraestructura/repositorios`
- `src/main/resources`
- `src/test/java/com/banca`

## Verificacion

```bash
mvn clean compile
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar con dominio aislado (hexagonal ligero)**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior L2
- Brecha que el reto ataca: Implementa un proceso de normalización en una base de datos según las formas normales y ha usado un modelo Entidad-Relación., Implementa un proceso de normalización en una base de datos según las formas normales y ha usado un modelo Entidad-Relación.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
