package com.sicopi.infrastructure.http.rest.controller.funcionario;

import com.sicopi.application.port.in.funcionario.FuncionarioService;
import com.sicopi.domain.model.funcionario.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.1/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;


    @PostMapping("/registrarFuncionario")
    public Funcionario registrarFuncionario(@RequestBody Funcionario funcionario) {
        return this.funcionarioService.registrarFuncionario(funcionario);
    }
}
