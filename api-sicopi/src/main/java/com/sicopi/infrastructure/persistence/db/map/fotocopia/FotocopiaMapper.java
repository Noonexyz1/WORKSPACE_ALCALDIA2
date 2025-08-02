package com.sicopi.infrastructure.persistence.db.map.fotocopia;

import com.sicopi.domain.model.fotocopia.Fotocopia;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.FotocopiaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FotocopiaMapper {

    FotocopiaMapper INSTANCE = Mappers.getMapper(FotocopiaMapper.class);

    FotocopiaEntity toFotocopiaEntity(Fotocopia fotocopia);
    Fotocopia toFotocopia(FotocopiaEntity fotocopiaEntity);
}
