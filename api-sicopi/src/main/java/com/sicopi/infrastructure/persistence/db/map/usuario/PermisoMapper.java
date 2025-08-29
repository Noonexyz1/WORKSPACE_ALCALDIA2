package com.sicopi.infrastructure.persistence.db.map.usuario;

import com.sicopi.domain.model.usuario.Permiso;
import com.sicopi.infrastructure.persistence.db.entity.usuario.PermisoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PermisoMapper {
    PermisoMapper INSTANCE = Mappers.getMapper(PermisoMapper.class);

    Permiso toPermiso(PermisoEntity permisoEntity);
    PermisoEntity toPermisoEntity(Permiso permiso);
}
