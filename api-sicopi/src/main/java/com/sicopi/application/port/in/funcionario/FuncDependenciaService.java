package com.sicopi.application.port.in.funcionario;

import com.sicopi.domain.model.funcionario.FuncDependencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FuncDependenciaService {
    FuncDependencia registrarFuncionarioDependencia(FuncDependencia funcDependencia);
    void deshabilitarFuncionarioDependencia(Long idFuncDep);
    Page<FuncDependencia> listaDeFuncDependencia(Pageable pageable);
}
