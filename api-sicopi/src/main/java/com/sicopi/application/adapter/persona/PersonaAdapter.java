package com.sicopi.application.adapter.persona;

import com.sicopi.application.port.in.persona.PersonaService;
import com.sicopi.application.port.out.persistence.persona.PersonaAbs;
import com.sicopi.domain.model.persona.Persona;

public class PersonaAdapter implements PersonaService {

    private final PersonaAbs personaAbs;

    public PersonaAdapter(PersonaAbs personaAbs) {
        this.personaAbs = personaAbs;
    }

    @Override
    public Persona registrarPersona(Persona persona) {
        return this.personaAbs.registrarPersonaAbs(persona);
    }

    @Override
    public Persona editarPersona(Long idPersona, Persona persona) {
        Persona personaEntrada = this.personaAbs.findPersonaPorId(idPersona);
        if (personaEntrada == null) {
            throw new RuntimeException("Esta persona con este Id no existe");
        }
        persona.setId(idPersona);
        return this.personaAbs.registrarPersonaAbs(persona);
    }
}
