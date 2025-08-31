package io.econexion.repo;

import io.econexion.domain.Pickup;
import org.springframework.data.jpa.repository.JpaRepository;   // <-- IMPORT CLAVE

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public interface PickupRepo extends JpaRepository<Pickup, UUID> {
    List<Pickup> findByScheduledAtBetween(OffsetDateTime start, OffsetDateTime end);
}
