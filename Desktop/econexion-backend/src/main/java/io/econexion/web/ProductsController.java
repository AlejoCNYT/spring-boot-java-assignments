package io.econexion.web;

import io.econexion.repo.ProductRepo; import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController @RequestMapping("/products")
public class ProductsController {
    private final ProductRepo repo;
    public ProductsController(ProductRepo repo){ this.repo=repo; }

    @GetMapping("/{ean}")
    public ResponseEntity<?> byEan(@PathVariable String ean){
        return repo.findByEan(ean).<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
