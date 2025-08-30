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

import java.util.Optional;

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

        //Registramos persona
        Persona personaSaved = registrarPersona(persona);

        //Registramos formacion
        registrarFormacion(formacion, personaSaved);

        //Registramos funcionario
        Funcionario funcionarioSaved = registrarFuncionario(personaSaved);

        //Registramos el cargo
        Cargo cargoSaved = registrarCargo(cargo);

        //Registramos funcionario-cargo
        registrarFuncionarioCargo(funcionarioSaved, cargoSaved);

        //Registramos dependencia
        Dependencia dependenciaSaved = registrarDependencia(dependencia);

        //Registramos funcionario-dependencia
        registrarFuncionarioDependencia(funcionarioSaved, dependenciaSaved);
    }

    private void registrarFuncionarioDependencia(Funcionario funcionarioSaved, Dependencia dependenciaSaved) {
        FuncDependencia funcDependencia = FuncDependencia.builder()
                .funcionario(funcionarioSaved)
                .dependencia(dependenciaSaved)
                .build();
        this.funcDependenciaAbs.registrarFuncionarioDependenciaAbs(funcDependencia);
    }

    private Dependencia registrarDependencia(Dependencia dependencia) {
        if (dependencia.getId() != null) {
            Optional<Dependencia> dependenciaFinded = this.dependenciaAbs.getDependenciaById(dependencia.getId());
            if (dependenciaFinded.isEmpty()) {
                throw new RuntimeException("No existe esta dependencia con este id");
            }
            dependencia.setId(dependenciaFinded.get().getId());
        }
        Dependencia dependenciaSaved = this.dependenciaAbs.registrarDependenciaAbs(dependencia);
        return dependenciaSaved;
    }

    private void registrarFuncionarioCargo(Funcionario funcionarioSaved, Cargo cargoSaved) {
        FuncCargo funcCargoToSave = FuncCargo.builder()
                .funcionario(funcionarioSaved).cargo(cargoSaved).build();
        this.funcCargoAbs.registrarFuncionarioCargoAbs(funcCargoToSave);
    }

    private Cargo registrarCargo(Cargo cargo) {
        if (cargo.getId() != null) {
            Optional<Cargo> cargoFinded = this.cargoAbs.getCargoById(cargo.getId());
            if (cargoFinded.isEmpty()){
                throw new RuntimeException("No existe este Cargo con este id");
            }
            cargo.setId(cargoFinded.get().getId());
        }
        Cargo cargoSaved = this.cargoAbs.registrarCargoAbs(cargo);
        return cargoSaved;
    }

    private Funcionario registrarFuncionario(Persona personaSaved) {
        Funcionario funcionarioToSaved = Funcionario.builder()
                .persona(personaSaved).build();
        Funcionario funcionarioSaved = this.funcionarioAbs
                .registrarFuncionarioAbs(funcionarioToSaved);
        return funcionarioSaved;
    }

    private void registrarFormacion(Formacion formacion, Persona personaSaved) {
        if (formacion.getId() != null) {
            Optional<Formacion> formacionFinded = this.formacionAbs
                    .findFormacionById(formacion.getId());
            if (formacionFinded.isEmpty()) {
                throw new RuntimeException("No existe este id de formacion");
            }
            formacion.setId(formacionFinded.get().getId());
        }
        formacion.setPersona(personaSaved);
        this.formacionAbs.registrarFormacionAbs(formacion);
    }

    private Persona registrarPersona(Persona persona) {
        if (persona.getCi() == null || persona.getCi().isEmpty()) {
            throw new RuntimeException("Ci de persona invalido");
        }
        Optional<Persona> personaFinded = this.personaAbs
                .findPersonaPorCi(persona.getCi());
        if (personaFinded.isPresent()) {
            throw new RuntimeException("Esta persona con este ci ya existe, no debe existir mas de dos personas con el mismo CI");
        }
        return this.personaAbs.registrarPersonaAbs(persona);
    }
}
