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