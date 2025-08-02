package com.sicopi.infrastructure.persistence.db.entity.autenticacion;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "rol")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID único del rol
    private String nombre; // Ej: "ROLE_ADMIN", "ROLE_USER", "ROLE_MANAGER"
    private String descripcion; // Opcional: una descripción más detallada del rol

    @OneToMany(mappedBy = "rol")
    private List<UsuarioRolEntity> usuarioRolEntityList;
    @OneToMany(mappedBy = "rol")
    private List<PermisoRolEntity> permisoRolEntityList;
}
