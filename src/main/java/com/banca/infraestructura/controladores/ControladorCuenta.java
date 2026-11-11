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