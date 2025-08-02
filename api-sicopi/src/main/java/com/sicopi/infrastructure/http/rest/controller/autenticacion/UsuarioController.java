package com.sicopi.infrastructure.http.rest.controller.autenticacion;

import com.sicopi.application.port.in.autenticacion.UsuarioService;
import com.sicopi.domain.model.autenticacion.Usuario;
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

    /*public void deshabilitarUsuario() {

    }*/
}
