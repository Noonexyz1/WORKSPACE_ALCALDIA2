package com.sicopi.domain.model.autenticacion;

import com.sicopi.domain.model.persona.Persona;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioRol {
    private Long id;
    private Rol rol;
    private Persona persona;

    private Boolean isActive;
    //Aqui deberia poner la fecha, pero por temas de negocio no ira aqui
    //Pero por temas de auditoria si ira en una tabla de CREACION
}
