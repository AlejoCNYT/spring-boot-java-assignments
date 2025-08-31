package io.econexion.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity @Getter @Setter @NoArgsConstructor
public class PickupItem {
    @Id private UUID id = UUID.randomUUID();
    @ManyToOne(optional=false) private Pickup pickup;
    @ManyToOne(optional=false) private Material material;
    private double weightKg;
    @Enumerated(EnumType.STRING) private Quality quality;
}
