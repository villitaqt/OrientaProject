package com.app.orientanet.service;


import com.app.orientanet.model.entity.*;
import com.app.orientanet.repository.CarreraRepository;
import com.app.orientanet.repository.PruebaVocacionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PruebaVocacionalService {
    private final PruebaVocacionalRepository pruebaVocacionalRepository;
    private final CarreraRepository carreraRepository;

    public PruebaVocacional savePrueba(PruebaVocacional prueba) {
        System.out.println("Creando nueva prueba: " + prueba.getNombre());

        if (prueba.getPreguntas() != null) {
            System.out.println("existen pruebas");
            for (Pregunta pregunta : prueba.getPreguntas()) {
                if (pregunta.getOpciones() != null) {
                    System.out.println("existen opciones");
                    for (Opcion opcion : pregunta.getOpciones()) {
                        System.out.println('a');
                        Carrera carrera = carreraRepository.findById(opcion.getCarrera().getId())
                                .orElseThrow(() -> new RuntimeException("Carrera con ID " + opcion.getCarrera().getId() + " no encontrada"));
                        opcion.setCarrera(carrera);
                    }
                }
            }
        }

        prueba.asignarPruebaAPreguntas();
        return pruebaVocacionalRepository.save(prueba);
    }

    public void deletePrueba(Integer id) {
//        Optinal<PruebaVocacional> prueba = pruebaVocacionalRepository.findById(id);
//        .asignarPruebaAPreguntas();
        return;
    }

    public PruebaResultado evaluarRespuestas(Integer pruebaId, Map<Integer, Integer> respuestas) {
        PruebaVocacional prueba = pruebaVocacionalRepository.findById(pruebaId)
                .orElseThrow(() -> new RuntimeException("Prueba no encontrada"));

        System.out.println("Evaluando respuestas para la prueba: " + prueba.getNombre());
        Map<Carrera, Integer> puntajes = new HashMap<>();

        for (Pregunta pregunta : prueba.getPreguntas()) {
            pregunta.debugPregunta();
            Integer opcionSeleccionadaId = respuestas.get(pregunta.getId());
            if (opcionSeleccionadaId != null) {
                for (Opcion opcion : pregunta.getOpciones()) {
                    if (opcion.getId().equals(opcionSeleccionadaId)) {
                        opcion.debugOpcion();
                        puntajes.put(opcion.getCarrera(), puntajes.getOrDefault(opcion.getCarrera(), 0) + opcion.getValor());
                    }
                }
            }
        }

        Carrera carreraRecomendada = puntajes.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        int puntajeTotal = puntajes.getOrDefault(carreraRecomendada, 0);

        PruebaResultado resultado = new PruebaResultado(null, carreraRecomendada, puntajeTotal, prueba);
        resultado.debugResultado();
        return resultado;
    }

    public List<PruebaVocacional> getAllPruebas() {
        return pruebaVocacionalRepository.findAll();
    }

    public PruebaVocacional getPruebaById (Integer id) {
        return pruebaVocacionalRepository.findById(id)
                .orElseThrow(() ->  new RuntimeException("Prueba no encontrada"));
    }
}