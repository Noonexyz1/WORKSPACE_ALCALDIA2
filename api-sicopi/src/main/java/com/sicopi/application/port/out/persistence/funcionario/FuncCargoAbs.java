package com.sicopi.application.port.out.persistence.funcionario;

import com.sicopi.domain.model.funcionario.FuncCargo;

public interface FuncCargoAbs {
    FuncCargo registrarFuncionarioCargoAbs(FuncCargo funcCargo);
    void deshabilitarFuncionarioCargoAbs();
}
