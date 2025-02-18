package com.app.orientanet.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class PruebaResultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String carreraSugerida;
    private int puntajeTotal;

    @OneToOne
    @JoinColumn(name = "prueba_id")
    private PruebaVocacional prueba;
}
