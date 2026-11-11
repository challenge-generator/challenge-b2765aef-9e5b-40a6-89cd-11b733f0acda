# Normalización de Datos en una Base de Datos de Banca

El equipo de desarrollo de una entidad financiera necesita implementar un proceso de normalización en una base de datos para mejorar la eficiencia y reducir la redundancia. El objetivo es aplicar las formas normales y utilizar un modelo Entidad-Relación para representar la estructura de los datos. Los actores involucrados son el Analista de Datos, el Desarrollador Backend y el Administrador de Base de Datos. La base de datos debe soportar un volumen pico de 10,000 transacciones por hora con una latencia máxima de 500ms. La normalización debe considerar la consistencia de los datos y la capacidad de manejar errores de integridad.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Diseño e Implementación de un Modelo de Datos Normalizado |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Análisis de Requisitos y Modelado Inicial

**Objetivo:** Identificar las entidades y relaciones necesarias para el modelo de datos.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Analiza los requisitos del negocio para determinar las entidades y relaciones necesarias.
- Crea un modelo Entidad-Relación inicial que represente la estructura de los datos.

**Entregable:** Modelo Entidad-Relación inicial.

<details>
<summary>Pistas de conocimiento</summary>

- Considera las formas normales y cómo aplicarlas al modelo.
- Identifica posibles relaciones entre las entidades.

</details>

### Fase 2: Aplicación de Formas Normales

**Objetivo:** Aplicar las formas normales al modelo de datos para eliminar redundancias y mejorar la integridad.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Aplica las formas normales al modelo Entidad-Relación creado en la fase anterior.
- Verifica que el modelo cumpla con los requisitos de normalización y elimina redundancias.

**Entregable:** Modelo de datos normalizado.

<details>
<summary>Pistas de conocimiento</summary>

- Revisa cada entidad y relación para asegurar que cumple con las formas normales.
- Considera cómo manejar errores de integridad en el modelo normalizado.

</details>

### Fase 3: Implementación y Verificación

**Objetivo:** Implementar el modelo de datos normalizado en la base de datos y verificar su funcionamiento.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Implementa el modelo de datos normalizado en la base de datos.
- Verifica que el modelo funcione correctamente y cumple con los requisitos de normalización.

**Entregable:** Base de datos normalizada y verificada.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza las herramientas y tecnologías adecuadas para implementar el modelo en la base de datos.
- Realiza pruebas para verificar que el modelo cumple con los requisitos de normalización y maneja correctamente los errores de integridad.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un modelo de datos normalizado y por qué es importante en una base de datos?
- **paraQueSirve**: ¿Para qué sirve aplicar las formas normales a un modelo de datos?
- **comoSeUsa**: ¿Cómo se aplican las formas normales a un modelo de datos en el contexto de una entidad financiera?
- **erroresComunes**: ¿Cuáles son los errores comunes al aplicar las formas normales a un modelo de datos?
- **queDecisionesImplica**: ¿Qué decisiones implica la implementación de un modelo de datos normalizado en una base de datos?

## Criterios de Evaluacion

- Modelo Entidad-Relación inicial creado.
- Modelo de datos normalizado aplicado.
- Base de datos normalizada y verificada implementada.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
