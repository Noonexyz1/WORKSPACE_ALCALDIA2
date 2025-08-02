package com.sicopi.infrastructure.persistence.db.adapter.dependencia;

import com.sicopi.application.port.out.persistence.dependencia.DependenciaAbs;
import com.sicopi.domain.model.dependencia.Dependencia;
import com.sicopi.infrastructure.persistence.db.entity.dependencia.DependenciaEntity;
import com.sicopi.infrastructure.persistence.db.map.dependencia.DependenciaMapper;
import com.sicopi.infrastructure.persistence.db.repository.dependencia.DependenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class DependenciaAbsAdapter implements DependenciaAbs {

    @Autowired
    private DependenciaRepository dependenciaRepository;


    @Override
    @Transactional
    public Dependencia registrarDependenciaAbs(Dependencia dependencia) {
        DependenciaEntity dependenciaEntity = this.dependenciaRepository
                .save(DependenciaMapper.INSTANCE.toDependenciaEntity(dependencia));
        return DependenciaMapper.INSTANCE.toDependencia(dependenciaEntity);
    }


    @Override
    public void editarDependenciaAbs() {

    }

    @Override
    public Page<Dependencia> listaDeDependenciasAbs(Pageable pageable) {
        return this.dependenciaRepository.findAll(pageable)
                .map(DependenciaMapper.INSTANCE::toDependencia);
    }

    @Override
    public void deshabilitarDependenciaAbs() {

    }

    @Override
    public Dependencia getDependenciaById(Long idDependencia) {
        Optional<DependenciaEntity> dependenciaEntity = this.dependenciaRepository
                .findById(idDependencia);
        return dependenciaEntity
                .map(DependenciaMapper.INSTANCE::toDependencia)
                .orElse(null);
    }
}
