package com.sicopi.infrastructure.persistence.db.adapter.funcionario;

import com.sicopi.application.port.out.persistence.funcionario.FuncDependenciaAbs;
import com.sicopi.domain.model.funcionario.FuncDependencia;
import com.sicopi.infrastructure.persistence.db.entity.dependencia.DependenciaEntity;
import com.sicopi.infrastructure.persistence.db.entity.funcionario.FuncDependenciaEntity;
import com.sicopi.infrastructure.persistence.db.entity.funcionario.FuncionarioEntity;
import com.sicopi.infrastructure.persistence.db.map.funcionario.FuncDependenciaMapper;
import com.sicopi.infrastructure.persistence.db.repository.dependencia.DependenciaRepository;
import com.sicopi.infrastructure.persistence.db.repository.funcionario.FuncDependenciaRepository;
import com.sicopi.infrastructure.persistence.db.repository.funcionario.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FuncDependenciaAbsAdapter implements FuncDependenciaAbs {

    @Autowired
    private FuncDependenciaRepository funcDependenciaRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private DependenciaRepository dependenciaRepository;


    @Override
    public FuncDependencia registrarFuncionarioDependenciaAbs(FuncDependencia funcDependencia) {
        if (funcDependencia.getId() != null) {
            throw new RuntimeException("Para registar un Funcionario-Dependecia, el id debe ser null");
        }

        if (funcDependencia.getDependencia() == null &&
                funcDependencia.getFuncionario() == null) {
            throw new RuntimeException("Se debe haber un funcionario y una dependencia");
        }

        if (funcDependencia.getDependencia().getId() == null &&
                funcDependencia.getFuncionario().getId() == null) {
            throw new RuntimeException("Se debe ingresar ids validos para funcionario y dependencia");
        }

        DependenciaEntity dependenciaEntity = this.dependenciaRepository
                .findById(funcDependencia.getDependencia().getId()).orElse(null);

        FuncionarioEntity funcionarioEntity = this.funcionarioRepository
                .findById(funcDependencia.getFuncionario().getId()).orElse(null);

        if (dependenciaEntity == null && funcionarioEntity == null) {
            throw new RuntimeException("No existe esta dependencia y funcionario con estes ids");
        }

        FuncDependenciaEntity funcDependenciaEntity = FuncDependenciaMapper
                .INSTANCE.toFuncDependenciaEntity(funcDependencia);

        funcDependenciaEntity.setDependencia(dependenciaEntity);
        funcDependenciaEntity.setFuncionario(funcionarioEntity);

        this.funcDependenciaRepository.save(funcDependenciaEntity);
        return FuncDependenciaMapper.INSTANCE.toFuncDependencia(funcDependenciaEntity);
    }

    @Override
    public void deshabilitarFuncionarioDependenciaAbs() {

    }
}
