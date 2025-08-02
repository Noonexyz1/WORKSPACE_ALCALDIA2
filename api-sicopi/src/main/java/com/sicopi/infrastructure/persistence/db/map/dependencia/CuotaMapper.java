package com.sicopi.infrastructure.persistence.db.map.dependencia;

import com.sicopi.domain.model.dependencia.Cuota;
import com.sicopi.infrastructure.persistence.db.entity.dependencia.CuotaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CuotaMapper {

    CuotaMapper INSTANCE = Mappers.getMapper(CuotaMapper.class);

    CuotaEntity toCuotaEntity(Cuota cuota);
    Cuota toCuota(CuotaEntity cuotaEntity);
}

