// repo/ProductRepo.java
package io.econexion.repo;
import io.econexion.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional; import java.util.UUID;
public interface ProductRepo extends JpaRepository<Product, UUID> {
    Optional<Product> findByEan(String ean);
}
