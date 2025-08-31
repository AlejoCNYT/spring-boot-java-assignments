package io.econexion.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(indexes=@Index(columnList="ean", unique=true))
public class Product {
    @Id
    private UUID id = UUID.randomUUID();
    @Column(nullable=false, unique=true) private String ean; // código de barras
    private String name;
    @ManyToOne(optional=false) private Material material;
    private String howToDispose; // "Contenedor plástico", etc.
}
