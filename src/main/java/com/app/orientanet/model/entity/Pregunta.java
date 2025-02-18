package com.app.orientanet.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Opcion> opciones;

    @ManyToOne
    @JoinColumn(name = "prueba_id")
    private PruebaVocacional prueba;
}
