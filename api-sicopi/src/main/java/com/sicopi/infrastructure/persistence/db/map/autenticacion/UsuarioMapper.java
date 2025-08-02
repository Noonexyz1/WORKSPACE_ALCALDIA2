package com.sicopi.infrastructure.persistence.db.map.autenticacion;

import com.sicopi.domain.model.autenticacion.Usuario;
import com.sicopi.infrastructure.persistence.db.entity.autenticacion.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioEntity toUsuarioEntity(Usuario usuario);
    Usuario toUsuario(UsuarioEntity usuarioEntity);
}
