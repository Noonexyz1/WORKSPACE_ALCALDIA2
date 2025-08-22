package com.sicopi.infrastructure.http.rest.controller.funcionario;

import com.sicopi.application.port.in.funcionario.FuncionarioService;
import com.sicopi.domain.model.funcionario.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;


    @PostMapping("/registrarFuncionario")
    public Funcionario registrarFuncionario(@RequestBody Funcionario funcionario) {
        return this.funcionarioService.registrarFuncionario(funcionario);
    }

    @PutMapping("/deshabilitarFuncionario/{idFuncionario}")
    public void deshabilitarFuncionario(@PathVariable Long idFuncionario) {
        this.funcionarioService.deshabilitarFuncionario(idFuncionario);
    }

    @PutMapping("/habilitarFuncionario/{idFuncionario}")
    public void habilitarFuncionario(@PathVariable Long idFuncionario) {
        this.funcionarioService.habilitarFuncionario(idFuncionario);
    }

    @GetMapping("/listaDeFuncionario")
    public Page<Funcionario> listaDeFuncionario(Pageable pageable) {
        return this.funcionarioService.listaDeFuncionarios(pageable);
    }
}
