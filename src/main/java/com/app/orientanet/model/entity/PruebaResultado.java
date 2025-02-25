package com.app.orientanet.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PruebaResultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carreraSugerida;

    private int puntajeTotal;

    @OneToOne
    @JoinColumn(name = "prueba_id")
    private PruebaVocacional prueba;

    public void debugResultado() {
        System.out.println("Resultado ID: " + id + ", Carrera Sugerida: " + carreraSugerida.getNombre() + ", Puntaje Total: " + puntajeTotal);
    }
}
