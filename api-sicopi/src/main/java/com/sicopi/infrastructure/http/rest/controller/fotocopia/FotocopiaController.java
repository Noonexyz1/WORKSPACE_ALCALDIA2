package com.sicopi.infrastructure.http.rest.controller.fotocopia;

import com.sicopi.application.port.in.fotocopia.FotocopiaService;
import com.sicopi.domain.model.fotocopia.Fotocopia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/fotocopia")
public class FotocopiaController {

    @Autowired
    private FotocopiaService fotocopiaService;

    @PostMapping("/registrarFotocopia")
    public Fotocopia registrarFotocopia(@RequestBody Fotocopia fotocopia) {
        return this.fotocopiaService.registrarFotocopia(fotocopia);
    }

    @GetMapping("/listaDeFotocopias")
    public Page<Fotocopia> listaDeFotocopias(Pageable pageable) {
        return this.fotocopiaService.listaDeFotocopias(pageable);
    }

    @PutMapping("/autorizarFotocopia/{idFotocopia}")
    public void autorizarFotocopia(@PathVariable Long idFotocopia) {
        this.fotocopiaService.autorizarFotocopia(idFotocopia);
    }
}
