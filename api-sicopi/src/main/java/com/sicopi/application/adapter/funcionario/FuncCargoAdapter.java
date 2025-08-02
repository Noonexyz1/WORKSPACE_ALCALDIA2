package com.sicopi.application.adapter.funcionario;

import com.sicopi.application.port.in.funcionario.FuncCargoService;
import com.sicopi.application.port.out.persistence.funcionario.FuncCargoAbs;
import com.sicopi.domain.model.funcionario.FuncCargo;

public class FuncCargoAdapter implements FuncCargoService {

    private final FuncCargoAbs funcCargoAbs;

    public FuncCargoAdapter(FuncCargoAbs funcCargoAbs) {
        this.funcCargoAbs = funcCargoAbs;
    }

    @Override
    public FuncCargo registrarFuncionarioCargo(FuncCargo funcCargo) {
        return this.funcCargoAbs.registrarFuncionarioCargoAbs(funcCargo);
    }

    @Override
    public void deshabilitarFuncionarioCargo() {

    }
}
