package com.sicopi.application.adapter.funcionario;

import com.sicopi.application.port.in.funcionario.FuncionarioService;
import com.sicopi.application.port.out.persistence.funcionario.FuncionarioAbs;
import com.sicopi.domain.model.funcionario.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class FuncionarioAdapter implements FuncionarioService {

    private final FuncionarioAbs funcionarioAbs;

    public FuncionarioAdapter(FuncionarioAbs funcionarioAbs) {
        this.funcionarioAbs = funcionarioAbs;
    }

    @Override
    public Funcionario registrarFuncionario(Funcionario funcionario) {
        return this.funcionarioAbs.registrarFuncionarioAbs(funcionario);
    }

    @Override
    public void deshabilitarFuncionario(Long idFuncionario) {
        Optional<Funcionario> funcionario = this.funcionarioAbs
                .encontrarFuncionarioById(idFuncionario);
        if (funcionario.isEmpty()) {
            throw new RuntimeException("Este funcionario no existe con este id");
        }
        funcionario.get().setActivo(false);
        this.funcionarioAbs.registrarFuncionarioAbs(funcionario.get());
    }

    @Override
    public void habilitarFuncionario(Long idFuncionario) {
        Optional<Funcionario> funcionario = this.funcionarioAbs
                .encontrarFuncionarioById(idFuncionario);
        if (funcionario.isEmpty()) {
            throw new RuntimeException("Este funcionario no existe con este id");
        }
        funcionario.get().setActivo(true);
        this.registrarFuncionario(funcionario.get());
    }

    @Override
    public Page<Funcionario> listaDeFuncionarios(Pageable pageable) {
        return this.funcionarioAbs.listaDeFuncionarios(pageable);
    }
}
