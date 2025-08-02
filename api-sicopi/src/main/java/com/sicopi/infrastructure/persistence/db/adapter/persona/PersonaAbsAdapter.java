package com.sicopi.infrastructure.persistence.db.adapter.persona;

import com.sicopi.application.port.out.persistence.persona.PersonaAbs;
import com.sicopi.domain.model.persona.Persona;
import com.sicopi.infrastructure.persistence.db.entity.persona.PersonaEntity;
import com.sicopi.infrastructure.persistence.db.map.persona.PersonaMapper;
import com.sicopi.infrastructure.persistence.db.repository.persona.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonaAbsAdapter implements PersonaAbs {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona registrarPersonaAbs(Persona persona) {
        PersonaEntity personaEntity = this.personaRepository
                .save(PersonaMapper.INSTANCE.toPersonaEntity(persona));
        return PersonaMapper.INSTANCE.toPersona(personaEntity);
    }

    @Override
    public Persona editarPersonaAbs(Persona persona) {
        PersonaEntity personaEntity = this.personaRepository
                .save(PersonaMapper.INSTANCE.toPersonaEntity(persona));
        return PersonaMapper.INSTANCE.toPersona(personaEntity);
    }

    @Override
    public Persona findPersonaPorId(Long idPersona) {
        Optional<PersonaEntity> personaEntity = this.personaRepository.findById(idPersona);
        return personaEntity.map(PersonaMapper.INSTANCE::toPersona).orElse(null);
    }
}
