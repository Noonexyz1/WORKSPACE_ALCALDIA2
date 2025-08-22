package com.sicopi.infrastructure.http.rest.controller.dependencia;

import com.sicopi.application.port.in.dependencia.CuotaService;
import com.sicopi.domain.model.dependencia.Cuota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @PutMapping("/editarCuota/{idCuota}")
    public Cuota editarCuota(
            @PathVariable Long idCuota,
            @RequestBody Cuota cuota) {

        return this.cuotaService.editarCuota(idCuota, cuota);
    }

    @GetMapping("/listarCuotas")
    public Page<Cuota> listarCuotas(Pageable pageable) {
        return this.cuotaService.listaDeCuotas(pageable);
    }

    //Solo debe existir la parte de deshabilitar y NO lo da habilitar porque
    //se desea que se cree un nuevo registro por cada asignacion de cuota a una dependencia
    @PutMapping("/deshabilitarCuota/{idCuota}")
    public void deshabilitarCuota(@PathVariable Long idCuota) {
        this.cuotaService.deshabilitarCuota(idCuota);
    }
}
