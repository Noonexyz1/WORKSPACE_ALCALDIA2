package com.sicopi.domain.model.persona;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonaFormacion {
    private Long id;
    private Persona persona;
    private Formacion formacion;
    private Boolean activo;
    //Si el negocio necesita la fecha, entonces pongo la fecha
    //Los demas fechas es solo para autidoria
}
