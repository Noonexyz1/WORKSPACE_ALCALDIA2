package com.sicopi.infrastructure.http.rest.controller.funcionario;

import com.sicopi.application.port.in.funcionario.FuncCargoService;
import com.sicopi.domain.model.funcionario.FuncCargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/funcCargo")
public class FuncCargoController {

    @Autowired
    private FuncCargoService funcCargoService;


    @PostMapping("/registrarFuncionarioCargo")
    public FuncCargo registrarFuncionarioCargo(@RequestBody FuncCargo funcCargo) {
        return this.funcCargoService.registrarFuncionarioCargo(funcCargo);
    }

    /*public void deshabilitarFuncionarioCargo() {

    }*/
}
