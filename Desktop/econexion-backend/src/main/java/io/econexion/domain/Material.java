package io.econexion.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Material {
    @Id
    private UUID id = UUID.randomUUID();
    @Column(nullable=false, unique=true) private String name;
    @Column(nullable=false) private double ecoPointsFactor; // p.ej. 10 para aluminio
}
