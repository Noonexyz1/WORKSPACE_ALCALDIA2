package com.sicopi.infrastructure.persistence.db.adapter.usuario;

import com.sicopi.application.port.out.persistence.usuario.UsuarioRolAbs;
import com.sicopi.domain.model.usuario.UsuarioRol;
import com.sicopi.infrastructure.persistence.db.entity.usuario.UsuarioRolEntity;
import com.sicopi.infrastructure.persistence.db.map.usuario.UsuarioRolMapper;
import com.sicopi.infrastructure.persistence.db.repository.usuario.RolRepository;
import com.sicopi.infrastructure.persistence.db.repository.usuario.UsuarioRepository;
import com.sicopi.infrastructure.persistence.db.repository.usuario.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
        /*if (usuarioRol.getId() != null) {
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
        }*/

        UsuarioRolEntity usuarioRolEntity = UsuarioRolMapper.INSTANCE.toUsuarioRolEntity(usuarioRol);
        this.usuarioRolRepository.save(usuarioRolEntity);
        return UsuarioRolMapper.INSTANCE.toUsuarioRol(usuarioRolEntity);
    }

    @Override
    public Page<UsuarioRol> listaDeUsuarioRolAbs(Pageable pageable) {
        Page<UsuarioRolEntity> usuarioRolAll = this.usuarioRolRepository
                .findAll(pageable);
        return usuarioRolAll.map(UsuarioRolMapper.INSTANCE::toUsuarioRol);
    }

    @Override
    public Optional<UsuarioRol> encontrarUsuRolPorId(Long idUsuarioRol) {
        Optional<UsuarioRolEntity> byId = this.usuarioRolRepository.findById(idUsuarioRol);
        return byId.map(UsuarioRolMapper.INSTANCE::toUsuarioRol);
    }
}
