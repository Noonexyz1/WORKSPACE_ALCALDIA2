package com.sicopi.infrastructure.persistence.db.map.fotocopia;

import com.sicopi.domain.model.fotocopia.FotoFinalizada;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.FotoFinalizadaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FotoFinalizadaMapper {

    FotoFinalizadaMapper INSTANCE = Mappers.getMapper(FotoFinalizadaMapper.class);

    FotoFinalizadaEntity toFotoFinalizadaEntity(FotoFinalizada fotoFinalizada);
    FotoFinalizada toFotoFinalizada(FotoFinalizadaEntity fotoFinalizadaEntity);
}
