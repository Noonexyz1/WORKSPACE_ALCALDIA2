package com.sicopi.application.port.out.persistence.funcionario;

import com.sicopi.domain.model.funcionario.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface FuncionarioAbs {
    //Casos de uso, segun historias de usuario CREAR FUNCIONARIO,
    Funcionario registrarFuncionarioAbs(Funcionario funcionario);
    Optional<Funcionario> encontrarFuncionarioById(Long idFuncionario);
    Page<Funcionario> listaDeFuncionarios(Pageable pageable);
    //Casos de uso, segun historias de usuario ELIMINAR FUNCIONARIO,
    //No puedes volver a activarlo, para eso, necestiar crear toddo un registro de NUEVO FUNCIONARIO
}
