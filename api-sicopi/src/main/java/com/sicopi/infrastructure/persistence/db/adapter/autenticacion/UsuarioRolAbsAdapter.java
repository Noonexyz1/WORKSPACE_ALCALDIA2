package com.sicopi.infrastructure.persistence.db.adapter.autenticacion;

import com.sicopi.application.port.out.persistence.autenticacion.UsuarioRolAbs;
import com.sicopi.domain.model.autenticacion.UsuarioRol;
import com.sicopi.infrastructure.persistence.db.entity.autenticacion.RolEntity;
import com.sicopi.infrastructure.persistence.db.entity.autenticacion.UsuarioEntity;
import com.sicopi.infrastructure.persistence.db.entity.autenticacion.UsuarioRolEntity;
import com.sicopi.infrastructure.persistence.db.map.autenticacion.UsuarioRolMapper;
import com.sicopi.infrastructure.persistence.db.repository.autenticacion.RolRepository;
import com.sicopi.infrastructure.persistence.db.repository.autenticacion.UsuarioRepository;
import com.sicopi.infrastructure.persistence.db.repository.autenticacion.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioRolAbsAdapter implements UsuarioRolAbs {

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rolRepository;


    @Override
    public UsuarioRol registrarUsuarioRolAbs(UsuarioRol usuarioRol) {
        if (usuarioRol.getId() != null) {
            throw new RuntimeException("El id de usuario-rol debe ser nullo para registrar");
        }

        if (usuarioRol.getUsuario() == null &&
                usuarioRol.getRol() == null) {
            throw new RuntimeException("usuario-rol debe tener un usuario y rol valido");
        }

        if (usuarioRol.getUsuario().getId() == null &&
                usuarioRol.getRol().getId() == null) {
            throw new RuntimeException("usuario-rol debe tener ids de usuario y rol validos");
        }

        UsuarioEntity usuarioEntity = this.usuarioRepository
                .findById(usuarioRol.getUsuario().getId()).orElse(null);

        RolEntity rolEntity = this.rolRepository
                .findById(usuarioRol.getRol().getId()).orElse(null);

        if (usuarioEntity == null && rolEntity == null) {
            throw new RuntimeException("Usuario y Rol no encontrados");
        }

        UsuarioRolEntity usuarioRolEntity = UsuarioRolMapper.INSTANCE.toUsuarioRolEntity(usuarioRol);
        usuarioRolEntity.setUsuario(usuarioEntity);
        usuarioRolEntity.setRol(rolEntity);
        this.usuarioRolRepository.save(usuarioRolEntity);
        return UsuarioRolMapper.INSTANCE.toUsuarioRol(usuarioRolEntity);
    }

    @Override
    public void deshabilitarUsuarioRolAbs() {

    }
}
