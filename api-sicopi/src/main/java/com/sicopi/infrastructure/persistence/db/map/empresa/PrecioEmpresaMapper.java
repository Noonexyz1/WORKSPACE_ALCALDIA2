package com.sicopi.infrastructure.persistence.db.map.empresa;

import com.sicopi.domain.model.empresa.PrecioEmpresa;
import com.sicopi.infrastructure.persistence.db.entity.empresa.PrecioEmpresaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PrecioEmpresaMapper {

    PrecioEmpresaMapper INSTANCE = Mappers.getMapper(PrecioEmpresaMapper.class);

    PrecioEmpresaEntity toPrecioEmpresaEntity(PrecioEmpresa precioEmpresa);
    PrecioEmpresa toPrecioEmpresa(PrecioEmpresaEntity precioEmpresaEntity);
}
