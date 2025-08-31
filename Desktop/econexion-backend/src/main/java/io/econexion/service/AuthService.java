package io.econexion.service;


import io.econexion.domain.User;
import io.econexion.dto.AuthResponse;
import io.econexion.dto.LoginRequest;
import io.econexion.dto.SignupRequest;
import io.econexion.repo.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepo users; private final PasswordEncoder enc; private final io.econexion.config.JwtUtil jwt;
    public AuthService(UserRepo users, PasswordEncoder enc, io.econexion.config.JwtUtil jwt){
        this.users=users; this.enc=enc; this.jwt=jwt;
    }
    public void signup(SignupRequest r){
        users.findByEmail(r.email()).ifPresent(u -> { throw new RuntimeException("Email in use"); });
        var u = new User(); u.setName(r.name()); u.setEmail(r.email());
        u.setPasswordHash(enc.encode(r.password())); u.setRole(r.role()==null? io.econexion.domain.Role.CITIZEN : r.role());
        users.save(u);
    }
    public AuthResponse login(LoginRequest r){
        var u = users.findByEmail(r.email()).orElseThrow(() -> new RuntimeException("Invalid credentials"));
        if(!enc.matches(r.password(), u.getPasswordHash())) throw new RuntimeException("Invalid credentials");
        String token = jwt.generate(u.getEmail());
        return new AuthResponse(token, u.getName(), u.getRole().name());
    }
}
