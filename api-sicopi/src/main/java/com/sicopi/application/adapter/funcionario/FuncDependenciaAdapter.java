package com.sicopi.application.adapter.funcionario;

import com.sicopi.application.port.in.funcionario.FuncDependenciaService;
import com.sicopi.application.port.out.persistence.funcionario.FuncDependenciaAbs;
import com.sicopi.domain.model.funcionario.FuncDependencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

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
    public void deshabilitarFuncionarioDependencia(Long idFuncDep) {
        Optional<FuncDependencia> funcDependencia = this.funcDependenciaAbs
                .encontrarFunDepById(idFuncDep);
        if (funcDependencia.isEmpty()) {
            throw new RuntimeException("No existe este id Funcionario-depenendia");
        }
        funcDependencia.get().setActivo(false);
        this.funcDependenciaAbs.registrarFuncionarioDependenciaAbs(funcDependencia.get());
    }

    @Override
    public Page<FuncDependencia> listaDeFuncDependencia(Pageable pageable) {
        return this.funcDependenciaAbs.listaDeFuncDependencia(pageable);
    }
}
