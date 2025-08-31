package io.econexion.web;

import io.econexion.dto.AuthResponse;
import io.econexion.dto.LoginRequest;
import io.econexion.dto.SignupRequest;
import io.econexion.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService svc;
    public AuthController(AuthService svc){ this.svc = svc; }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest r){
        svc.signup(r);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest r){
        return svc.login(r);
    }
}
