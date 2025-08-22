package com.sicopi.application.port.out.persistence.funcionario;

import com.sicopi.domain.model.funcionario.FuncCargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface FuncCargoAbs {
    FuncCargo registrarFuncionarioCargoAbs(FuncCargo funcCargo);
    void deshabilitarFuncionarioCargoAbs();
    Optional<FuncCargo> encontrarFunCargoPorId(Long idFuncCargo);
    Page<FuncCargo> listaDeFuncCargo(Pageable pageable);
}
