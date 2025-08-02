package com.sicopi.application.port.in.funcionario;

import com.sicopi.domain.model.funcionario.FuncDependencia;

public interface FuncDependenciaService {
    FuncDependencia registrarFuncionarioDependencia(FuncDependencia funcDependencia);
    void deshabilitarFuncionarioDependencia();
}
