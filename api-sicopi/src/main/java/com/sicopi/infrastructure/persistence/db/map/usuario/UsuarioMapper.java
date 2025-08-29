package com.sicopi.infrastructure.persistence.db.map.usuario;

import com.sicopi.domain.model.usuario.Usuario;
import com.sicopi.infrastructure.persistence.db.entity.usuario.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioEntity toUsuarioEntity(Usuario usuario);
    Usuario toUsuario(UsuarioEntity usuarioEntity);
}
