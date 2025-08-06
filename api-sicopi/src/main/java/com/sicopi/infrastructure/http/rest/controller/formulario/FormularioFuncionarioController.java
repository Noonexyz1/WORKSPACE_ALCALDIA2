package com.sicopi.infrastructure.http.rest.controller.formulario;

import com.sicopi.application.port.in.formulario.FormularioFuncionarioService;
import com.sicopi.infrastructure.http.rest.dto.FuncionarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.1/formularioFuncionario")
public class FormularioFuncionarioController {

    @Autowired
    private FormularioFuncionarioService formularioFuncionarioService;

    @Transactional
    @PostMapping("/registrarFormularioFuncionario")
    public void registrarFormularioFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        this.formularioFuncionarioService.registrarFormularioFuncionario(
                funcionarioDTO.getPersona(),
                funcionarioDTO.getFormacion(),
                funcionarioDTO.getCargo(),
                funcionarioDTO.getDependencia()
        );
    }

}
