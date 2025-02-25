package com.app.orientanet.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "expertos")
public class Experto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @MapsId
    @JsonBackReference
    private Usuario usuario;

    @Column(name = "expertise_field")
    private String expertiseField;
}
