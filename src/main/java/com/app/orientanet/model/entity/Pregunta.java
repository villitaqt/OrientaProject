package com.app.orientanet.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String enunciado;

    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Opcion> opciones = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "prueba_id")
    private PruebaVocacional prueba;

    public void asignarPreguntaAOpciones() {
        if (opciones != null) {
            for (Opcion opcion : opciones) {
                opcion.setPregunta(this);
            }
        }
    }

    public void debugPregunta() {
        System.out.println("Pregunta ID: " + id + ", Enunciado: " + enunciado);
    }
}
