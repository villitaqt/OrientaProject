package com.app.orientanet.model.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    private Usuario usuario;

    private String studentode;
}
