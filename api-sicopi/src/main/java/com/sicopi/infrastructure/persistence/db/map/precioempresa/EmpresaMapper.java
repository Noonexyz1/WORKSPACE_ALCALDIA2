package com.sicopi.infrastructure.persistence.db.map.precioempresa;

import com.sicopi.domain.model.precioempresa.Empresa;
import com.sicopi.infrastructure.persistence.db.entity.precioempresa.EmpresaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmpresaMapper {

    EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);

    EmpresaEntity toEmpresaEntity(Empresa empresa);
    Empresa toEmpresa(EmpresaEntity empresaEntity);
}
