package com.sicopi.infrastructure.http.rest.controller.persona;

import com.sicopi.application.port.in.persona.PersonaService;
import com.sicopi.domain.model.persona.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;


    @PostMapping("/registrarPersona")
    public Persona registrarPersona(@RequestBody Persona persona) {
        return this.personaService.registrarPersona(persona);
    }

    /*@PutMapping("/editarPersona/{idPersona}")
    public Persona editarPersona(@PathVariable Long idPersona, @RequestBody Persona persona) {
        return this.personaService.editarPersona(idPersona, persona);
    }*/
}
