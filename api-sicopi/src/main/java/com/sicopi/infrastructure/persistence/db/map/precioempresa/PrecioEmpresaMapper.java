package com.sicopi.infrastructure.persistence.db.map.precioempresa;

import com.sicopi.domain.model.precioempresa.PrecioEmpresa;
import com.sicopi.infrastructure.persistence.db.entity.precioempresa.PrecioEmpresaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PrecioEmpresaMapper {

    PrecioEmpresaMapper INSTANCE = Mappers.getMapper(PrecioEmpresaMapper.class);

    PrecioEmpresaEntity toPrecioEmpresaEntity(PrecioEmpresa precioEmpresa);
    PrecioEmpresa toPrecioEmpresa(PrecioEmpresaEntity precioEmpresaEntity);
}
