package com.sicopi.application.port.out.persistence.funcionario;

import com.sicopi.domain.model.funcionario.Funcionario;

public interface FuncionarioAbs {
    //Casos de uso, segun historias de usuario CREAR FUNCIONARIO,
    Funcionario registrarFuncionarioAbs(Funcionario funcionario);

    //Casos de uso, segun historias de usuario ELIMINAR FUNCIONARIO,
    //No puedes volver a activarlo, para eso, necestiar crear toddo un registro de NUEVO FUNCIONARIO
    //void activarFuncionario();
    //void deshabilitarFuncionario();
}
