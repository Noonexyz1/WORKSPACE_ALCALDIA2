package com.sicopi.application.port.out.persistence.persona;

import com.sicopi.domain.model.persona.Persona;

public interface PersonaAbs {
    Persona registrarPersonaAbs(Persona persona);
    Persona editarPersonaAbs(Persona persona);
    Persona findPersonaPorId(Long idPersona);
}
