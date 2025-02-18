package com.app.orientanet.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Opcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String texto;
    private int valor;
    @ManyToOne
    @JoinColumn(name = "pregunta_id")
    private Pregunta pregunta;

}
