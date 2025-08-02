package com.sicopi.infrastructure.persistence.db.map.autenticacion;

import com.sicopi.domain.model.autenticacion.UsuarioRol;
import com.sicopi.infrastructure.persistence.db.entity.autenticacion.UsuarioRolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioRolMapper {
    UsuarioRolMapper INSTANCE = Mappers.getMapper(UsuarioRolMapper.class);

    UsuarioRolEntity toUsuarioRolEntity(UsuarioRol usuarioRol);
    UsuarioRol toUsuarioRol(UsuarioRolEntity usuarioRolEntity);
}
