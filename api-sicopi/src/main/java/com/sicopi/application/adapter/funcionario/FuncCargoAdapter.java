package com.sicopi.application.adapter.funcionario;

import com.sicopi.application.port.in.funcionario.FuncCargoService;
import com.sicopi.application.port.out.persistence.funcionario.FuncCargoAbs;
import com.sicopi.domain.model.funcionario.FuncCargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

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
    public void deshabilitarFuncionarioCargo(Long idFuncCargo) {
        Optional<FuncCargo> funcCargo = this.funcCargoAbs
                .encontrarFunCargoPorId(idFuncCargo);
        if (funcCargo.isEmpty()) {
            throw new RuntimeException("No existe este funcionario-cargo");
        }
        funcCargo.get().setActivo(false);
        this.funcCargoAbs.registrarFuncionarioCargoAbs(funcCargo.get());
    }

    @Override
    public Page<FuncCargo> listaDeFuncCargo(Pageable pageable) {
        return this.funcCargoAbs.listaDeFuncCargo(pageable);
    }
}
