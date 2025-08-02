package com.sicopi.application.port.in.persona;

import com.sicopi.domain.model.persona.Persona;

public interface PersonaService {
    Persona registrarPersona(Persona persona);
    Persona editarPersona(Long idPersona, Persona persona);
}
