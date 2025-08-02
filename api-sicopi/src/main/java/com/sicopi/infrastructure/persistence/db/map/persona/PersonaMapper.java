package com.sicopi.infrastructure.persistence.db.map.persona;

import com.sicopi.domain.model.persona.Persona;
import com.sicopi.infrastructure.persistence.db.entity.persona.PersonaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonaMapper {
    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    PersonaEntity toPersonaEntity(Persona persona);
    Persona toPersona(PersonaEntity personaEntity);
}
