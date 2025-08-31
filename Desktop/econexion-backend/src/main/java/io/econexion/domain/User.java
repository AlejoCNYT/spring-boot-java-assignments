package io.econexion.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="users", uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class User {
    @Id
    private UUID id = UUID.randomUUID();
    private String name;
    @Column(nullable=false, unique=true) private String email;
    @Column(nullable=false) private String passwordHash;
    @Enumerated(EnumType.STRING) private Role role = Role.CITIZEN;
}
