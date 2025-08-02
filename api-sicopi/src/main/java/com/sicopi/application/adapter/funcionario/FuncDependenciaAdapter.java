package com.sicopi.application.adapter.funcionario;

import com.sicopi.application.port.in.funcionario.FuncDependenciaService;
import com.sicopi.application.port.out.persistence.funcionario.FuncDependenciaAbs;
import com.sicopi.domain.model.funcionario.FuncDependencia;

public class FuncDependenciaAdapter implements FuncDependenciaService {

    private final FuncDependenciaAbs funcDependenciaAbs;

    public FuncDependenciaAdapter(FuncDependenciaAbs funcDependenciaAbs) {
        this.funcDependenciaAbs = funcDependenciaAbs;
    }

    @Override
    public FuncDependencia registrarFuncionarioDependencia(FuncDependencia funcDependencia) {
        return this.funcDependenciaAbs.registrarFuncionarioDependenciaAbs(funcDependencia);
    }

    @Override
    public void deshabilitarFuncionarioDependencia() {

    }
}
