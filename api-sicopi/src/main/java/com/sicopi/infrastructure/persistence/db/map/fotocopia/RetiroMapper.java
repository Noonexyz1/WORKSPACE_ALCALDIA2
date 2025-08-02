package com.sicopi.infrastructure.persistence.db.map.fotocopia;

import com.sicopi.domain.model.fotocopia.Retiro;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.RetiroEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RetiroMapper {

    RetiroMapper INSTANCE = Mappers.getMapper(RetiroMapper.class);

    RetiroEntity toRetiroEntity(Retiro retiro);
    Retiro toRetiro(RetiroEntity retiroEntity);
}
