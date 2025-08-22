package com.sicopi.application.port.out.persistence.funcionario;

import com.sicopi.domain.model.funcionario.FuncDependencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface FuncDependenciaAbs {
    FuncDependencia registrarFuncionarioDependenciaAbs(FuncDependencia funcDependencia);
    void deshabilitarFuncionarioDependenciaAbs();
    Optional<FuncDependencia> encontrarFunDepById(Long idFuncDep);
    Page<FuncDependencia> listaDeFuncDependencia(Pageable pageable);
}
