package com.sicopi.domain.model.autenticacion;

import com.sicopi.domain.model.persona.Persona;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Usuario {
    private Long id;
    private String username;
    private String password;
    // private Boolean activo;
    private Persona persona;
}
