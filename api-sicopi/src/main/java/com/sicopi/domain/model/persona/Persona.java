package com.sicopi.domain.model.persona;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Persona {
    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Long edad;
    private String email;
    private String telefono;
}
