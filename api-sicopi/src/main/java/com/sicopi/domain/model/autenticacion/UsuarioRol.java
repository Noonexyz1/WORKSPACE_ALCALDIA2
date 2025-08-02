package com.sicopi.domain.model.autenticacion;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioRol {
    private Long id;
    private Boolean isActive;

    private Usuario usuario;
    private Rol rol;

    //Aqui deberia poner la fecha, pero por temas de negocio no ira aqui
    //Pero por temas de auditoria si ira en una tabla de CREACION
}
