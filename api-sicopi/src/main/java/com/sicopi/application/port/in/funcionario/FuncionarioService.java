package com.sicopi.application.port.in.funcionario;

import com.sicopi.domain.model.funcionario.Funcionario;

public interface FuncionarioService {
    //Casos de uso, segun historias de usuario CREAR FUNCIONARIO,
    Funcionario registrarFuncionario(Funcionario funcionario);

    //Casos de uso, segun historias de usuario ELIMINAR FUNCIONARIO,
    //No puedes volver a activarlo, para eso, necestiar crear toddo un registro de NUEVO FUNCIONARIO
    //void activarFuncionario();
    //void deshabilitarFuncionario();
}
