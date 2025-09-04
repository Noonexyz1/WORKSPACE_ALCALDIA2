package com.sicopi.application.port.in.usuario;

import com.sicopi.domain.model.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UsuarioService {
    //Casos de uso, segun historias de usuario CREAR ROLES, EDITARLOS, PERMISOS
    Usuario registrarUsuario(Usuario usuario);
    void deshabilitarUsuario(Long idUsuario); //Esto es a nivel de sistema, no podra iniciar sesion
    Page<Usuario> listaDeUsuarios(Pageable pageable);
    void habilitarUsuario(Long idUsuario);
    Optional<Usuario> encontrarUsuarioPorId(Long idUsuario);
}
