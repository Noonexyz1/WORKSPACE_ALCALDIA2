package com.sicopi.infrastructure.persistence.db.entity.autenticacion;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "permiso")
public class PermisoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "permiso")
    private List<PermisoRolEntity> permisoRolEntityList;
}
