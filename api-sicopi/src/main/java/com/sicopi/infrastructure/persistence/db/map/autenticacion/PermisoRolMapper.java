package com.sicopi.infrastructure.persistence.db.map.autenticacion;

import com.sicopi.domain.model.autenticacion.PermisoRol;
import com.sicopi.infrastructure.persistence.db.entity.autenticacion.PermisoRolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PermisoRolMapper {
    PermisoRolMapper INSTANCE = Mappers.getMapper(PermisoRolMapper.class);

    PermisoRolEntity toPermisoRolEntity(PermisoRol permisoRol);
    PermisoRol toPermisoRol(PermisoRolEntity permisoRolEntity);
}
