package com.sicopi.infrastructure.persistence.db.entity.autenticacion;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "permiso_rol")
public class PermisoRolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean activo;

    @ManyToOne
    private RolEntity rol;
    @ManyToOne
    private PermisoEntity permiso;
}
