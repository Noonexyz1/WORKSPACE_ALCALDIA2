package com.sicopi.infrastructure.persistence.db.entity.usuario;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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

    private LocalDateTime fechaCreacion;

    @PrePersist
    public void iniciarValores() {
        this.fechaCreacion = LocalDateTime.now();
    }
}
