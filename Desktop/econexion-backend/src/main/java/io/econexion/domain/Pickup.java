package io.econexion.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.econexion.domain.User;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(indexes=@Index(columnList="scheduledAt"))
public class Pickup {
    @Id
    private UUID id = UUID.randomUUID();
    @ManyToOne(optional=false) private User citizen;
    @ManyToOne private User collector;
    private String address;
    private Double lat, lng;
    private OffsetDateTime scheduledAt;
    @Enumerated(EnumType.STRING) private PickupStatus status = PickupStatus.REQUESTED;
}
