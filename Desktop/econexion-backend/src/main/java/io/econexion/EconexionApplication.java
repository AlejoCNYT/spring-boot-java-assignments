package io.econexion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@SpringBootApplication
public class EconexionApplication {
    public static void main(String[] args) {
        SpringApplication.run(EconexionApplication.class, args);
    }

    // Endpoint mínimo para verificar que corre sin necesidad de más clases
    @RestController
    @RequestMapping
    static class HealthController {
        @GetMapping("/ping")
        public String ping() {
            return "pong";
        }

        @GetMapping("/version")
        public Map<String, String> version() {
            return Map.of("app", "econexion-backend", "status", "ok");
        }
    }
}
