package com.sicopi.infrastructure.http.rest.controller.dependencia;

import com.sicopi.application.port.in.dependencia.CuotaService;
import com.sicopi.domain.model.dependencia.Cuota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/cuota")
public class CuotaController {

    @Autowired
    private CuotaService cuotaService;


    @PostMapping("/registrarCuota")
    public Cuota registrarCuota(@RequestBody Cuota cuota) {
        return this.cuotaService.registrarCuota(cuota);
    }

    /*@PutMapping("/editarCuota/{idCuota}")
    public Cuota editarCuota(@PathVariable Long idCuota, @RequestBody Cuota cuota) {
        return this.cuotaService.editarCuota(idCuota, cuota);
    }*/

    /*public void deshabilitarCuota() {

    }*/
}
