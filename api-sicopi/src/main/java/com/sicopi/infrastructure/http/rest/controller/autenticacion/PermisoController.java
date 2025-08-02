package com.sicopi.infrastructure.http.rest.controller.autenticacion;

import com.sicopi.application.port.in.autenticacion.PermisoService;
import com.sicopi.domain.model.autenticacion.Permiso;
import com.sicopi.domain.model.persona.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/permiso")
public class PermisoController {

    @Autowired
    private PermisoService permisoService;


    @GetMapping("/listaDePermisos")
    public Page<Permiso> listaDePermisos(Pageable pageable) {
        return this.permisoService.listaDePermisos(pageable);
    }

    @PostMapping("/registarPermiso")
    public Permiso registarPermiso(@RequestBody Permiso permiso) {
        return this.permisoService.registarPermiso(permiso);
    }

    /*@PutMapping("/editarPermiso/{idPermiso}")
    public Permiso editarPermiso(@PathVariable Long idPermiso, @RequestBody Permiso permiso) {
        return null;
    }*/

    /*public void deshabilitarPermiso() {

    }*/
}
