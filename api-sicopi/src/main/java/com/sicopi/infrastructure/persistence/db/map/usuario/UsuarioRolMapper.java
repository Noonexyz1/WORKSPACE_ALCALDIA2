package com.sicopi.infrastructure.persistence.db.map.usuario;

import com.sicopi.domain.model.usuario.UsuarioRol;
import com.sicopi.infrastructure.persistence.db.entity.usuario.UsuarioRolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioRolMapper {
    UsuarioRolMapper INSTANCE = Mappers.getMapper(UsuarioRolMapper.class);

    UsuarioRolEntity toUsuarioRolEntity(UsuarioRol usuarioRol);
    UsuarioRol toUsuarioRol(UsuarioRolEntity usuarioRolEntity);
}
