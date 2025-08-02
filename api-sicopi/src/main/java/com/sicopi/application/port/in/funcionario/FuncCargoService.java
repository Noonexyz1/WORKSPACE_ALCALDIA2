package com.sicopi.application.port.in.funcionario;

import com.sicopi.domain.model.funcionario.FuncCargo;

public interface FuncCargoService {
    FuncCargo registrarFuncionarioCargo(FuncCargo funcCargo);
    void deshabilitarFuncionarioCargo();
}
