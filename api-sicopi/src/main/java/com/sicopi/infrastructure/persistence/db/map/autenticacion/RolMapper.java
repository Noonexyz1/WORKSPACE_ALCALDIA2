package com.sicopi.infrastructure.persistence.db.map.autenticacion;

import com.sicopi.domain.model.autenticacion.Rol;
import com.sicopi.infrastructure.persistence.db.entity.autenticacion.RolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RolMapper {
    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    RolEntity toRolEntity(Rol rol);
    Rol toRol(RolEntity rolEntity);
}
