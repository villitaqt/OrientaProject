package com.app.orientanet.controller;

import com.app.orientanet.model.entity.Carrera;
import com.app.orientanet.repository.CarreraRepository;
import com.app.orientanet.service.CarreraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carreras")
@RequiredArgsConstructor
public class CarreraController {

    private final CarreraService carreraService;

    @PostMapping
    public ResponseEntity<Carrera> createCarrera(@RequestBody Carrera carrera) {
        Carrera newCarrera = carreraService.saveCarrera(carrera);
        return  ResponseEntity.ok().body(newCarrera);
    }

    @GetMapping
    public ResponseEntity<List<Carrera>> getAllCarreras() {
        return ResponseEntity.ok().body(carreraService.getAllCarreras());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Carrera> updateCarrera(@PathVariable Integer id, @RequestBody Carrera carrera) {
        return ResponseEntity.ok().body(carreraService.updateCarrera(id, carrera));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCarrera(@PathVariable Integer id){
        carreraService.deleteCarrera(id);
        return ResponseEntity.ok().build();
    }
}
