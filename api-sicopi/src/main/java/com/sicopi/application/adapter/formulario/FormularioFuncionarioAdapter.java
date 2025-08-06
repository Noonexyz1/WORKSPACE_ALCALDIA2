package com.sicopi.application.adapter.formulario;

import com.sicopi.application.port.in.formulario.FormularioFuncionarioService;
import com.sicopi.application.port.out.persistence.dependencia.DependenciaAbs;
import com.sicopi.application.port.out.persistence.funcionario.CargoAbs;
import com.sicopi.application.port.out.persistence.funcionario.FuncCargoAbs;
import com.sicopi.application.port.out.persistence.funcionario.FuncDependenciaAbs;
import com.sicopi.application.port.out.persistence.funcionario.FuncionarioAbs;
import com.sicopi.application.port.out.persistence.persona.FormacionAbs;
import com.sicopi.application.port.out.persistence.persona.PersonaAbs;
import com.sicopi.domain.model.dependencia.Dependencia;
import com.sicopi.domain.model.funcionario.Cargo;
import com.sicopi.domain.model.funcionario.FuncCargo;
import com.sicopi.domain.model.funcionario.FuncDependencia;
import com.sicopi.domain.model.funcionario.Funcionario;
import com.sicopi.domain.model.persona.Formacion;
import com.sicopi.domain.model.persona.Persona;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Lombok genera un constructor con las variables 'final'
public class FormularioFuncionarioAdapter implements FormularioFuncionarioService {

    private final PersonaAbs personaAbs;
    private final FormacionAbs formacionAbs;
    private final CargoAbs cargoAbs;
    private final DependenciaAbs dependenciaAbs;
    private final FuncionarioAbs funcionarioAbs;
    private final FuncCargoAbs funcCargoAbs;
    private final FuncDependenciaAbs funcDependenciaAbs;

    @Override
    public void registrarFormularioFuncionario(
            Persona persona,
            Formacion formacion,
            Cargo cargo,
            Dependencia dependencia) {

        Persona personaSaved = this.personaAbs.registrarPersonaAbs(persona);
        formacion.setPersona(personaSaved);
        this.formacionAbs.registrarFormacionAbs(formacion);

        Funcionario funcionarioToSaved = Funcionario.builder().persona(personaSaved).build();
        Funcionario funcionarioSaved = this.funcionarioAbs.registrarFuncionarioAbs(funcionarioToSaved);

        Cargo cargoSaved = this.cargoAbs.registrarCargoAbs(cargo);
        FuncCargo funcCargoToSave = FuncCargo.builder()
                .funcionario(funcionarioSaved)
                .cargo(cargoSaved)
                .build();
        this.funcCargoAbs.registrarFuncionarioCargoAbs(funcCargoToSave);

        FuncDependencia funcDependencia = FuncDependencia.builder()
                .funcionario(funcionarioSaved)
                .dependencia(dependencia)
                .build();
        this.funcDependenciaAbs.registrarFuncionarioDependenciaAbs(funcDependencia);
    }
}
