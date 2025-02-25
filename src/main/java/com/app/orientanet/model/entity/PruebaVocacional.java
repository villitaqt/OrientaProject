package com.app.orientanet.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PruebaVocacional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @OneToMany(mappedBy = "prueba", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Pregunta> preguntas;

    public void asignarPruebaAPreguntas() {
        if (preguntas != null) {
            for (Pregunta pregunta : preguntas) {
                pregunta.setPrueba(this);
                pregunta.asignarPreguntaAOpciones();
            }
        }
    }
}
