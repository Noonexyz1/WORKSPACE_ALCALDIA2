package com.sicopi.infrastructure.http.rest.controller.usuario;

import com.sicopi.application.port.in.usuario.UsuarioRolService;
import com.sicopi.domain.model.usuario.UsuarioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/usuarioRol")
public class UsuarioRolController {

    @Autowired
    private UsuarioRolService usuarioRolService;


    @PostMapping("/registrarUsuarioRol")
    public UsuarioRol registrarUsuarioRol(@RequestBody UsuarioRol usuarioRol) {
        return this.usuarioRolService.registrarUsuarioRol(usuarioRol);
    }

    @GetMapping("/listaDeUsuarioRol")
    public Page<UsuarioRol> listaDeUsuarioRol(Pageable pageable) {
        return this.usuarioRolService.listaDeUsuarioRol(pageable);
    }

    @PutMapping("/deshabilitarUsuarioRol/{idUsuarioRol}")
    public void deshabilitarUsuarioRol(@PathVariable Long idUsuarioRol) {
        this.usuarioRolService.deshabilitarUsuarioRol(idUsuarioRol);
    }

    @PutMapping("/habilitarUsuarioRol/{idUsuarioRol}")
    public void habilitarUsuarioRol(@PathVariable Long idUsuarioRol) {
        this.usuarioRolService.habilitarUsuarioRol(idUsuarioRol);
    }
}
