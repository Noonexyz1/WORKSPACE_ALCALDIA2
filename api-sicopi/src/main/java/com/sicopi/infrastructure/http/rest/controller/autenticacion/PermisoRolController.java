package com.sicopi.infrastructure.http.rest.controller.autenticacion;

import com.sicopi.application.port.in.autenticacion.PermisoRolService;
import com.sicopi.domain.model.autenticacion.PermisoRol;
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
}
