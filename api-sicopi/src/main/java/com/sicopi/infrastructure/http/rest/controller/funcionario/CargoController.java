package com.sicopi.infrastructure.http.rest.controller.funcionario;

import com.sicopi.application.port.in.funcionario.CargoService;
import com.sicopi.domain.model.funcionario.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;


    @PostMapping("/registrarCargo")
    public Cargo registrarCargo(@RequestBody Cargo cargo) {
        return this.cargoService.registrarCargo(cargo);
    }

    @GetMapping("/listaDeCargos")
    public Page<Cargo> listaDeCargos(Pageable pageable) {
        return this.cargoService.listaDeCargos(pageable);
    }

    /*@PutMapping("/editarCargo/{idCargo}")
    public Cargo editarCargo(@PathVariable Long idCargo, @RequestBody Cargo cargo) {
        return this.cargoService.editarCargo(idCargo, cargo);
    }*/

    /*@PutMapping("/deshabilitarCargo/{idCargo}")
    public void deshabilitarCargo(@PathVariable Long idCargo) {
    }*/
}
