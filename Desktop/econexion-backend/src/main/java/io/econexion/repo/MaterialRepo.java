package io.econexion.repo;
import io.econexion.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
public interface MaterialRepo extends JpaRepository<Material, UUID> {}
