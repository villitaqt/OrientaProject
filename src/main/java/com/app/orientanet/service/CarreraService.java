package com.app.orientanet.service;

import com.app.orientanet.exceptions.ResourceNotFoundException;
import com.app.orientanet.model.entity.Carrera;
import com.app.orientanet.repository.CarreraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarreraService {

    private final CarreraRepository carreraRepository;

    public Carrera saveCarrera (Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    public List<Carrera> getAllCarreras() {
        return carreraRepository.findAll();
    }

    public void deleteCarrera (Integer id) {
        if (!carreraRepository.existsById(id)){
            throw new RuntimeException("El carrera no existe");
        }
        carreraRepository.deleteById(id);
    }

    public Carrera updateCarrera (Integer id, Carrera carrera) {
        return carreraRepository.findById(id)
                .map(existingCarrera -> {
                    existingCarrera.setNombre(carrera.getNombre());
                    existingCarrera.setDescripcion(carrera.getDescripcion());
                    return carreraRepository.save(existingCarrera);
                }).orElseThrow(() -> new RuntimeException("Carrera no Encontrada!"));
    }
}
