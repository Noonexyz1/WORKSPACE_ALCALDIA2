package com.sicopi.infrastructure.http.rest.controller.funcionario;

import com.sicopi.application.port.in.funcionario.FuncDependenciaService;
import com.sicopi.domain.model.funcionario.FuncDependencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/funcDependencia")
public class FuncDependenciaController {

    @Autowired
    private FuncDependenciaService funcDependenciaService;


    @PostMapping("/registrarFuncionarioDependencia")
    public FuncDependencia registrarFuncionarioDependencia(@RequestBody FuncDependencia funcDependencia) {
        return this.funcDependenciaService.registrarFuncionarioDependencia(funcDependencia);
    }

    @PutMapping("/deshabilitarFuncionarioDependencia/{idFuncDep}")
    public void deshabilitarFuncionarioDependencia(@PathVariable Long idFuncDep) {
        this.funcDependenciaService.deshabilitarFuncionarioDependencia(idFuncDep);
    }

    @GetMapping("/listaDeFuncDependencia")
    public Page<FuncDependencia> listaDeFuncDependencia(Pageable pageable) {
        return this.funcDependenciaService.listaDeFuncDependencia(pageable);
    }
}
