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