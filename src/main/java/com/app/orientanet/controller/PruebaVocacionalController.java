package com.app.orientanet.controller;

import com.app.orientanet.model.entity.PruebaResultado;
import com.app.orientanet.service.PruebaVocacionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.orientanet.model.entity.PruebaVocacional;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pruebas-vocacionales")
@RequiredArgsConstructor
class PruebaVocacionalController {
    private final PruebaVocacionalService pruebaVocacionalService;

    @PostMapping("/crear")
    public ResponseEntity<PruebaVocacional> crearPrueba(@RequestBody PruebaVocacional prueba) {
        PruebaVocacional nuevaPrueba = pruebaVocacionalService.savePrueba(prueba);
        return ResponseEntity.ok(nuevaPrueba);
    }

    @DeleteMapping("/{id}/eliminar")
    public ResponseEntity<Void> eliminarPrueba(@PathVariable Integer id) {
        pruebaVocacionalService.deletePrueba(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/evaluar")
    public ResponseEntity<PruebaResultado> evaluarPrueba(@PathVariable Integer id, @RequestBody Map<Integer, Integer> respuestas) {
        PruebaResultado resultado = pruebaVocacionalService.evaluarRespuestas(id, respuestas);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping()
    public ResponseEntity<List<PruebaVocacional>> listarPruebas() {
        List<PruebaVocacional> pruebas = pruebaVocacionalService.getAllPruebas();
        return ResponseEntity.ok(pruebas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PruebaVocacional> buscarPrueba(@PathVariable ("id") Integer id) {
        PruebaVocacional prueba = pruebaVocacionalService.getPruebaById(id);
        return ResponseEntity.ok(prueba);
    }

}
