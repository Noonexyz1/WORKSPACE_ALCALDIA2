package com.sicopi.infrastructure.http.rest.controller.funcionario;

import com.sicopi.application.port.in.funcionario.FuncDependenciaService;
import com.sicopi.domain.model.funcionario.FuncDependencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.1/funcDependencia")
public class FuncDependenciaController {

    @Autowired
    private FuncDependenciaService funcDependenciaService;


    @PostMapping("/registrarFuncionarioDependencia")
    public FuncDependencia registrarFuncionarioDependencia(@RequestBody FuncDependencia funcDependencia) {
        return this.funcDependenciaService.registrarFuncionarioDependencia(funcDependencia);
    }

    /*public void deshabilitarFuncionarioDependencia() {

    }*/
}
