package com.sicopi.infrastructure.http.rest.controller.persona;

import com.sicopi.application.port.in.persona.FormacionService;
import com.sicopi.domain.model.persona.Formacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/formacion")
public class FormacionController {

    @Autowired
    private FormacionService formacionService;


    @PostMapping("/registrarFormacion")
    public Formacion registrarFormacion(@RequestBody Formacion formacion) {
        return this.formacionService.registrarFormacion(formacion);
    }

    /*@PutMapping("/editarFormacion/{idFormacion}")
    public Formacion editarFormacion(@PathVariable Long idFormacion, @RequestBody Formacion formacion) {
        return this.formacionService.editarFormacion(idFormacion, formacion);
    }*/

    @GetMapping("/listaFormaciones")
    public Page<Formacion> listaDeFormaciones(Pageable pageable) {
        return this.formacionService.listaDeFormaciones(pageable);
    }
}
