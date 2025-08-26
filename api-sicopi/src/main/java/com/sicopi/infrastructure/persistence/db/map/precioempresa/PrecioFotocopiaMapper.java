package com.sicopi.infrastructure.persistence.db.map.precioempresa;

import com.sicopi.domain.model.precioempresa.PrecioFotocopia;
import com.sicopi.infrastructure.persistence.db.entity.precioempresa.PrecioFotocopiaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PrecioFotocopiaMapper {

    PrecioFotocopiaMapper INSTANCE = Mappers.getMapper(PrecioFotocopiaMapper.class);

    PrecioFotocopiaEntity toPrecioFotocopiaEntity(PrecioFotocopia precioFotocopia);
    PrecioFotocopia toPrecioFotocopia(PrecioFotocopiaEntity precioFotocopiaEntity);
}
