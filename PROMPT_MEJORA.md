# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCliente.java` — `Cliente.setCorreo`: Se invoca `setCorreo` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCliente.java` — `RepositorioCliente.buscarPorNombreContiene`: Se invoca `buscarPorNombreContiene` sobre `RepositorioCliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCliente.java` — `Cliente.setActivo`: Se invoca `setActivo` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCuenta.java` — `Cuenta.setActiva`: Se invoca `setActiva` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCuenta.java` — `RepositorioCuenta.buscarPorNumero`: Se invoca `buscarPorNumero` sobre `RepositorioCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCuenta.java` — `RepositorioCuenta.buscarPorIdCliente`: Se invoca `buscarPorIdCliente` sobre `RepositorioCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCuenta.java` — `RepositorioCuenta.buscarCuentasActivas`: Se invoca `buscarCuentasActivas` sobre `RepositorioCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCuenta.java` — `Cuenta.isActiva`: Se invoca `isActiva` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccion.java` — `Cuenta.isActiva`: Se invoca `isActiva` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccion.java` — `RepositorioTransaccion.buscarPorIdCuenta`: Se invoca `buscarPorIdCuenta` sobre `RepositorioTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccion.java` — `RepositorioTransaccion.buscarPorIdCuentaYTipo`: Se invoca `buscarPorIdCuentaYTipo` sobre `RepositorioTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorCliente.java` — `CasoDeUsoCliente.obtenerTodos`: Se invoca `obtenerTodos` sobre `CasoDeUsoCliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorCliente.java` — `CasoDeUsoCliente.buscarPorId`: Se invoca `buscarPorId` sobre `CasoDeUsoCliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorCliente.java` — `CasoDeUsoCliente.guardar`: Se invoca `guardar` sobre `CasoDeUsoCliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorCliente.java` — `CasoDeUsoCliente.actualizar`: Se invoca `actualizar` sobre `CasoDeUsoCliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorCliente.java` — `CasoDeUsoCliente.eliminar`: Se invoca `eliminar` sobre `CasoDeUsoCliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorCliente.java` — `CasoDeUsoCliente.buscarPorNumeroDocumento`: Se invoca `buscarPorNumeroDocumento` sobre `CasoDeUsoCliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorCliente.java` — `CasoDeUsoCliente.contar`: Se invoca `contar` sobre `CasoDeUsoCliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorCuenta.java` — `CasoDeUsoCuenta.obtenerTodas`: Se invoca `obtenerTodas` sobre `CasoDeUsoCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorCuenta.java` — `CasoDeUsoCuenta.buscarPorId`: Se invoca `buscarPorId` sobre `CasoDeUsoCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorCuenta.java` — `CasoDeUsoCuenta.guardar`: Se invoca `guardar` sobre `CasoDeUsoCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorCuenta.java` — `CasoDeUsoCuenta.actualizar`: Se invoca `actualizar` sobre `CasoDeUsoCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorCuenta.java` — `CasoDeUsoCuenta.eliminar`: Se invoca `eliminar` sobre `CasoDeUsoCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorCuenta.java` — `CasoDeUsoCuenta.buscarPorClienteId`: Se invoca `buscarPorClienteId` sobre `CasoDeUsoCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorCuenta.java` — `CasoDeUsoCuenta.buscarPorNumeroCuenta`: Se invoca `buscarPorNumeroCuenta` sobre `CasoDeUsoCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorCuenta.java` — `CasoDeUsoCuenta.contar`: Se invoca `contar` sobre `CasoDeUsoCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `CasoDeUsoTransaccion.obtenerTodas`: Se invoca `obtenerTodas` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `CasoDeUsoTransaccion.buscarPorId`: Se invoca `buscarPorId` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `CasoDeUsoTransaccion.guardar`: Se invoca `guardar` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `CasoDeUsoTransaccion.actualizar`: Se invoca `actualizar` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `CasoDeUsoTransaccion.eliminar`: Se invoca `eliminar` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `CasoDeUsoTransaccion.buscarPorCuentaId`: Se invoca `buscarPorCuentaId` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `CasoDeUsoTransaccion.buscarPorTipo`: Se invoca `buscarPorTipo` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `CasoDeUsoTransaccion.contar`: Se invoca `contar` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java` — `CasoDeUsoTransaccion.calcularSaldo`: Se invoca `calcularSaldo` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/dominio/entidades/ClienteTest.java` — `Cliente.getIdentificadorFiscal`: Se invoca `getIdentificadorFiscal` sobre `Cliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/dominio/entidades/CuentaTest.java` — `Cuenta.getClienteId`: Se invoca `getClienteId` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/dominio/entidades/CuentaTest.java` — `Cuenta.isActiva`: Se invoca `isActiva` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/dominio/entidades/CuentaTest.java` — `Cuenta.depositar`: Se invoca `depositar` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/dominio/entidades/CuentaTest.java` — `Cuenta.retirar`: Se invoca `retirar` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/dominio/entidades/CuentaTest.java` — `Cuenta.desactivar`: Se invoca `desactivar` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/dominio/entidades/TransaccionTest.java` — `Transaccion.getTipo`: Se invoca `getTipo` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/dominio/entidades/TransaccionTest.java` — `Transaccion.getCuentaId`: Se invoca `getCuentaId` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/dominio/entidades/TransaccionTest.java` — `Transaccion.getCuentaDestinoId`: Se invoca `getCuentaDestinoId` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/dominio/entidades/TransaccionTest.java` — `Transaccion.getFecha`: Se invoca `getFecha` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/dominio/entidades/TransaccionTest.java` — `Transaccion.esTransferencia`: Se invoca `esTransferencia` sobre `Transaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `RepositorioTransaccion.deleteAll`: Se invoca `deleteAll` sobre `RepositorioTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `RepositorioCuenta.deleteAll`: Se invoca `deleteAll` sobre `RepositorioCuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `RepositorioCliente.deleteAll`: Se invoca `deleteAll` sobre `RepositorioCliente`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `Cuenta.setNumero`: Se invoca `setNumero` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `Cuenta.setTipo`: Se invoca `setTipo` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `Cuenta.setClienteId`: Se invoca `setClienteId` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `Cuenta.setActiva`: Se invoca `setActiva` sobre `Cuenta`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `CasoDeUsoTransaccion.realizarDeposito`: Se invoca `realizarDeposito` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `CasoDeUsoTransaccion.realizarExtraccion`: Se invoca `realizarExtraccion` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java` — `CasoDeUsoTransaccion.consultarHistorial`: Se invoca `consultarHistorial` sobre `CasoDeUsoTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior L2

### Brecha de conocimiento
Implementa un proceso de normalización en una base de datos según las formas normales y ha usado un modelo Entidad-Relación., Implementa un proceso de normalización en una base de datos según las formas normales y ha usado un modelo Entidad-Relación.

### Reto
- Tema: Diseño e Implementación de un Modelo de Datos Normalizado
- Seniority: senior-l2
- Tipo: practical
- Título: Normalización de Datos en una Base de Datos de Banca
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Análisis de Requisitos y Modelado Inicial — objetivo: Identificar las entidades y relaciones necesarias para el modelo de datos. — entregable (NO resolver): Modelo Entidad-Relación inicial.
- Fase 2: Aplicación de Formas Normales — objetivo: Aplicar las formas normales al modelo de datos para eliminar redundancias y mejorar la integridad. — entregable (NO resolver): Modelo de datos normalizado.
- Fase 3: Implementación y Verificación — objetivo: Implementar el modelo de datos normalizado en la base de datos y verificar su funcionamiento. — entregable (NO resolver): Base de datos normalizada y verificada.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.banca</groupId>
    <artifactId>banca-service</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>banca-service</name>
    <description>Servicio de banca con modelo de datos normalizado</description>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- Base de datos -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.3</version>
        </dependency>

        <!-- Flyway -->
        <dependency>
            <groupId>org.flywaydb</groupId>
            <artifactId>flyway-core</artifactId>
            <version>10.14.0</version>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.10.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.assertj</groupId>
            <artifactId>assertj-core</artifactId>
            <version>3.25.3</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/banca/Application.java ===
package com.banca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.flywaydb.core.Flyway;

import javax.sql.DataSource;
import java.util.Arrays;

@SpringBootApplication
@EnableTransactionManagement
public class Application {
    private final DataSource dataSource;
    private final Environment environment;

    public Application(DataSource dataSource, Environment environment) {
        this.dataSource = dataSource;
        this.environment = environment;
        validateEnvironment();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        migrateDatabase();
        logApplicationStartup();
    }

    private void migrateDatabase() {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration")
                .load();
        flyway.migrate();
    }

    private void validateEnvironment() {
        String[] activeProfiles = environment.getActiveProfiles();
        if (Arrays.stream(activeProfiles).noneMatch(profile -> profile.equals("dev") || profile.equals("prod"))) {
            throw new IllegalStateException("Debe activarse al menos un perfil: 'dev' o 'prod'");
        }
    }

    private void logApplicationStartup() {
        String protocol = environment.getProperty("server.ssl.key-store") != null ? "https" : "http";
        String serverPort = environment.getProperty("server.port");
        String contextPath = environment.getProperty("server.servlet.context-path");
        if (contextPath == null || contextPath.isBlank()) {
            contextPath = "/";
        }
        System.out.println(String.format("\n----------------------------------------------------------\n" +
                "Aplicación 'Banca Service' iniciada!\n" +
                "Perfiles activos: %s\n" +
                "Acceso local: %s://localhost:%s%s\n" +
                "----------------------------------------------------------",
                Arrays.toString(environment.getActiveProfiles()),
                protocol,
                serverPort,
                contextPath));
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: banca-service
  profiles:
    active: dev
  datasource:
    url: jdbc:postgresql://localhost:5432/banca_db
    username: banca_user
    password: banca_password
    driver-class-name: org.postgresql.Driver
    hikari:
      connection-timeout: 20000
      maximum-pool-size: 10
      pool-name: banca-pool
  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: none
    show-sql: false
    properties:
      hibernate:
        format_sql: true
        jdbc:
          batch_size: 20
        order_inserts: true
        order_updates: true
  flyway:
    enabled: true
    locations: classpath:db/migration
    baseline-on-migrate: true
    validate-on-migrate: true
    out-of-order: false
    clean-disabled: true

server:
  port: 8080
  servlet:
    context-path: /api

logging:
  level:
    root: INFO
    org.springframework.web: INFO
    org.hibernate: ERROR
    org.flywaydb: INFO
    com.banca: DEBUG
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} - %logger{36} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
  file:
    name: logs/banca-service.log

// === ARCHIVO: src/main/java/com/banca/dominio/entidades/Cliente.java ===
package com.banca.dominio.entidades;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "clientes", indexes = {
    @Index(name = "idx_cliente_identificacion", columnList = "identificacion", unique = true),
    @Index(name = "idx_cliente_email", columnList = "email", unique = true)
})
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "identificacion", nullable = false, unique = true, length = 20)
    private String identificacion;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "direccion", length = 500)
    private String direccion;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_identificacion", nullable = false, length = 10)
    private TipoIdentificacion tipoIdentificacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 15)
    private EstadoCliente estado;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cuenta> cuentas = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaccion> transacciones = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String identificacion, String nombre, String apellido, String email,
                   TipoIdentificacion tipoIdentificacion) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tipoIdentificacion = tipoIdentificacion;
        this.estado = EstadoCliente.ACTIVO;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = LocalDateTime.now();
    }

    @PrePersist
    protected void onCreate() {
        if (fechaCreacion == null) {
            fechaCreacion = LocalDateTime.now();
        }
        if (fechaActualizacion == null) {
            fechaActualizacion = LocalDateTime.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now();
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
        cuenta.setCliente(this);
    }

    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
        transaccion.setCliente(this);
    }

    public void desactivar() {
        this.estado = EstadoCliente.INACTIVO;
    }

    public boolean estaActivo() {
        return EstadoCliente.ACTIVO.equals(this.estado);
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public EstadoCliente getEstado() {
        return estado;
    }

    public void setEstado(EstadoCliente estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", identificacion='" + identificacion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", estado=" + estado +
                '}';
    }

    public enum TipoIdentificacion {
        CEDULA, NIT, PASAPORTE, OTRO
    }

    public enum EstadoCliente {
        ACTIVO, INACTIVO, SUSPENDIDO, BLOQUEADO
    }
}

// === ARCHIVO: src/main/java/com/banca/dominio/entidades/Cuenta.java ===
package com.banca.dominio.entidades;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "cuentas", indexes = {
    @Index(name = "idx_cuenta_numero", columnList = "numero_cuenta", unique = true),
    @Index(name = "idx_cuenta_cliente", columnList = "cliente_id")
})
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "numero_cuenta", nullable = false, unique = true, length = 20)
    private String numeroCuenta;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cuenta", nullable = false, length = 15)
    private TipoCuenta tipoCuenta;

    @Column(name = "saldo", nullable = false, precision = 19, scale = 4)
    private BigDecimal saldo;

    @Column(name = "saldo_minimo", precision = 19, scale = 4)
    private BigDecimal saldoMinimo;

    @Column(name = "limite_credito", precision = 19, scale = 4)
    private BigDecimal limiteCredito;

    @Enumerated(EnumType.STRING)
    @Column(name = "moneda", nullable = false, length = 3)
    private Moneda moneda;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 15)
    private EstadoCuenta estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;

    @Column(name = "fecha_ultima_operacion")
    private LocalDateTime fechaUltimaOperacion;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaccion> transacciones = new ArrayList<>();

    public Cuenta() {
    }

    public Cuenta(String numeroCuenta, TipoCuenta tipoCuenta, Cliente cliente, Moneda moneda) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.cliente = cliente;
        this.moneda = moneda;
        this.saldo = BigDecimal.ZERO;
        this.estado = EstadoCuenta.ACTIVA;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = LocalDateTime.now();
    }

    @PrePersist
    protected void onCreate() {
        if (fechaCreacion == null) {
            fechaCreacion = LocalDateTime.now();
        }
        if (fechaActualizacion == null) {
            fechaActualizacion = LocalDateTime.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now();
    }

    public void acreditar(BigDecimal monto) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a acreditar debe ser mayor a cero");
        }
        this.saldo = this.saldo.add(monto);
        this.fechaUltimaOperacion = LocalDateTime.now();
    }

    public void debitar(BigDecimal monto) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a debitar debe ser mayor a cero");
        }
        BigDecimal saldoDisponible = obtenerSaldoDisponible();
        if (saldoDisponible.compareTo(monto) < 0) {
            throw new IllegalStateException("Saldo insuficiente para debitar");
        }
        this.saldo = this.saldo.subtract(monto);
        this.fechaUltimaOperacion = LocalDateTime.now();
    }

    public BigDecimal obtenerSaldoDisponible() {
        BigDecimal disponible = saldo;
        if (limiteCredito != null) {
            disponible = disponible.add(limiteCredito);
        }
        return disponible;
    }

    public boolean puedeDebitar(BigDecimal monto) {
        return obtenerSaldoDisponible().compareTo(monto) >= 0;
    }

    public boolean estaActiva() {
        return EstadoCuenta.ACTIVA.equals(this.estado);
    }

    public void cerrar() {
        if (saldo.compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalStateException("No se puede cerrar una cuenta con saldo diferente de cero");
        }
        this.estado = EstadoCuenta.CERRADA;
    }

    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
        transaccion.setCuenta(this);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldoMinimo() {
        return saldoMinimo;
    }

    public void setSaldoMinimo(BigDecimal saldoMinimo) {
        this.saldoMinimo = saldoMinimo;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public EstadoCuenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoCuenta estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public LocalDateTime getFechaUltimaOperacion() {
        return fechaUltimaOperacion;
    }

    public void setFechaUltimaOperacion(LocalDateTime fechaUltimaOperacion) {
        this.fechaUltimaOperacion = fechaUltimaOperacion;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return Objects.equals(id, cuenta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", tipoCuenta=" + tipoCuenta +
                ", saldo=" + saldo +
                ", moneda=" + moneda +
                ", estado=" + estado +
                '}';
    }

    public enum TipoCuenta {
        AHORROS, CORRIENTE, PLAZO_FIJO, VIRTUAL
    }

    public enum Moneda {
        USD, EUR, COP
    }

    public enum EstadoCuenta {
        ACTIVA, INACTIVA, CERRADA, BLOQUEADA
    }
}

// === ARCHIVO: src/main/java/com/banca/dominio/entidades/Transaccion.java ===
package com.banca.dominio.entidades;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "transacciones", indexes = {
    @Index(name = "idx_transaccion_cuenta", columnList = "cuenta_id"),
    @Index(name = "idx_transaccion_cliente", columnList = "cliente_id"),
    @Index(name = "idx_transaccion_fecha", columnList = "fecha_transaccion"),
    @Index(name = "idx_transaccion_referencia", columnList = "referencia_externa", unique = true)
})
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "referencia_externa", unique = true, length = 50)
    private String referenciaExterna;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_transaccion", nullable = false, length = 20)
    private TipoTransaccion tipoTransaccion;

    @Column(name = "monto", nullable = false, precision = 19, scale = 4)
    private BigDecimal monto;

    @Enumerated(EnumType.STRING)
    @Column(name = "moneda", nullable = false, length = 3)
    private Cuenta.Moneda moneda;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 15)
    private EstadoTransaccion estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_id", nullable = false)
    private Cuenta cuenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "cuenta_origen")
    private String cuentaOrigen;

    @Column(name = "cuenta_destino")
    private String cuentaDestino;

    @Column(name = "fecha_transaccion", nullable = false)
    private LocalDateTime fechaTransaccion;

    @Column(name = "fecha_procesamiento")
    private LocalDateTime fechaProcesamiento;

    @Column(name = "canal", length = 20)
    private String canal;

    @Column(name = "codigo_respuesta", length = 10)
    private String codigoRespuesta;

    public Transaccion() {
    }

    public Transaccion(TipoTransaccion tipoTransaccion, BigDecimal monto, Cuenta.Moneda moneda,
                       Cuenta cuenta, Cliente cliente) {
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.moneda = moneda;
        this.cuenta = cuenta;
        this.cliente = cliente;
        this.estado = EstadoTransaccion.PENDIENTE;
        this.fechaTransaccion = LocalDateTime.now();
    }

    @PrePersist
    protected void onCreate() {
        if (fechaTransaccion == null) {
            fechaTransaccion = LocalDateTime.now();
        }
    }

    public void ejecutar() {
        if (this.estado != EstadoTransaccion.PENDIENTE) {
            throw new IllegalStateException("Solo se pueden ejecutar transacciones pendientes");
        }

        switch (tipoTransaccion) {
            case DEPOSITO -> cuenta.acreditar(monto);
            case RETIRO -> cuenta.debitar(monto);
            case TRANSFERENCIA -> {
                cuenta.debitar(monto);
            }
            case PAGO -> cuenta.debitar(monto);
            default -> throw new IllegalArgumentException("Tipo de transacción no soportado: " + tipoTransaccion);
        }

        this.estado = EstadoTransaccion.COMPLETADA;
        this.fechaProcesamiento = LocalDateTime.now();
    }

    public void rechazar(String codigoRespuesta) {
        this.estado = EstadoTransaccion.RECHAZADA;
        this.codigoRespuesta = codigoRespuesta;
        this.fechaProcesamiento = LocalDateTime.now();
    }

    public void reversar(String motivo) {
        if (this.estado != EstadoTransaccion.COMPLETADA) {
            throw new IllegalStateException("Solo se pueden reversar transacciones completadas");
        }

        switch (tipoTransaccion) {
            case DEPOSITO -> cuenta.debitar(monto);
            case RETIRO -> cuenta.acreditar(monto);
            case TRANSFERENCIA -> cuenta.acreditar(monto);
            case PAGO -> cuenta.acreditar(monto);
            default -> throw new IllegalArgumentException("Tipo de transacción no soportado para reverso: " + tipoTransaccion);
        }

        this.estado = EstadoTransaccion.REVERSADA;
        this.descripcion = "Reversión: " + motivo;
        this.fechaProcesamiento = LocalDateTime.now();
    }

    public boolean estaCompletada() {
        return EstadoTransaccion.COMPLETADA.equals(this.estado);
    }

    public boolean estaPendiente() {
        return EstadoTransaccion.PENDIENTE.equals(this.estado);
    }

    public boolean puedeReversarse() {
        return estaCompletada() && fechaTransaccion.plusHours(24).isAfter(LocalDateTime.now());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getReferenciaExterna() {
        return referenciaExterna;
    }

    public void setReferenciaExterna(String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Cuenta.Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Cuenta.Moneda moneda) {
        this.moneda = moneda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoTransaccion getEstado() {
        return estado;
    }

    public void setEstado(EstadoTransaccion estado) {
        this.estado = estado;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public LocalDateTime getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDateTime fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public LocalDateTime getFechaProcesamiento() {
        return fechaProcesamiento;
    }

    public void setFechaProcesamiento(LocalDateTime fechaProcesamiento) {
        this.fechaProcesamiento = fechaProcesamiento;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(String codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaccion that = (Transaccion) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "id=" + id +
                ", referenciaExterna='" + referenciaExterna + '\'' +
                ", tipoTransaccion=" + tipoTransaccion +
                ", monto=" + monto +
                ", moneda=" + moneda +
                ", estado=" + estado +
                ", fechaTransaccion=" + fechaTransaccion +
                '}';
    }

    public enum TipoTransaccion {
        DEPOSITO, RETIRO, TRANSFERENCIA, PAGO, COMPRA
    }

    public enum EstadoTransaccion {
        PENDIENTE, COMPLETADA, RECHAZADA, REVERSADA, CANCELADA
    }
}

// === ARCHIVO: src/main/java/com/banca/dominio/repositorios/RepositorioCliente.java ===
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

// === ARCHIVO: src/main/java/com/banca/dominio/repositorios/RepositorioCuenta.java ===
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

// === ARCHIVO: src/main/java/com/banca/dominio/repositorios/RepositorioTransaccion.java ===
package com.banca.dominio.repositorios;

import com.banca.dominio.entidades.Transaccion;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositorioTransaccion {
    
    Optional<Transaccion> buscarPorId(UUID id);
    
    List<Transaccion> buscarTodos();
    
    Transaccion guardar(Transaccion transaccion);
    
    void eliminar(UUID id);
    
    boolean existePorId(UUID id);
    
    long contar();
    
    List<Transaccion> buscarPorCuentaId(UUID cuentaId);
    
    List<Transaccion> buscarPorCuentaIdYFechaBetween(UUID cuentaId, LocalDateTime fechaInicio, LocalDateTime fechaFin);
    
    List<Transaccion> buscarPorTipoTransaccion(String tipoTransaccion);
    
    Optional<Transaccion> buscarPorReferencia(String referencia);
    
    BigDecimal sumatoriaMontoPorCuentaYFecha(UUID cuentaId, LocalDateTime fechaInicio, LocalDateTime fechaFin);
    
    List<Transaccion> buscarUltimasTransaccionesPorCuenta(UUID cuentaId, int limite);
}

// === ARCHIVO: src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCliente.java ===
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

// === ARCHIVO: src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoCuenta.java ===
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

// === ARCHIVO: src/main/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccion.java ===
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

// === ARCHIVO: src/main/java/com/banca/infraestructura/adaptadores/AdaptadorClienteJPA.java ===
package com.banca.infraestructura.adaptadores;

import com.banca.dominio.entidades.Cliente;
import com.banca.dominio.repositorios.RepositorioCliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public class AdaptadorClienteJPA implements RepositorioCliente {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Cliente guardar(Cliente cliente) {
        if (cliente.getId() == null) {
            cliente.setId(UUID.randomUUID().toString());
            entityManager.persist(cliente);
            return cliente;
        } else {
            return entityManager.merge(cliente);
        }
    }

    @Override
    public Optional<Cliente> buscarPorId(String id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        return Optional.ofNullable(cliente);
    }

    @Override
    public Optional<Cliente> buscarPorDocumento(String numeroDocumento) {
        TypedQuery<Cliente> query = entityManager.createQuery(
            "SELECT c FROM Cliente c WHERE c.numeroDocumento = :numeroDocumento",
            Cliente.class
        );
        query.setParameter("numeroDocumento", numeroDocumento);
        List<Cliente> resultados = query.getResultList();
        return resultados.isEmpty() ? Optional.empty() : Optional.of(resultados.get(0));
    }

    @Override
    public List<Cliente> buscarTodos() {
        TypedQuery<Cliente> query = entityManager.createQuery(
            "SELECT c FROM Cliente c",
            Cliente.class
        );
        return query.getResultList();
    }

    @Override
    public void eliminar(String id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        if (cliente != null) {
            entityManager.remove(cliente);
        }
    }

    @Override
    public boolean existePorId(String id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        return cliente != null;
    }
}

// === ARCHIVO: src/main/java/com/banca/infraestructura/adaptadores/AdaptadorCuentaJPA.java ===
package com.banca.infraestructura.adaptadores;

import com.banca.dominio.entidades.Cuenta;
import com.banca.dominio.repositorios.RepositorioCuenta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class AdaptadorCuentaJPA implements RepositorioCuenta {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Cuenta guardar(Cuenta cuenta) {
        if (cuenta.getId() == null) {
            entityManager.persist(cuenta);
            return cuenta;
        } else {
            return entityManager.merge(cuenta);
        }
    }

    @Override
    public Optional<Cuenta> buscarPorId(String id) {
        Cuenta cuenta = entityManager.find(Cuenta.class, id);
        return Optional.ofNullable(cuenta);
    }

    @Override
    public Optional<Cuenta> buscarPorNumero(String numeroCuenta) {
        TypedQuery<Cuenta> query = entityManager.createQuery(
            "SELECT c FROM Cuenta c WHERE c.numeroCuenta = :numeroCuenta",
            Cuenta.class
        );
        query.setParameter("numeroCuenta", numeroCuenta);
        List<Cuenta> resultados = query.getResultList();
        return resultados.isEmpty() ? Optional.empty() : Optional.of(resultados.get(0));
    }

    @Override
    public List<Cuenta> buscarPorClienteId(String clienteId) {
        TypedQuery<Cuenta> query = entityManager.createQuery(
            "SELECT c FROM Cuenta c WHERE c.clienteId = :clienteId",
            Cuenta.class
        );
        query.setParameter("clienteId", clienteId);
        return query.getResultList();
    }

    @Override
    public List<Cuenta> buscarTodos() {
        TypedQuery<Cuenta> query = entityManager.createQuery(
            "SELECT c FROM Cuenta c",
            Cuenta.class
        );
        return query.getResultList();
    }

    @Override
    public void eliminar(String id) {
        Cuenta cuenta = entityManager.find(Cuenta.class, id);
        if (cuenta != null) {
            entityManager.remove(cuenta);
        }
    }

    @Override
    public boolean existePorId(String id) {
        Cuenta cuenta = entityManager.find(Cuenta.class, id);
        return cuenta != null;
    }

    @Override
    public boolean tieneSaldoSuficiente(String cuentaId, BigDecimal monto) {
        Optional<Cuenta> cuentaOpt = buscarPorId(cuentaId);
        if (cuentaOpt.isEmpty()) {
            return false;
        }
        Cuenta cuenta = cuentaOpt.get();
        return cuenta.getSaldo().compareTo(monto) >= 0;
    }

    @Override
    public void actualizarSaldo(String cuentaId, BigDecimal nuevoSaldo) {
        Cuenta cuenta = entityManager.find(Cuenta.class, cuentaId);
        if (cuenta != null) {
            cuenta.setSaldo(nuevoSaldo);
            entityManager.merge(cuenta);
        }
    }
}

// === ARCHIVO: src/main/java/com/banca/infraestructura/adaptadores/AdaptadorTransaccionJPA.java ===
package com.banca.infraestructura.adaptadores;

import com.banca.dominio.entidades.Transaccion;
import com.banca.dominio.repositorios.RepositorioTransaccion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class AdaptadorTransaccionJPA implements RepositorioTransaccion {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Transaccion guardar(Transaccion transaccion) {
        if (transaccion.getId() == null) {
            entityManager.persist(transaccion);
            return transaccion;
        } else {
            return entityManager.merge(transaccion);
        }
    }

    @Override
    public Optional<Transaccion> buscarPorId(String id) {
        Transaccion transaccion = entityManager.find(Transaccion.class, id);
        return Optional.ofNullable(transaccion);
    }

    @Override
    public List<Transaccion> buscarPorCuentaId(String cuentaId) {
        TypedQuery<Transaccion> query = entityManager.createQuery(
            "SELECT t FROM Transaccion t WHERE t.cuentaId = :cuentaId ORDER BY t.fechaTransaccion DESC",
            Transaccion.class
        );
        query.setParameter("cuentaId", cuentaId);
        return query.getResultList();
    }

    @Override
    public List<Transaccion> buscarPorCuentaIdYFecha(String cuentaId, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        TypedQuery<Transaccion> query = entityManager.createQuery(
            "SELECT t FROM Transaccion t WHERE t.cuentaId = :cuentaId " +
            "AND t.fechaTransaccion BETWEEN :fechaInicio AND :fechaFin " +
            "ORDER BY t.fechaTransaccion DESC",
            Transaccion.class
        );
        query.setParameter("cuentaId", cuentaId);
        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);
        return query.getResultList();
    }

    @Override
    public List<Transaccion> buscarTodos() {
        TypedQuery<Transaccion> query = entityManager.createQuery(
            "SELECT t FROM Transaccion t ORDER BY t.fechaTransaccion DESC",
            Transaccion.class
        );
        return query.getResultList();
    }

    @Override
    public void eliminar(String id) {
        Transaccion transaccion = entityManager.find(Transaccion.class, id);
        if (transaccion != null) {
            entityManager.remove(transaccion);
        }
    }

    @Override
    public boolean existePorId(String id) {
        Transaccion transaccion = entityManager.find(Transaccion.class, id);
        return transaccion != null;
    }

    @Override
    public List<Transaccion> buscarPorTipo(String cuentaId, String tipo) {
        TypedQuery<Transaccion> query = entityManager.createQuery(
            "SELECT t FROM Transaccion t WHERE t.cuentaId = :cuentaId AND t.tipo = :tipo " +
            "ORDER BY t.fechaTransaccion DESC",
            Transaccion.class
        );
        query.setParameter("cuentaId", cuentaId);
        query.setParameter("tipo", tipo);
        return query.getResultList();
    }
}

// === ARCHIVO: src/main/java/com/banca/infraestructura/repositorios/RepositorioClienteJPA.java ===
package com.banca.infraestructura.repositorios;

import com.banca.dominio.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioClienteJPA extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByIdentificacion(String identificacion);

    Optional<Cliente> findByCorreoElectronico(String correoElectronico);

    List<Cliente> findByActivoTrue();

    List<Cliente> findByActivoFalse();

    @Query("SELECT c FROM Cliente c WHERE c.nombre LIKE %:nombreParcial%")
    List<Cliente> buscarPorNombreParcial(@Param("nombreParcial") String nombreParcial);

    @Query("SELECT c FROM Cliente c JOIN c.cuentas cuenta WHERE cuenta.saldo > :saldoMinimo")
    List<Cliente> buscarClientesConCuentasSaldoMayorA(@Param("saldoMinimo") java.math.BigDecimal saldoMinimo);

    boolean existsByIdentificacion(String identificacion);

    boolean existsByCorreoElectronico(String correoElectronico);

    @Query("SELECT COUNT(c) FROM Cliente c WHERE c.activo = true")
    long contarClientesActivos();
}

// === ARCHIVO: src/main/java/com/banca/infraestructura/repositorios/RepositorioCuentaJPA.java ===
package com.banca.infraestructura.repositorios;

import com.banca.dominio.entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioCuentaJPA extends JpaRepository<Cuenta, Long> {

    Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);

    List<Cuenta> findByClienteId(Long clienteId);

    List<Cuenta> findByActivaTrue();

    List<Cuenta> findByActivaFalse();

    @Query("SELECT c FROM Cuenta c WHERE c.saldo >= :saldoMinimo AND c.saldo <= :saldoMaximo")
    List<Cuenta> buscarCuentasPorRangoSaldo(@Param("saldoMinimo") BigDecimal saldoMinimo, 
                                              @Param("saldoMaximo") BigDecimal saldoMaximo);

    @Query("SELECT c FROM Cuenta c WHERE c.fechaApertura >= :fechaInicio AND c.fechaApertura <= :fechaFin")
    List<Cuenta> buscarCuentasPorRangoFechas(@Param("fechaInicio") LocalDate fechaInicio, 
                                               @Param("fechaFin") LocalDate fechaFin);

    @Query("SELECT c FROM Cuenta c WHERE c.cliente.id = :clienteId AND c.activa = true")
    List<Cuenta> buscarCuentasActivasPorCliente(@Param("clienteId") Long clienteId);

    @Query("SELECT SUM(c.saldo) FROM Cuenta c WHERE c.cliente.id = :clienteId")
    BigDecimal calcularSaldoTotalPorCliente(@Param("clienteId") Long clienteId);

    @Query("SELECT c FROM Cuenta c WHERE c.tipoCuenta = :tipo")
    List<Cuenta> buscarPorTipo(@Param("tipo") String tipo);

    boolean existsByNumeroCuenta(String numeroCuenta);

    @Query("SELECT COUNT(c) FROM Cuenta c WHERE c.activa = true")
    long contarCuentasActivas();

    @Query("SELECT c FROM Cuenta c JOIN c.transacciones t WHERE t.id = :transaccionId")
    Optional<Cuenta> findByTransaccionId(@Param("transaccionId") Long transaccionId);
}

// === ARCHIVO: src/main/java/com/banca/infraestructura/repositorios/RepositorioTransaccionJPA.java ===
package com.banca.infraestructura.repositorios;

import com.banca.dominio.entidades.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioTransaccionJPA extends JpaRepository<Transaccion, Long> {

    List<Transaccion> findByCuentaOrigenId(Long cuentaOrigenId);

    List<Transaccion> findByCuentaDestinoId(Long cuentaDestinoId);

    @Query("SELECT t FROM Transaccion t WHERE t.cuentaOrigen.id = :cuentaId OR t.cuentaDestino.id = :cuentaId")
    List<Transaccion> findAllByCuentaId(@Param("cuentaId") Long cuentaId);

    @Query("SELECT t FROM Transaccion t WHERE t.fechaTransaccion >= :inicio AND t.fechaTransaccion <= :fin")
    List<Transaccion> buscarPorRangoFechas(@Param("inicio") LocalDateTime inicio, 
                                            @Param("fin") LocalDateTime fin);

    @Query("SELECT t FROM Transaccion t WHERE t.cuentaOrigen.id = :cuentaId AND t.fechaTransaccion >= :inicio AND t.fechaTransaccion <= :fin")
    List<Transaccion> buscarPorCuentaYRangoFechas(@Param("cuentaId") Long cuentaId, 
                                                    @Param("inicio") LocalDateTime inicio, 
                                                    @Param("fin") LocalDateTime fin);

    @Query("SELECT t FROM Transaccion t WHERE t.tipo = :tipo")
    List<Transaccion> buscarPorTipo(@Param("tipo") String tipo);

    @Query("SELECT t FROM Transaccion t WHERE t.monto >= :montoMinimo")
    List<Transaccion> buscarPorMontoMayorA(@Param("montoMinimo") BigDecimal montoMinimo);

    @Query("SELECT SUM(t.monto) FROM Transaccion t WHERE t.cuentaOrigen.id = :cuentaId AND t.tipo = 'DEBITO'")
    BigDecimal sumatoriaDebitosPorCuenta(@Param("cuentaId") Long cuentaId);

    @Query("SELECT SUM(t.monto) FROM Transaccion t WHERE t.cuentaDestino.id = :cuentaId AND t.tipo = 'CREDITO'")
    BigDecimal sumatoriaCreditosPorCuenta(@Param("cuentaId") Long cuentaId);

    @Query("SELECT t FROM Transaccion t WHERE t.estado = :estado")
    List<Transaccion> buscarPorEstado(@Param("estado") String estado);

    @Query("SELECT t FROM Transaccion t WHERE t.referencia like %:referenciaParcial%")
    List<Transaccion> buscarPorReferenciaParcial(@Param("referenciaParcial") String referenciaParcial);

    @Query("SELECT COUNT(t) FROM Transaccion t WHERE t.fechaTransaccion >= :inicio AND t.fechaTransaccion <= :fin")
    long contarTransaccionesEnRango(@Param("inicio") LocalDateTime inicio, 
                                     @Param("fin") LocalDateTime fin);

    @Query("SELECT t FROM Transaccion t WHERE t.cuentaOrigen.id = :cuentaId ORDER BY t.fechaTransaccion DESC")
    List<Transaccion> findUltimasTransaccionesOrigen(@Param("cuentaId") Long cuentaId);

    @Query("SELECT t FROM Transaccion t WHERE t.cuentaDestino.id = :cuentaId ORDER BY t.fechaTransaccion DESC")
    List<Transaccion> findUltimasTransaccionesDestino(@Param("cuentaId") Long cuentaId);
}

// === ARCHIVO: src/main/java/com/banca/infraestructura/controladores/ControladorCliente.java ===
package com.banca.infraestructura.controladores;

import com.banca.dominio.entidades.Cliente;
import com.banca.aplicacion.casosdeuso.CasoDeUsoCliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clientes")
public class ControladorCliente {

    private final CasoDeUsoCliente casoDeUsoCliente;

    public ControladorCliente(CasoDeUsoCliente casoDeUsoCliente) {
        this.casoDeUsoCliente = casoDeUsoCliente;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        List<Cliente> clientes = casoDeUsoCliente.obtenerTodos();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable UUID id) {
        return casoDeUsoCliente.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> crear(@Valid @RequestBody Cliente cliente) {
        Cliente creado = casoDeUsoCliente.guardar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(
            @PathVariable UUID id,
            @Valid @RequestBody Cliente cliente) {
        if (!id.equals(cliente.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Cliente actualizado = casoDeUsoCliente.actualizar(cliente);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        casoDeUsoCliente.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/documento/{numeroDocumento}")
    public ResponseEntity<Cliente> buscarPorDocumento(@PathVariable String numeroDocumento) {
        return casoDeUsoCliente.buscarPorNumeroDocumento(numeroDocumento)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/contar")
    public ResponseEntity<Long> contarClientes() {
        long total = casoDeUsoCliente.contar();
        return ResponseEntity.ok(total);
    }
}

// === ARCHIVO: src/main/java/com/banca/infraestructura/controladores/ControladorCuenta.java ===
package com.banca.infraestructura.controladores;

import com.banca.dominio.entidades.Cuenta;
import com.banca.aplicacion.casosdeuso.CasoDeUsoCuenta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cuentas")
public class ControladorCuenta {

    private final CasoDeUsoCuenta casoDeUsoCuenta;

    public ControladorCuenta(CasoDeUsoCuenta casoDeUsoCuenta) {
        this.casoDeUsoCuenta = casoDeUsoCuenta;
    }

    @GetMapping
    public ResponseEntity<List<Cuenta>> listarTodas() {
        List<Cuenta> cuentas = casoDeUsoCuenta.obtenerTodas();
        return ResponseEntity.ok(cuentas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> buscarPorId(@PathVariable UUID id) {
        return casoDeUsoCuenta.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cuenta> crear(@Valid @RequestBody Cuenta cuenta) {
        Cuenta creada = casoDeUsoCuenta.guardar(cuenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> actualizar(
            @PathVariable UUID id,
            @Valid @RequestBody Cuenta cuenta) {
        if (!id.equals(cuenta.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Cuenta actualizada = casoDeUsoCuenta.actualizar(cuenta);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        casoDeUsoCuenta.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Cuenta>> buscarPorClienteId(@PathVariable UUID clienteId) {
        List<Cuenta> cuentas = casoDeUsoCuenta.buscarPorClienteId(clienteId);
        return ResponseEntity.ok(cuentas);
    }

    @GetMapping("/numero/{numeroCuenta}")
    public ResponseEntity<Cuenta> buscarPorNumero(@PathVariable String numeroCuenta) {
        return casoDeUsoCuenta.buscarPorNumeroCuenta(numeroCuenta)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/depositar")
    public ResponseEntity<Cuenta> depositar(
            @PathVariable UUID id,
            @RequestParam BigDecimal monto) {
        return casoDeUsoCuenta.buscarPorId(id)
                .map(cuenta -> {
                    Cuenta actualizada = casoDeUsoCuenta.depositar(cuenta, monto);
                    return ResponseEntity.ok(actualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/retirar")
    public ResponseEntity<Cuenta> retirar(
            @PathVariable UUID id,
            @RequestParam BigDecimal monto) {
        return casoDeUsoCuenta.buscarPorId(id)
                .map(cuenta -> {
                    Cuenta actualizada = casoDeUsoCuenta.retirar(cuenta, monto);
                    return ResponseEntity.ok(actualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/contar")
    public ResponseEntity<Long> contarCuentas() {
        long total = casoDeUsoCuenta.contar();
        return ResponseEntity.ok(total);
    }
}

// === ARCHIVO: src/main/java/com/banca/infraestructura/controladores/ControladorTransaccion.java ===
package com.banca.infraestructura.controladores;

import com.banca.dominio.entidades.Transaccion;
import com.banca.aplicacion.casosdeuso.CasoDeUsoTransaccion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transacciones")
public class ControladorTransaccion {

    private static final Logger logger = LoggerFactory.getLogger(ControladorTransaccion.class);

    private final CasoDeUsoTransaccion casoDeUsoTransaccion;

    public ControladorTransaccion(CasoDeUsoTransaccion casoDeUsoTransaccion) {
        this.casoDeUsoTransaccion = casoDeUsoTransaccion;
    }

    @GetMapping
    public ResponseEntity<List<Transaccion>> listarTodas() {
        List<Transaccion> transacciones = casoDeUsoTransaccion.obtenerTodas();
        return ResponseEntity.ok(transacciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaccion> buscarPorId(@PathVariable UUID id) {
        return casoDeUsoTransaccion.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Transaccion> crear(@Valid @RequestBody Transaccion transaccion) {
        try {
            Transaccion creada = casoDeUsoTransaccion.guardar(transaccion);
            logger.info("Transacción creada con ID: {}", creada.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(creada);
        } catch (IllegalArgumentException e) {
            logger.warn("Error al crear transacción: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            logger.error("Error interno al crear transacción: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaccion> actualizar(
            @PathVariable UUID id,
            @Valid @RequestBody Transaccion transaccion) {
        if (!id.equals(transaccion.getId())) {
            return ResponseEntity.badRequest().build();
        }
        try {
            Transaccion actualizada = casoDeUsoTransaccion.actualizar(transaccion);
            return ResponseEntity.ok(actualizada);
        } catch (IllegalArgumentException e) {
            logger.warn("Error al actualizar transacción: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        casoDeUsoTransaccion.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cuenta/{cuentaId}")
    public ResponseEntity<List<Transaccion>> buscarPorCuentaId(@PathVariable UUID cuentaId) {
        List<Transaccion> transacciones = casoDeUsoTransaccion.buscarPorCuentaId(cuentaId);
        return ResponseEntity.ok(transacciones);
    }

    @GetMapping("/cuenta/{cuentaId}/rango")
    public ResponseEntity<List<Transaccion>> buscarPorCuentaIdYRangoFechas(
            @PathVariable UUID cuentaId,
            @RequestParam LocalDateTime fechaInicio,
            @RequestParam LocalDateTime fechaFin) {
        List<Transaccion> transacciones = casoDeUsoTransaccion
                .buscarPorCuentaIdYRangoFechas(cuentaId, fechaInicio, fechaFin);
        return ResponseEntity.ok(transacciones);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Transaccion>> buscarPorTipo(@PathVariable String tipo) {
        List<Transaccion> transacciones = casoDeUsoTransaccion.buscarPorTipo(tipo);
        return ResponseEntity.ok(transacciones);
    }

    @GetMapping("/contar")
    public ResponseEntity<Long> contarTransacciones() {
        long total = casoDeUsoTransaccion.contar();
        return ResponseEntity.ok(total);
    }

    @GetMapping("/cuenta/{cuentaId}/saldo")
    public ResponseEntity<BigDecimal> consultarSaldo(@PathVariable UUID cuentaId) {
        return casoDeUsoTransaccion.buscarPorCuentaId(cuentaId)
                .map(transacciones -> {
                    BigDecimal saldo = casoDeUsoTransaccion.calcularSaldo(transacciones);
                    return ResponseEntity.ok(saldo);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

// === ARCHIVO: src/main/java/com/banca/infraestructura/config/ConfiguracionJPA.java ===
package com.banca.infraestructura.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.banca.dominio.repositorios")
public class ConfiguracionJPA {

    @Autowired
    private Environment environment;

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        DataSourceProperties properties = dataSourceProperties();
        return properties
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.banca.dominio.entidades");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(false);
        vendorAdapter.setShowSql(Boolean.parseBoolean(environment.getProperty("spring.jpa.show-sql", "false")));
        em.setJpaVendorAdapter(vendorAdapter);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", environment.getProperty("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect"));
        properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("spring.jpa.hibernate.ddl-auto", "none"));
        properties.setProperty("hibernate.format_sql", environment.getProperty("spring.jpa.properties.hibernate.format_sql", "true"));
        properties.setProperty("hibernate.jdbc.batch_size", environment.getProperty("spring.jpa.properties.hibernate.jdbc.batch_size", "20"));
        properties.setProperty("hibernate.order_inserts", environment.getProperty("spring.jpa.properties.hibernate.order_inserts", "true"));
        properties.setProperty("hibernate.order_updates", environment.getProperty("spring.jpa.properties.hibernate.order_updates", "true"));
        properties.setProperty("hibernate.jdbc.batch_versioned_data", "true");

        em.setJpaProperties(properties);
        return em;
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}

// === ARCHIVO: src/main/java/com/banca/infraestructura/excepciones/ManejadorGlobalExcepciones.java ===
package com.banca.infraestructura.excepciones;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ManejadorGlobalExcepciones {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> manejarValidacion(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String nombreCampo = ((FieldError) error).getField();
            String mensajeError = error.getDefaultMessage();
            errores.put(nombreCampo, mensajeError);
        });

        Map<String, Object> respuesta = construirRespuestaError(
                HttpStatus.BAD_REQUEST.value(),
                "Error de validación en los datos proporcionados",
                errores,
                request
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> manejarIntegridad(DataIntegrityViolationException ex, WebRequest request) {
        String mensajeDetallado = "Se produjo un conflicto de integridad de datos";

        if (ex.getMostSpecificCause() != null) {
            String causa = ex.getMostSpecificCause().getMessage();
            if (causa != null) {
                if (causa.toLowerCase().contains("unique") || causa.toLowerCase().contains("duplicate")) {
                    mensajeDetallado = "Ya existe un registro con los mismos datos únicos";
                } else if (causa.toLowerCase().contains("foreign key")) {
                    mensajeDetallado = "El registro referencedo no existe";
                } else if (causa.toLowerCase().contains("not null")) {
                    mensajeDetallado = "Faltan datos obligatorios";
                }
            }
        }

        Map<String, Object> respuesta = construirRespuestaError(
                HttpStatus.CONFLICT.value(),
                mensajeDetallado,
                null,
                request
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(respuesta);
    }

    @ExceptionHandler(TransactionSystemException.class)
    public ResponseEntity<Map<String, Object>> manejarTransaccion(TransactionSystemException ex, WebRequest request) {
        String mensaje = "Error en la transacción de base de datos";

        if (ex.getMostSpecificCause() != null && ex.getMostSpecificCause().getMessage() != null) {
            String causa = ex.getMostSpecificCause().getMessage();
            if (causa.toLowerCase().contains("constraint")) {
                mensaje = "Violación de restricción de integridad";
            }
        }

        Map<String, Object> respuesta = construirRespuestaError(
                HttpStatus.BAD_REQUEST.value(),
                mensaje,
                null,
                request
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, Object>> manejarNoEncontrado(NoSuchElementException ex, WebRequest request) {
        Map<String, Object> respuesta = construirRespuestaError(
                HttpStatus.NOT_FOUND.value(),
                "El recurso solicitado no fue encontrado",
                null,
                request
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> manejarArgumentoIlegal(IllegalArgumentException ex, WebRequest request) {
        Map<String, Object> respuesta = construirRespuestaError(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage() != null ? ex.getMessage() : "Argumento inválido",
                null,
                request
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
    }

    @ExceptionHandler(JpaObjectRetrievalFailureException.class)
    public ResponseEntity<Map<String, Object>> manejarObjetoNoRecuperado(JpaObjectRetrievalFailureException ex, WebRequest request) {
        Map<String, Object> respuesta = construirRespuestaError(
                HttpStatus.NOT_FOUND.value(),
                "No se pudo recuperar el objeto solicitado de la base de datos",
                null,
                request
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity<Map<String, Object>> manejarUsoInvalidoAPI(InvalidDataAccessApiUsageException ex, WebRequest request) {
        Map<String, Object> respuesta = construirRespuestaError(
                HttpStatus.BAD_REQUEST.value(),
                "Uso inválido de la API de acceso a datos",
                null,
                request
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> manejarGeneral(Exception ex, WebRequest request) {
        Map<String, Object> respuesta = construirRespuestaError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Error interno del servidor",
                null,
                request
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
    }

    private Map<String, Object> construirRespuestaError(int estado, String mensaje, Map<String, String> detalles, WebRequest request) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("timestamp", LocalDateTime.now().toString());
        respuesta.put("status", estado);
        respuesta.put("error", HttpStatus.valueOf(estado).getReasonPhrase());
        respuesta.put("message", mensaje);
        respuesta.put("path", request.getDescription(false).replace("uri=", ""));

        if (detalles != null && !detalles.isEmpty()) {
            respuesta.put("details", detalles);
        }

        return respuesta;
    }
}

// === ARCHIVO: src/main/resources/db/migration/V1__Crear_esquema_banca.sql ===
-- Script de migracion Flyway para crear el esquema de banca
-- Version: V1__Crear_esquema_banca.sql
-- Descripcion: Crea las tablas principales del sistema de banca con normalizacion en 3FN
-- Autor: Sistema de migraciones Flyway
-- Fecha: 2024

-- Tabla de clientes
CREATE TABLE clientes (
    id BIGSERIAL PRIMARY KEY,
    identificacion VARCHAR(50) NOT NULL UNIQUE,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    telefono VARCHAR(20),
    direccion VARCHAR(500),
    fecha_registro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(20) NOT NULL DEFAULT 'ACTIVO' CHECK (estado IN ('ACTIVO', 'INACTIVO', 'BLOQUEADO')),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_clientes_identificacion ON clientes(identificacion);
CREATE INDEX idx_clientes_email ON clientes(email);
CREATE INDEX idx_clientes_estado ON clientes(estado);

-- Tabla de cuentas
CREATE TABLE cuentas (
    id BIGSERIAL PRIMARY KEY,
    numero_cuenta VARCHAR(50) NOT NULL UNIQUE,
    cliente_id BIGINT NOT NULL REFERENCES clientes(id) ON DELETE RESTRICT,
    tipo_cuenta VARCHAR(20) NOT NULL CHECK (tipo_cuenta IN ('AHORROS', 'CORRIENTE', 'PLAZO_FIJO')),
    saldo DECIMAL(19, 4) NOT NULL DEFAULT 0 CHECK (saldo >= 0),
    limite_sobregiro DECIMAL(19, 4) DEFAULT 0 CHECK (limite_sobregiro >= 0),
    tasa_interes DECIMAL(5, 4) DEFAULT 0 CHECK (tasa_interes >= 0),
    fecha_apertura TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_cierre TIMESTAMP,
    estado VARCHAR(20) NOT NULL DEFAULT 'ACTIVA' CHECK (estado IN ('ACTIVA', 'CERRADA', 'BLOQUEADA', 'SUSPENDIDA')),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_cuenta_numero UNIQUE (numero_cuenta)
);

CREATE INDEX idx_cuentas_numero ON cuentas(numero_cuenta);
CREATE INDEX idx_cuentas_cliente ON cuentas(cliente_id);
CREATE INDEX idx_cuentas_estado ON cuentas(estado);
CREATE INDEX idx_cuentas_tipo ON cuentas(tipo_cuenta);

-- Tabla de transacciones
CREATE TABLE transacciones (
    id BIGSERIAL PRIMARY KEY,
    cuenta_origen_id BIGINT NOT NULL REFERENCES cuentas(id) ON DELETE RESTRICT,
    cuenta_destino_id BIGINT REFERENCES cuentas(id) ON DELETE RESTRICT,
    tipo_transaccion VARCHAR(20) NOT NULL CHECK (tipo_transaccion IN ('DEPOSITO', 'RETIRO', 'TRANSFERENCIA', 'PAGO_SERVICIO', 'INTERES', 'COMISION')),
    monto DECIMAL(19, 4) NOT NULL CHECK (monto > 0),
    saldo_anterior DECIMAL(19, 4) NOT NULL,
    saldo_posterior DECIMAL(19, 4) NOT NULL,
    descripcion VARCHAR(500),
    referencia_externa VARCHAR(100),
    estado VARCHAR(20) NOT NULL DEFAULT 'COMPLETADA' CHECK (estado IN ('PENDIENTE', 'COMPLETADA', 'FALLIDA', 'CANCELADA', 'REVERTIDA')),
    fecha_ejecucion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_reversion TIMESTAMP,
    motivo_reversion VARCHAR(500),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_transacciones_cuenta_origen ON transacciones(cuenta_origen_id);
CREATE INDEX idx_transacciones_cuenta_destino ON transacciones(cuenta_destino_id);
CREATE INDEX idx_transacciones_fecha ON transacciones(fecha_ejecucion);
CREATE INDEX idx_transacciones_estado ON transacciones(estado);
CREATE INDEX idx_transacciones_tipo ON transacciones(tipo_transaccion);
CREATE INDEX idx_transacciones_referencia ON transacciones(referencia_externa);

-- Tabla de movimientos (historial detallado para auditoria)
CREATE TABLE movimientos (
    id BIGSERIAL PRIMARY KEY,
    transaccion_id BIGINT NOT NULL REFERENCES transacciones(id) ON DELETE CASCADE,
    cuenta_id BIGINT NOT NULL REFERENCES cuentas(id) ON DELETE RESTRICT,
    tipo_movimiento VARCHAR(20) NOT NULL CHECK (tipo_movimiento IN ('DEBITO', 'CREDITO')),
    monto DECIMAL(19, 4) NOT NULL CHECK (monto > 0),
    saldo_anterior DECIMAL(19, 4) NOT NULL,
    saldo_posterior DECIMAL(19, 4) NOT NULL,
    descripcion VARCHAR(500),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_movimientos_transaccion ON movimientos(transaccion_id);
CREATE INDEX idx_movimientos_cuenta ON movimientos(cuenta_id);
CREATE INDEX idx_movimientos_fecha ON movimientos(created_at);

-- Tabla de servicios (pagos de servicios)
CREATE TABLE servicios (
    id BIGSERIAL PRIMARY KEY,
    codigo_servicio VARCHAR(50) NOT NULL UNIQUE,
    nombre_servicio VARCHAR(255) NOT NULL,
    proveedor VARCHAR(255) NOT NULL,
    categoria VARCHAR(50) NOT NULL CHECK (categoria IN ('SERVICIOS_PUBLICOS', 'TELECOMUNICACIONES', 'SEGUROS', 'EDUCACION', 'OTROS')),
    comision_percentage DECIMAL(5, 2) DEFAULT 0 CHECK (comision_percentage >= 0 AND comision_percentage <= 100),
    comision_fija DECIMAL(19, 4) DEFAULT 0 CHECK (comision_fija >= 0),
    estado VARCHAR(20) NOT NULL DEFAULT 'ACTIVO' CHECK (estado IN ('ACTIVO', 'INACTIVO')),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_servicios_codigo ON servicios(codigo_servicio);
CREATE INDEX idx_servicios_categoria ON servicios(categoria);

-- Tabla de bitacora de operaciones (auditoria completa)
CREATE TABLE bitacora_operaciones (
    id BIGSERIAL PRIMARY KEY,
    entidad VARCHAR(100) NOT NULL,
    entidad_id BIGINT NOT NULL,
    operacion VARCHAR(20) NOT NULL CHECK (operacion IN ('INSERT', 'UPDATE', 'DELETE')),
    datos_anteriores JSONB,
    datos_nuevos JSONB,
    usuario VARCHAR(255),
    ip_origen VARCHAR(45),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_bitacora_entidad ON bitacora_operaciones(entidad, entidad_id);
CREATE INDEX idx_bitacora_fecha ON bitacora_operaciones(created_at);
CREATE INDEX idx_bitacora_usuario ON bitacora_operaciones(usuario);

-- Funcion para actualizar timestamps automaticamente
CREATE OR REPLACE FUNCTION actualizar_updated_at()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Triggers para actualizar timestamps
CREATE TRIGGER trigger_clientes_updated
    BEFORE UPDATE ON clientes
    FOR EACH ROW EXECUTE FUNCTION actualizar_updated_at();

CREATE TRIGGER trigger_cuentas_updated
    BEFORE UPDATE ON cuentas
    FOR EACH ROW EXECUTE FUNCTION actualizar_updated_at();

CREATE TRIGGER trigger_transacciones_updated
    BEFORE UPDATE ON transacciones
    FOR EACH ROW EXECUTE FUNCTION actualizar_updated_at();

CREATE TRIGGER trigger_servicios_updated
    BEFORE UPDATE ON servicios
    FOR EACH ROW EXECUTE FUNCTION actualizar_updated_at();

-- Funcion para registrar en bitacora
CREATE OR REPLACE FUNCTION registrar_bitacora()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO bitacora_operaciones (entidad, entidad_id, operacion, datos_anteriores, datos_nuevos)
    VALUES (
        TG_TABLE_NAME,
        NEW.id,
        TG_OP,
        CASE WHEN TG_OP = 'DELETE' THEN to_jsonb(OLD) ELSE NULL END,
        CASE WHEN TG_OP != 'DELETE' THEN to_jsonb(NEW) ELSE NULL END
    );
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger de bitacora para clientes
CREATE TRIGGER trigger_bitacora_clientes
    AFTER INSERT OR UPDATE OR DELETE ON clientes
    FOR EACH ROW EXECUTE FUNCTION registrar_bitacora();

-- Trigger de bitacora para cuentas
CREATE TRIGGER trigger_bitacora_cuentas
    AFTER INSERT OR UPDATE OR DELETE ON cuentas
    FOR EACH ROW EXECUTE FUNCTION registrar_bitacora();

-- Trigger de bitacora para transacciones
CREATE TRIGGER trigger_bitacora_transacciones
    AFTER INSERT OR UPDATE OR DELETE ON transacciones
    FOR EACH ROW EXECUTE FUNCTION registrar_bitacora();

-- Comentarios para documentacion
COMMENT ON TABLE clientes IS 'Almacena la informacion de los clientes del sistema bancario';
COMMENT ON TABLE cuentas IS 'Almacena las cuentas bancarias de los clientes';
COMMENT ON TABLE transacciones IS 'Registra todas las transacciones financieras del sistema';
COMMENT ON TABLE movimientos IS 'Historial detallado de movimientos por cuenta para auditoria';
COMMENT ON TABLE servicios IS 'Catalogo de servicios disponibles para pagos';
COMMENT ON TABLE bitacora_operaciones IS 'Bitacora de auditoria para todas las operaciones del sistema';

// === ARCHIVO: src/main/resources/db/migration/V2__Insertar_datos_prueba.sql ===
-- Script Flyway V2: Inserción de datos de prueba para validar el modelo normalizado
-- Este script populate las tablas Cliente, Cuenta y Transaccion con datos representativos
-- del dominio bancario para verificar la integridad referencial y el funcionamiento del modelo.

-- =============================================================================
-- INSERCIÓN DE CLIENTES
-- =============================================================================
INSERT INTO clientes (id, nombre, email, telefono, direccion, fecha_creacion, estado)
VALUES 
    ('a1b2c3d4-e5f6-7890-abcd-ef1234567890', 'Juan Pérez Gómez', 'juan.perez@email.com', '+34911234567', 'Calle Mayor 123, Madrid, 28013', '2024-01-15 09:30:00', 'ACTIVO'),
    ('b2c3d4e5-f6a7-8901-bcde-f12345678901', 'María López Fernández', 'maria.lopez@email.com', '+34911234568', 'Avenida Barcelona 45, Barcelona, 08010', '2024-02-20 14:15:00', 'ACTIVO'),
    ('c3d4e5f6-a7b8-9012-cdef-123456789012', 'Carlos Rodríguez Torres', 'carlos.rodriguez@email.com', '+34911234569', 'Plaza España 78, Sevilla, 41001', '2024-03-10 11:45:00', 'ACTIVO'),
    ('d4e5f6a7-b8c9-0123-defa-234567890123', 'Ana Martínez Sánchez', 'ana.martinez@email.com', '+34911234570', 'Calle Gran Vía 90, Bilbao, 48001', '2024-03-25 16:20:00', 'ACTIVO'),
    ('e5f6a7b8-c9d0-1234-efab-345678901234', 'Pedro García López', 'pedro.garcia@email.com', '+34911234571', 'Avenida Madrid 15, Valencia, 46001', '2024-04-05 10:00:00', 'INACTIVO'),
    ('f6a7b8c9-d0e1-2345-fabc-456789012345', 'Laura Díaz Ruiz', 'laura.diaz@email.com', '+34911234572', 'Calle Serrano 200, Madrid, 28006', '2024-04-18 13:30:00', 'ACTIVO'),
    ('g7b8c9d0-e1f2-3456-gbcd-567890123456', 'Miguel Hernández Castro', 'miguel.hernandez@email.com', '+34911234573', 'Calle Alcalá 50, Madrid, 28014', '2024-05-02 09:15:00', 'ACTIVO'),
    ('h8c9d0e1-f2a3-4567-hcde-678901234567', 'Sofia Jiménez Morales', 'sofia.jimenez@email.com', '+34911234574', 'Avenida Diagonal 300, Barcelona, 08006', '2024-05-20 15:45:00', 'ACTIVO'),
    ('i9d0e1f2-a3b4-5678-idef-789012345678', 'David Romero Vargas', 'david.romero@email.com', '+34911234575', 'Calle Larios 25, Málaga, 29001', '2024-06-01 12:00:00', 'ACTIVO'),
    ('j0e1f2a3-b4c5-6789-jefg-890123456789', 'Carmen Núñez Castillo', 'carmen.nunez@email.com', '+34911234576', 'Plaza Santa María 10, Santiago de Compostela, 15704', '2024-06-15 10:30:00', 'SUSPENDIDO');

-- =============================================================================
-- INSERCIÓN DE CUENTAS
-- =============================================================================
INSERT INTO cuentas (id, numero_cuenta, saldo, tipo_cuenta, cliente_id, fecha_creacion, estado)
VALUES 
    ('c1a1b2c3-d4e5-f6a7-b8c9-d0e1f2a3b4c5', 'ES7621001122334455667788', 15000.00, 'CUENTA_AHORRO', 'a1b2c3d4-e5f6-7890-abcd-ef1234567890', '2024-01-16 10:00:00', 'ACTIVA'),
    ('c2b2c3d4-e5f6-a7b8-c9d0-e1f2a3b4c5d6', 'ES9821002233445566778899', 5000.00, 'CUENTA_CORRIENTE', 'a1b2c3d4-e5f6-7890-abcd-ef1234567890', '2024-01-17 11:30:00', 'ACTIVA'),
    ('c3c3d4e5-f6a7-b8c9-d0e1-f2a3b4c5d6e7', 'ES7621003344556677889900', 25000.50, 'CUENTA_AHORRO', 'b2c3d4e5-f6a7-8901-bcde-f12345678901', '2024-02-21 09:00:00', 'ACTIVA'),
    ('c4d4e5f6-a7b8-c9d0-e1f2-a3b4c5d6e7f8', 'ES7621004455667788990011', 1200.75, 'CUENTA_SALARIO', 'b2c3d4e5-f6a7-8901-bcde-f12345678901', '2024-02-22 10:15:00', 'ACTIVA'),
    ('c5e5f6a7-b8c9-d0e1-f2a3-b4c5d6e7f8a9', 'ES9821005566778899001122', 8000.00, 'CUENTA_CORRIENTE', 'c3d4e5f6-a7b8-9012-cdef-123456789012', '2024-03-11 14:00:00', 'ACTIVA'),
    ('c6f6a7b8-c9d0-e1f2-a3b4-c5d6e7f8a9b0', 'ES7621006677889900112233', 45000.25, 'CUENTA_AHORRO', 'd4e5f6a7-b8c9-0123-defa-234567890123', '2024-03-26 09:30:00', 'ACTIVA'),
    ('c7a7b8c9-d0e1-f2a3-b4c5-d6e7f8a9b0c1', 'ES9821007788990011223344', 0.00, 'CUENTA_CORRIENTE', 'e5f6a7b8-c9d0-1234-efab-345678901234', '2024-04-06 11:00:00', 'BLOQUEADA'),
    ('c8b8c9d0-e1f2-a3b4-c5d6-e7f8a9b0c1d2', 'ES7621008899001122334455', 35000.00, 'CUENTA_AHORRO', 'f6a7b8c9-d0e1-2345-fabc-456789012345', '2024-04-19 15:00:00', 'ACTIVA'),
    ('c9c9d0e1-f2a3-b4c5-d6e7-f8a9b0c1d2e3', 'ES9821009900112233445566', 15000.00, 'CUENTA_SALARIO', 'g7b8c9d0-e1f2-3456-gbcd-567890123456', '2024-05-03 10:30:00', 'ACTIVA'),
    ('c0d0e1f2-a3b4-c5d6-e7f8-a9b0c1d2e3f4', 'ES7621000011223344556677', 22000.00, 'CUENTA_CORRIENTE', 'h8c9d0e1-f2a3-4567-hcde-678901234567', '2024-05-21 12:00:00', 'ACTIVA'),
    ('c1d1e1f2-a3b4-c5d6-e7f8-a9b0-c1d2e3f4a5', 'ES9821001122334455667789', 500.00, 'CUENTA_AHORRO', 'i9d0e1f2-a3b4-5678-idef-789012345678', '2024-06-02 09:45:00', 'ACTIVA'),
    ('c2e2f2a3-b4c5-d6e7-f8a9-b0c1-d2e3f4a5b6', 'ES7621002233445566778890', 100.00, 'CUENTA_CORRIENTE', 'j0e1f2a3-b4c5-6789-jefg-890123456789', '2024-06-16 14:00:00', 'SUSPENDIDA');

-- =============================================================================
-- INSERCIÓN DE TRANSACCIONES
-- =============================================================================
INSERT INTO transacciones (id, cuenta_id, tipo_transaccion, monto, descripcion, fecha_transaccion, estado, referencia_externa)
VALUES 
    ('t1a1b2c3-d4e5-f6a7-b8c9-d0e1f2a3b4c5', 'c1a1b2c3-d4e5-f6a7-b8c9-d0e1f2a3b4c5', 'DEPOSITO', 5000.00, 'Depósito inicial cuenta ahorro', '2024-01-16 10:15:00', 'COMPLETADA', 'DEP-2024-001'),
    ('t2b2c3d4-e5f6-a7b8-c9d0-e1f2a3b4c5d6', 'c1a1b2c3-d4e5-f6a7-b8c9-d0e1f2a3b4c5', 'TRANSFERENCIA_ENTRADA', 2500.00, 'Transferencia recibida de María López', '2024-01-20 11:30:00', 'COMPLETADA', 'TRF-2024-002'),
    ('t3c3d4e5-f6a7-b8c9-d0e1-f2a3b4c5d6e7', 'c1a1b2c3-d4e5-f6a7-b8c9-d0e1f2a3b4c5', 'RETIRO', 1000.00, 'Retiro en cajero automático', '2024-02-05 16:45:00', 'COMPLETADA', 'RET-2024-003'),
    ('t4d4e5f6-a7b8-c9d0-e1f2-a3b4c5d6e7f8', 'c2b2c3d4-e5f6-a7b8-c9d0-e1f2a3b4c5d6', 'PAGO', 150.75, 'Pago servicios luz', '2024-01-25 09:00:00', 'COMPLETADA', 'PAG-2024-004'),
    ('t5e5f6a7-b8c9-d0e1-f2a3-b4c5d6e7f8a9', 'c2b2c3d4-e5f6-a7b8-c9d0-e1f2a3b4c5d6', 'DEPOSITO', 3500.00, 'Depósito nómina enero', '2024-01-30 08:00:00', 'COMPLETADA', 'NOM-2024-005'),
    ('t6f6a7b8-c9d0-e1f2-a3b4-c5d6e7f8a9b0', 'c3c3d4e5-f6a7-b8c9-d0e1-f2a3b4c5d6e7', 'DEPOSITO', 15000.00, 'Depósito inicial cuenta ahorro', '2024-02-21 09:30:00', 'COMPLETADA', 'DEP-2024-006'),
    ('t7a7b8c9-d0e1-f2a3-b4c5-d6e7f8a9b0c1', 'c3c3d4e5-f6a7-b8c9-d0e1-f2a3b4c5d6e7', 'TRANSFERENCIA_SALIDA', 5000.00, 'Transferencia a cuenta corriente', '2024-02-25 14:00:00', 'COMPLETADA', 'TRF-2024-007'),
    ('t8b8c9d0-e1f2-a3b4-c5d6-e7f8a9b0c1d2', 'c4d4e5f6-a7b8-c9d0-e1f2-a3b4c5d6e7f8', 'PAGO', 450.00, 'Pago alquiler marzo', '2024-03-01 10:00:00', 'COMPLETADA', 'PAG-2024-008'),
    ('t9c9d0e1-f2a3-b4c5-d6e7-f8a9b0c1d2e3', 'c4d4e5f6-a7b8-c9d0-e1f2-a3b4c5d6e7f8', 'DEPOSITO', 1200.75, 'Depósito nómina febrero', '2024-02-28 08:15:00', 'COMPLETADA', 'NOM-2024-009'),
    ('t0d0e1f2-a3b4-c5d6-e7f8-a9b0c1d2e3f4', 'c5e5f6a7-b8c9-d0e1-f2a3-b4c5d6e7f8a9', 'DEPOSITO', 8000.00, 'Depósito inicial cuenta corriente', '2024-03-11 14:30:00', 'COMPLETADA', 'DEP-2024-010'),
    ('t1e1f2a3-b4c5-d6e7-f8a9-b0c1-d2e3f4a5b6', 'c5e5f6a7-b8c9-d0e1-f2a3-b4c5d6e7f8a9', 'TRANSFERENCIA_ENTRADA', 3000.00, 'Transferencia recibida de Juan Pérez', '2024-03-15 17:00:00', 'COMPLETADA', 'TRF-2024-011'),
    ('t2f2a3b4-c5d6-e7f8-a9b0-c1d2e3f4a5b6c7', 'c6f6a7b8-c9d0-e1f2-a3b4-c5d6e7f8a9b0', 'DEPOSITO', 45000.25, 'Depósito inicial cuenta ahorro', '2024-03-26 10:00:00', 'COMPLETADA', 'DEP-2024-012'),
    ('t3a3b4c5-d6e7-f8a9-b0c1-d2e3f4a5b6c7d8', 'c6f6a7b8-c9d0-e1f2-a3b4-c5d6e7f8a9b0', 'RETIRO', 5000.00, 'Retiro parcial cuenta ahorro', '2024-04-10 11:00:00', 'COMPLETADA', 'RET-2024-013'),
    ('t4b4c5d6-e7f8-a9b0-c1d2-e3f4a5b6c7d8e9', 'c7a7b8c9-d0e1-f2a3-b4c5-d6e7f8a9b0c1', 'PAGO', 200.00, 'Pago servicios agua', '2024-04-10 09:30:00', 'COMPLETADA', 'PAG-2024-014'),
    ('t5c5d6e7-f8a9-b0c1-d2e3-f4a5b6c7d8e9f0', 'c8b8c9d0-e1f2-a3b4-c5d6-e7f8a9b0c1d2', 'DEPOSITO', 35000.00, 'Depósito inicial cuenta ahorro', '2024-04-19 15:30:00', 'COMPLETADA', 'DEP-2024-015'),
    ('t6d6e7f8-a9b0c1-d2e3-f4a5-b6c7d8e9f0a1', 'c8b8c9d0-e1f2-a3b4-c5d6-e7f8a9b0c1d2', 'TRANSFERENCIA_SALIDA', 10000.00, 'Transferencia a cuenta inversión', '2024-05-05 12:00:00', 'COMPLETADA', 'TRF-2024-016'),
    ('t7e7f8a9-b0c1-d2e3-f4a5-b6c7-d8e9f0a1b2', 'c9c9d0e1-f2a3-b4c5-d6e7-f8a9b0c1d2e3', 'DEPOSITO', 15000.00, 'Depósito nómina mayo', '2024-05-31 08:30:00', 'COMPLETADA', 'NOM-2024-017'),
    ('t8f8a9b0-c1d2-e3f4-a5b6-c7d8e9f0a1b2c3', 'c0d0e1f2-a3b4-c5d6-e7f8-a9b0c1d2e3f4', 'DEPOSITO', 22000.00, 'Depósito inicial cuenta corriente', '2024-05-21 12:30:00', 'COMPLETADA', 'DEP-2024-018'),
    ('t9a9b0c1-d2e3-f4a5b6-c7d8e9f0a1b2c3d4', 'c0d0e1f2-a3b4-c5d6-e7f8-a9b0c1d2e3f4', 'PAGO', 500.50, 'Pago tarjeta crédito', '2024-06-01 10:00:00', 'COMPLETADA', 'PAG-2024-019'),
    ('t0b0c1d2-e3f4-a5b6-c7d8-e9f0a1b2c3d4e5', 'c1d1e1f2-a3b4-c5d6-e7f8-a9b0-c1d2e3f4a5', 'DEPOSITO', 500.00, 'Depósito inicial cuenta ahorro', '2024-06-02 10:00:00', 'COMPLETADA', 'DEP-2024-020'),
    ('t1c1d1e2-f3a4-b5c6-d7e8-f9a0b1c2d3e4f5', 'c1d1e1f2-a3b4-c5d6-e7f8-a9b0-c1d2e3f4a5', 'RETIRO', 200.00, 'Retiro cajero automático', '2024-06-10 15:00:00', 'COMPLETADA', 'RET-2024-021'),
    ('t2d2e2f3-a4b5-c6d7-e8f9-a0b1-c2d3e4f5a6b7', 'c2e2f2a3-b4c5-d6e7-f8a9-b0c1-d2e3f4a5b6', 'DEPOSITO', 100.00, 'Depósito inicial cuenta corriente', '2024-06-16 14:30:00', 'PENDIENTE', 'DEP-2024-022'),
    ('t3e3f3a4-b5c6-d7e8-f9a0-b1c2d3e4f5a6b7c8', 'c3c3d4e5-f6a7-b8c9-d0e1-f2a3b4c5d6e7', 'TRANSFERENCIA_SALIDA', 1000.00, 'Transferencia a cuenta terceros', '2024-06-18 11:00:00', 'FALLIDA', 'TRF-2024-023'),
    ('t4f4a4b5-c6d7-e8f9-a0b1-c2d3e4f5a6b7c8d9', 'c4d4e5f6-a7b8-c9d0-e1f2-a3b4c5d6e7f8', 'PAGO', 1200.75, 'Pago alquiler abril', '2024-04-01 09:00:00', 'COMPLETADA', 'PAG-2024-024'),
    ('t5a5b5c6-d7e8-f9a0b1-c2d3-e4f5a6b7c8d9e0', 'c4d4e5f6-a7b8-c9d0-e1f2-a3b4c5d6e7f8', 'PAGO', 1200.75, 'Pago alquiler mayo', '2024-05-01 09:00:00', 'COMPLETADA', 'PAG-2024-025');

-- =============================================================================
-- VERIFICACIÓN DE INTEGRIDAD REFERENCIAL
-- =============================================================================
-- Verificar que todas las cuentas tienen cliente válido
SELECT COUNT(*) AS cuentas_sin_cliente 
FROM cuentas c 
LEFT JOIN clientes cl ON c.cliente_id = cl.id 
WHERE cl.id IS NULL;

-- Verificar que todas las transacciones tienen cuenta válida
SELECT COUNT(*) AS transacciones_sin_cuenta 
FROM transacciones t 
LEFT JOIN cuentas c ON t.cuenta_id = c.id 
WHERE c.id IS NULL;

-- =============================================================================
-- CONSULTAS DE VERIFICACIÓN DEL MODELO NORMALIZADO
-- =============================================================================
-- Total de clientes por estado
SELECT estado, COUNT(*) AS total 
FROM clientes 
GROUP BY estado;

-- Total de cuentas por tipo y estado
SELECT tipo_cuenta, estado, COUNT(*) AS total, SUM(saldo) AS saldo_total 
FROM cuentas 
GROUP BY tipo_cuenta, estado 
ORDER BY tipo_cuenta, estado;

-- Transacciones por tipo
SELECT tipo_transaccion, COUNT(*) AS total, SUM(monto) AS monto_total 
FROM transacciones 
GROUP BY tipo_transaccion 
ORDER BY total DESC;

-- Promedio de saldo por tipo de cuenta
SELECT tipo_cuenta, AVG(saldo) AS promedio_saldo, MIN(saldo) AS saldo_minimo, MAX(saldo) AS saldo_maximo 
FROM cuentas 
WHERE estado = 'ACTIVA' 
GROUP BY tipo_cuenta;

// === ARCHIVO: src/test/java/com/banca/dominio/entidades/ClienteTest.java ===
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

// === ARCHIVO: src/test/java/com/banca/dominio/entidades/CuentaTest.java ===
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

// === ARCHIVO: src/test/java/com/banca/dominio/entidades/TransaccionTest.java ===
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

// === ARCHIVO: src/test/java/com/banca/aplicacion/casosdeuso/CasoDeUsoTransaccionTest.java ===
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

// === ARCHIVO: README.md ===
# Servicio de Banca - Modelo de Datos Normalizado

## Descripción del Proyecto

Este proyecto implementa un servicio de banca con un modelo de datos completamente normalizado según las formas normales de base de datos. El sistema gestiona clientes, cuentas y transacciones con integridad referencial completa y validación de reglas de negocio.

## Requisitos Técnicos

- **Java**: Versión 21
- **Spring Boot**: Versión 3.5.6
- **Base de Datos**: PostgreSQL 42.7.3
- **Migraciones**: Flyway 10.14.0
- **Build Tool**: Maven
- **Testing**: JUnit 5.10.2, AssertJ 3.25.3

## Estructura del Proyecto

```
banca-service/
├── src/
│   ├── main/
│   │   ├── java/com/banca/
│   │   │   ├── Application.java                 # Punto de entrada
│   │   │   ├── dominio/
│   │   │   │   ├── entidades/                   # Entidades del dominio
│   │   │   │   │   ├── Cliente.java
│   │   │   │   │   ├── Cuenta.java
│   │   │   │   │   └── Transaccion.java
│   │   │   │   └── repositorios/                # Puertos (interfaces)
│   │   │   │       ├── RepositorioCliente.java
│   │   │   │       ├── RepositorioCuenta.java
│   │   │   │       └── RepositorioTransaccion.java
│   │   │   ├── aplicacion/
│   │   │   │   └── casosdeuso/                  # Casos de uso
│   │   │   │       ├── CasoDeUsoCliente.java
│   │   │   │       ├── CasoDeUsoCuenta.java
│   │   │   │       └── CasoDeUsoTransaccion.java
│   │   │   └── infraestructura/
│   │   │       ├── adaptadores/                 # Adaptadores JPA
│   │   │       ├── controladores/               # Controladores REST
│   │   │       ├── repositorios/                # Implementaciones JPA
│   │   │       ├── config/                      # Configuración
│   │   │       └── excepciones/                 # Manejo de errores
│   │   └── resources/
│   │       ├── application.yml                  # Configuración
│   │       └── db/migration/                    # Migraciones Flyway
│   │           ├── V1__Crear_esquema_banca.sql
│   │           └── V2__Insertar_datos_prueba.sql
│   └── test/
│       └── java/com/banca/
│           └── aplicacion/casosdeuso/           # Tests de integración
└── pom.xml
```

## Modelo de Datos Normalizado

### Tercera Forma Normal (3FN)

El modelo de datos cumple con la tercera forma normal, eliminando redundancias y asegurando dependencias funcionales completas:

#### Entidad: CLIENTE
| Columna | Tipo | Restricciones |
|---------|------|---------------|
| id | VARCHAR(36) | PK, NOT NULL |
| nombre | VARCHAR(100) | NOT NULL |
| email | VARCHAR(150) | UNIQUE, NOT NULL |
| telefono | VARCHAR(20) | NOT NULL |

#### Entidad: CUENTA
| Columna | Tipo | Restricciones |
|---------|------|---------------|
| id | VARCHAR(36) | PK, NOT NULL |
| numero | VARCHAR(20) | UNIQUE, NOT NULL |
| saldo | DECIMAL(15,2) | NOT NULL, DEFAULT 0 |
| tipo | VARCHAR(30) | NOT NULL |
| activa | BOOLEAN | NOT NULL, DEFAULT TRUE |
| cliente_id | VARCHAR(36) | FK -> CLIENTE(id), NOT NULL |

#### Entidad: TRANSACCION
| Columna | Tipo | Restricciones |
|---------|------|---------------|
| id | VARCHAR(36) | PK, NOT NULL |
| cuenta_id | VARCHAR(36) | FK -> CUENTA(id), NOT NULL |
| monto | DECIMAL(15,2) | NOT NULL |
| tipo | VARCHAR(20) | NOT NULL (DEPOSITO, EXTRACCION, TRANSFERENCIA) |
| descripcion | VARCHAR(255) | NULL |
| fecha | TIMESTAMP | NOT NULL, DEFAULT CURRENT_TIMESTAMP |

### Relaciones

- **CLIENTE -> CUENTA**: Uno a Muchos (Un cliente puede tener múltiples cuentas)
- **CUENTA -> TRANSACCION**: Uno a Muchos (Una cuenta puede tener múltiples transacciones)
- Las transacciones registran movimientos con signo: depósitos positivos, extracciones negativos

## Cómo Ejecutar

### Compilación

```bash
mvn clean compile
```

### Ejecución de Tests

```bash
mvn test
```

### Ejecución de la Aplicación

```bash
mvn spring-boot:run
```

La aplicación arrancará en `http://localhost:8080`

### Perfiles

- **default**: Configuración para desarrollo local con PostgreSQL
- **test**: Configuración para ejecución de tests (base de datos en memoria)

## API REST Endpoints

### Clientes
- `POST /api/clientes` - Crear cliente
- `GET /api/clientes/{id}` - Obtener cliente por ID
- `GET /api/clientes` - Listar todos los clientes
- `PUT /api/clientes/{id}` - Actualizar cliente
- `DELETE /api/clientes/{id}` - Eliminar cliente

### Cuentas
- `POST /api/cuentas` - Crear cuenta
- `GET /api/cuentas/{id}` - Obtener cuenta por ID
- `GET /api/cuentas` - Listar todas las cuentas
- `GET /api/cuentas/cliente/{clienteId}` - Listar cuentas de un cliente
- `PUT /api/cuentas/{id}` - Actualizar cuenta
- `DELETE /api/cuentas/{id}` - Eliminar cuenta

### Transacciones
- `POST /api/transacciones/deposito` - Realizar depósito
- `POST /api/transacciones/extraccion` - Realizar extracción
- `POST /api/transacciones/transferencia` - Realizar transferencia
- `GET /api/transacciones/cuenta/{cuentaId}` - Consultar historial de cuenta

## Reglas de Negocio Implementadas

1. **Saldo insuficiente**: Las extracciones y transferencias se rechazan si el saldo es menor al monto solicitado
2. **Cuentas inactivas**: No se permiten transacciones hacia o desde cuentas inactivas
3. **Validación de montos**: Los montos negativos o cero son rechazados
4. **Transferencias a la misma cuenta**: Se rechazan transferencias origen = destino
5. **Integridad referencial**: Todas las relaciones están enforced a nivel de base de datos

## Migraciones Flyway

Las migraciones se encuentran en `src/main/resources/db/migration/`:

- **V1__Crear_esquema_banca.sql**: Crea las tablas CLIENTE, CUENTA y TRANSACCION con sus restricciones
- **V2__Insertar_datos_prueba.sql**: Inserta datos de prueba para desarrollo

## Métricas de Rendimiento

- Volumen pico soportado: 10,000 transacciones/hora
- Latencia máxima: 500ms
- Cumplimiento: 3FN con índices optimizados para consultas frecuentes
```
