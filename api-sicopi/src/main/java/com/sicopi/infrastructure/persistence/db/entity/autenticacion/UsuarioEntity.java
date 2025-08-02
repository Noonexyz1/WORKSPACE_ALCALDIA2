package com.sicopi.infrastructure.persistence.db.entity.autenticacion;

import com.sicopi.infrastructure.persistence.db.entity.persona.PersonaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    // private Boolean activo;

    @ManyToOne
    private PersonaEntity persona;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioRolEntity> usuarioRolEntityList;
}
