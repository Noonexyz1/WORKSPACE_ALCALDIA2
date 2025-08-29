package com.sicopi.application.port.in.funcionario;

import com.sicopi.domain.model.funcionario.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FuncionarioService {
    //Casos de uso, segun historias de usuario CREAR FUNCIONARIO,
    Funcionario registrarFuncionario(Funcionario funcionario);
    void deshabilitarFuncionario(Long idFuncionario);
    void habilitarFuncionario(Long idFuncionario);
    Page<Funcionario> listaDeFuncionarios(Pageable pageable);
    //Casos de uso, segun historias de usuario ELIMINAR FUNCIONARIO,
    //No puedes volver a activarlo, para eso, necestiar crear toddo un registro de NUEVO FUNCIONARIO
}
