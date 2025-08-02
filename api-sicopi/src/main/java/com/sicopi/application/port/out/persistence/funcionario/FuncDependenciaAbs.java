package com.sicopi.application.port.out.persistence.funcionario;

import com.sicopi.domain.model.funcionario.FuncDependencia;

public interface FuncDependenciaAbs {
    FuncDependencia registrarFuncionarioDependenciaAbs(FuncDependencia funcDependencia);
    void deshabilitarFuncionarioDependenciaAbs();
}
