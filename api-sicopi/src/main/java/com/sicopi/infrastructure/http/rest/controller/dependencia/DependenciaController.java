package com.sicopi.infrastructure.http.rest.controller.dependencia;

import com.sicopi.application.port.in.dependencia.DependenciaService;
import com.sicopi.domain.model.dependencia.Dependencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/dependencia")
public class DependenciaController {

    @Autowired
    private DependenciaService dependenciaService;


    @PostMapping("/registrarDependencia")
    public Dependencia registrarDependencia(@RequestBody Dependencia dependencia) {
        return this.dependenciaService.registrarDependencia(dependencia);
    }

    @GetMapping("/listaDeDependencias")
    public Page<Dependencia> listaDeDependencias(Pageable pageable) {
        return this.dependenciaService.listaDeDependencias(pageable);
    }

    /*@PutMapping("/editarDependencia/{idDependencia}")
    public Dependencia editarDependencia(@PathVariable Long idDependencia, @RequestBody Dependencia dependencia) {
        return this.dependenciaService.editarDependencia(idDependencia, dependencia);
    }*/

    /*public void deshabilitarDependencia() {

    }*/
}
