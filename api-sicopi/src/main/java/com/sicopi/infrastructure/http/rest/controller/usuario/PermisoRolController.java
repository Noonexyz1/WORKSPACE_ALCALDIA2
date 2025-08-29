package com.sicopi.infrastructure.http.rest.controller.usuario;

import com.sicopi.application.port.in.usuario.PermisoRolService;
import com.sicopi.domain.model.usuario.PermisoRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/permisoRol")
public class PermisoRolController {

    @Autowired
    private PermisoRolService permisoRolService;


    @PostMapping("/registrarPermisoRol")
    public PermisoRol registrarPermisoRol(@RequestBody PermisoRol permisoRol) {
        return this.permisoRolService.registrarPermisoRol(permisoRol);
    }

    @GetMapping("/listaDePermisoRol")
    public Page<PermisoRol> listaDePermisoRol(Pageable pageable) {
        return this.permisoRolService.listaDePermisoRol(pageable);
    }

    @PutMapping("/deshabilitarPermisoRol/{idPermisoRol}")
    public void deshabilitarPermisoRol(@PathVariable Long idPermisoRol) {
        this.permisoRolService.deshabilitarPermisoRol(idPermisoRol);
    }

    @PutMapping("/habilitarPermisoRol/{idPermisoRol}")
    public void habilitarPermisoRol(@PathVariable Long idPermisoRol) {
        this.permisoRolService.habilitarPermisoRol(idPermisoRol);
    }
}
