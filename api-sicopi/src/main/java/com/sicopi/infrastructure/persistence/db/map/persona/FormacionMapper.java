package com.sicopi.infrastructure.persistence.db.map.persona;

import com.sicopi.domain.model.persona.Formacion;
import com.sicopi.infrastructure.persistence.db.entity.persona.FormacionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FormacionMapper {
    FormacionMapper INSTANCE = Mappers.getMapper(FormacionMapper.class);

    FormacionEntity toFormacionEntity(Formacion formacion);
    Formacion toFormacion(FormacionEntity formacionSave);
}



