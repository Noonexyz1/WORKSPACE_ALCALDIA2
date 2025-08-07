package com.sicopi.infrastructure.persistence.db.adapter.autenticacion;

import com.sicopi.application.port.out.persistence.autenticacion.UsuarioAbs;
import com.sicopi.domain.model.autenticacion.Usuario;
import com.sicopi.infrastructure.persistence.db.entity.autenticacion.UsuarioEntity;
import com.sicopi.infrastructure.persistence.db.entity.persona.PersonaEntity;
import com.sicopi.infrastructure.persistence.db.map.autenticacion.UsuarioMapper;
import com.sicopi.infrastructure.persistence.db.repository.autenticacion.UsuarioRepository;
import com.sicopi.infrastructure.persistence.db.repository.persona.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAbsAdapter implements UsuarioAbs {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public Usuario registrarUsuarioAbs(Usuario usuario) {
        if (usuario.getId() != null) {
            throw new RuntimeException("Para registrar usuario el id debe ser null");
        }

        if (usuario.getPersona() == null) {
            throw new RuntimeException("La persona debe existir para registrar un usuario");
        }

        if (usuario.getPersona().getId() == null) {
            throw new RuntimeException("El id de la persona no debe ser null");
        }

        PersonaEntity personaEntity = this.personaRepository
                .findById(usuario.getPersona().getId()).orElse(null);

        if (personaEntity == null) {
            throw new RuntimeException("Esta persona con este id no existe");
        }

        UsuarioEntity usuarioEntity = UsuarioMapper.INSTANCE.toUsuarioEntity(usuario);
        usuarioEntity.setPersona(personaEntity);
        this.usuarioRepository.save(usuarioEntity);
        return UsuarioMapper.INSTANCE.toUsuario(usuarioEntity);
    }

    @Override
    public void deshabilitarUsuarioAbs() {

    }

    @Override
    public Page<Usuario> listaDeUsuariosAbs(Pageable pageable) {
        Page<UsuarioEntity> usuarioRepositoryAll = this.usuarioRepository.findAll(pageable);
        return usuarioRepositoryAll.map(UsuarioMapper.INSTANCE::toUsuario);
    }

    @Override
    public Usuario encontrarUsuarioPorUsername(String username) {
        UsuarioEntity byUsername = this.usuarioRepository.findByUsername(username);
        return UsuarioMapper.INSTANCE.toUsuario(byUsername);
    }
}
