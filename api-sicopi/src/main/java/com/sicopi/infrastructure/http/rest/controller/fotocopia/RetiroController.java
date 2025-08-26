package com.sicopi.infrastructure.http.rest.controller.fotocopia;

import com.sicopi.application.port.in.fotocopia.RetiroService;
import com.sicopi.domain.model.fotocopia.Retiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/retiro")
public class RetiroController {

    @Autowired
    private RetiroService retiroService;

    @PostMapping("/registrarRetiro")
    public Retiro registrarRetiro(@RequestBody Retiro retiro) {
        return this.retiroService.registrarRetiro(retiro);
    }

    @PutMapping("/editarRetiro/{idRetiro}")
    public Retiro editarRetiro(@PathVariable Long idRetiro, @RequestBody Retiro retiro) {
        return this.retiroService.editarRetiro(idRetiro, retiro);
    }

    @GetMapping("/listaDeRetiros")
    public Page<Retiro> listaDeRetiros(Pageable pageable) {
        return this.retiroService.listaDeRetiros(pageable);
    }

    @GetMapping("/buscarRetiro/{idRetiro}")
    public Retiro buscarRetiro(@PathVariable Long idRetiro) {
        return this.retiroService.buscarRetiro(idRetiro).get();
    }
}
