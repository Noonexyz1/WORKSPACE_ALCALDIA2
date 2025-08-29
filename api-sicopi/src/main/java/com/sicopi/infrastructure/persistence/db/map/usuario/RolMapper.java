package com.sicopi.infrastructure.persistence.db.map.usuario;

import com.sicopi.domain.model.usuario.Rol;
import com.sicopi.infrastructure.persistence.db.entity.usuario.RolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RolMapper {
    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    RolEntity toRolEntity(Rol rol);
    Rol toRol(RolEntity rolEntity);
}
