package com.sicopi.infrastructure.persistence.db.map.empresa;

import com.sicopi.domain.model.empresa.PrecioFotocopia;
import com.sicopi.infrastructure.persistence.db.entity.empresa.PrecioFotocopiaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PrecioFotocopiaMapper {

    PrecioFotocopiaMapper INSTANCE = Mappers.getMapper(PrecioFotocopiaMapper.class);

    PrecioFotocopiaEntity toPrecioFotocopiaEntity(PrecioFotocopia precioFotocopia);
    PrecioFotocopia toPrecioFotocopia(PrecioFotocopiaEntity precioFotocopiaEntity);
}
