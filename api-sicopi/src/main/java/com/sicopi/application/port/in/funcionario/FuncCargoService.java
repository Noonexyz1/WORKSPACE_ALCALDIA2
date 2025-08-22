package com.sicopi.application.port.in.funcionario;

import com.sicopi.domain.model.funcionario.FuncCargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FuncCargoService {
    FuncCargo registrarFuncionarioCargo(FuncCargo funcCargo);
    void deshabilitarFuncionarioCargo(Long idFuncCargo);
    Page<FuncCargo> listaDeFuncCargo(Pageable pageable);
}
