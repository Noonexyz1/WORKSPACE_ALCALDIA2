package com.sicopi.infrastructure.http.rest.controller.usuario;

import com.sicopi.application.port.in.usuario.UsuarioService;
import com.sicopi.domain.model.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/registrarUsuario")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return this.usuarioService.registrarUsuario(usuario);
    }

    @GetMapping("/listaDeUsuario")
    public Page<Usuario> listaDeUsuario(Pageable pageable) {
        return this.usuarioService.listaDeUsuarios(pageable);
    }

    //Antes de hacer un registro en la base de datos, pues debo
    //evaluar si este registro es activo true, para hacer la persistencia
    //si no pues no, no pasa nada pero ese es la condicio, en una relacion de dos entidades
    @PutMapping("/deshabilitarUsuario/{idUsuario}")
    public void deshabilitarUsuario(@PathVariable Long idUsuario) {
        this.usuarioService.deshabilitarUsuario(idUsuario);
    }

    @PutMapping("/habilitarUsuario/{idUsuario}")
    public void habilitarUsuario(@PathVariable Long idUsuario) {
        this.usuarioService.habilitarUsuario(idUsuario);
    }
}
