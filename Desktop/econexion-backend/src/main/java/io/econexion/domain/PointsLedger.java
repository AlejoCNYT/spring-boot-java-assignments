package io.econexion.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity @Getter @Setter @NoArgsConstructor
public class PointsLedger {
    @Id private UUID id = UUID.randomUUID();
    @ManyToOne(optional=false) private User user;
    @ManyToOne private Pickup pickup;
    private int deltaPoints;
    private String reason; // "PICKUP_BONUS", etc.
    private OffsetDateTime createdAt = OffsetDateTime.now();
}
