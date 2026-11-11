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