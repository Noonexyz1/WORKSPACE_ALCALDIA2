package com.sicopi.infrastructure.persistence.db.map.autenticacion;

import com.sicopi.domain.model.autenticacion.Permiso;
import com.sicopi.infrastructure.persistence.db.entity.autenticacion.PermisoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PermisoMapper {
    PermisoMapper INSTANCE = Mappers.getMapper(PermisoMapper.class);

    Permiso toPermiso(PermisoEntity permisoEntity);
    PermisoEntity toPermisoEntity(Permiso permiso);
}
