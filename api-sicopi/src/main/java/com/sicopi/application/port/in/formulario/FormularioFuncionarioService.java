package com.sicopi.application.port.in.formulario;

import com.sicopi.domain.model.dependencia.Dependencia;
import com.sicopi.domain.model.funcionario.Cargo;
import com.sicopi.domain.model.persona.Formacion;
import com.sicopi.domain.model.persona.Persona;

public interface FormularioFuncionarioService {
    void registrarFormularioFuncionario(
            Persona persona,
            Formacion formacion,
            Cargo cargo,
            Dependencia dependencia);
}
