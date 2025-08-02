package com.sicopi.infrastructure.persistence.db.map.fotocopia;

import com.sicopi.domain.model.fotocopia.FotoAutorizada;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.FotoAutorizadaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FotoAutorizadaMapper {

    FotoAutorizadaMapper INSTANCE = Mappers.getMapper(FotoAutorizadaMapper.class);

    FotoAutorizadaEntity toFotoAutorizadaEntity(FotoAutorizada fotoAutorizada);
    FotoAutorizada toFotoAutorizada(FotoAutorizadaEntity fotoAutorizadaEntity);
}
