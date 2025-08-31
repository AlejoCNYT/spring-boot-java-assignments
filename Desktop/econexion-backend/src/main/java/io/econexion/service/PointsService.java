// service/PointsService.java (esqueleto)
package io.econexion.service;

import io.econexion.domain.Quality; import org.springframework.stereotype.Service;

@Service
public class PointsService {
    public int compute(double weightKg, double factor, Quality q){
        double mult = switch (q) { case EXCELLENT -> 1.2; case FAIR -> 1.0; case POOR -> 0.5; };
        return (int)Math.round(weightKg * factor * mult);
    }
}
