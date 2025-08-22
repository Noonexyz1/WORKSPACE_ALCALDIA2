package com.sicopi.infrastructure.persistence.db.adapter.funcionario;

import com.sicopi.application.port.out.persistence.funcionario.FuncionarioAbs;
import com.sicopi.domain.model.funcionario.Funcionario;
import com.sicopi.infrastructure.persistence.db.entity.funcionario.FuncionarioEntity;
import com.sicopi.infrastructure.persistence.db.entity.persona.PersonaEntity;
import com.sicopi.infrastructure.persistence.db.map.funcionario.FuncionarioMapper;
import com.sicopi.infrastructure.persistence.db.repository.funcionario.FuncionarioRepository;
import com.sicopi.infrastructure.persistence.db.repository.persona.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class FuncionarioAbsAdapter implements FuncionarioAbs {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private PersonaRepository personaRepository;


    @Override
    @Transactional
    public Funcionario registrarFuncionarioAbs(Funcionario funcionario) {
        /*if (funcionario.getId() != null) {
            throw new RuntimeException("El id de funcinario debe ser Null");
        }

        if (funcionario.getPersona() == null) {
            throw new RuntimeException("Un funcionario debe terner una persona");
        }

        if (funcionario.getPersona().getId() == null) {
            throw new RuntimeException("Debe ingresar un id de persona existente");
        }

        PersonaEntity personaEntity = this.personaRepository
                .findById(funcionario.getPersona().getId())
                .orElse(null);

        if (personaEntity == null) {
            throw new RuntimeException("Debe ingresar un id de persona existente");
        }*/

        FuncionarioEntity funcionarioEntity = FuncionarioMapper
                .INSTANCE.toFuncionarioEntity(funcionario);
        this.funcionarioRepository.save(funcionarioEntity);
        return FuncionarioMapper.INSTANCE.toFuncionario(funcionarioEntity);
    }

    @Override
    public Optional<Funcionario> encontrarFuncionarioById(Long idFuncionario) {
        Optional<FuncionarioEntity> byId = this.funcionarioRepository
                .findById(idFuncionario);
        return byId.map(FuncionarioMapper.INSTANCE::toFuncionario);
    }

    @Override
    public Page<Funcionario> listaDeFuncionarios(Pageable pageable) {
        Page<FuncionarioEntity> all = this.funcionarioRepository.findAll(pageable);
        return all.map(FuncionarioMapper.INSTANCE::toFuncionario);
    }
}
