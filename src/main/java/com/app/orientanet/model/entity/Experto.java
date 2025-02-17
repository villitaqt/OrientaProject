package com.app.orientanet.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "expertos")
public class Experto {

    @Id

    private Long id;
    @OneToOne
    @MapsId
    private Usuario usuario;

    private String expertiseField;
}
