package com.sicopi.application.port.out.persistence.autenticacion;

import com.sicopi.domain.model.autenticacion.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UsuarioAbs {
    //Casos de uso, segun historias de usuario CREAR ROLES, EDITARLOS, PERMISOS
    Usuario registrarUsuarioAbs(Usuario usuario);
    //void editarUsuario();
    Page<Usuario> listaDeUsuariosAbs(Pageable pageable);
    Optional<Usuario> encontrarUsuarioPorId(Long idUsuario);
}
