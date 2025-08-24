package com.sicopi.application.port.out.persistence.persona;

import com.sicopi.domain.model.persona.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PersonaAbs {
    Persona registrarPersonaAbs(Persona persona);
    Optional<Persona> findPersonaPorId(Long idPersona);
    Page<Persona> listaDePersonas(Pageable pageable);
}
