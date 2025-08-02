package com.sicopi.application.adapter.funcionario;

import com.sicopi.application.port.in.funcionario.FuncionarioService;
import com.sicopi.application.port.out.persistence.funcionario.FuncionarioAbs;
import com.sicopi.domain.model.funcionario.Funcionario;

public class FuncionarioAdapter implements FuncionarioService {

    private final FuncionarioAbs funcionarioAbs;

    public FuncionarioAdapter(FuncionarioAbs funcionarioAbs) {
        this.funcionarioAbs = funcionarioAbs;
    }

    @Override
    public Funcionario registrarFuncionario(Funcionario funcionario) {
        return this.funcionarioAbs.registrarFuncionarioAbs(funcionario);
    }
}
