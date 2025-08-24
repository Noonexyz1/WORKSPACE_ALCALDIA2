package com.sicopi.application.port.in.persona;

import com.sicopi.domain.model.persona.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PersonaService {
    Persona registrarPersona(Persona persona);
    Persona editarPersona(Long idPersona, Persona persona);
    Optional<Persona> encontrarPersona(Long idPersona);
    Page<Persona> listaDePersonas(Pageable pageable);
}
