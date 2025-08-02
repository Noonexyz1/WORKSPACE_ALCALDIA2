package com.sicopi.infrastructure.http.rest.controller.fotocopia;

import com.sicopi.application.port.in.fotocopia.FotocopiaService;
import com.sicopi.domain.model.fotocopia.Fotocopia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.1/fotocopia")
public class FotocopiaController {

    @Autowired
    private FotocopiaService fotocopiaService;

    @PostMapping("/registrarFotocopia")
    public Fotocopia registrarFotocopia(@RequestBody Fotocopia fotocopia) {
        return this.fotocopiaService.registrarFotocopia(fotocopia);
    }
}
