package com.sicopi.infrastructure.persistence.db.entity.autenticacion;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuario_rol")
public class UsuarioRolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean isActive;

    @ManyToOne
    private UsuarioEntity usuario;
    @ManyToOne
    private RolEntity rol;
    //Aqui deberia poner la fecha, pero por temas de negocio no ira aqui
    //Pero por temas de auditoria si ira en una tabla de CREACION
}
