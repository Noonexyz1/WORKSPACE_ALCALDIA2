package com.sicopi.infrastructure.persistence.db.adapter.usuario;

import com.sicopi.application.port.out.persistence.usuario.PermisoAbs;
import com.sicopi.domain.model.usuario.Permiso;
import com.sicopi.infrastructure.persistence.db.entity.usuario.PermisoEntity;
import com.sicopi.infrastructure.persistence.db.map.usuario.PermisoMapper;
import com.sicopi.infrastructure.persistence.db.repository.usuario.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PermisoAbsAdapter implements PermisoAbs {

    @Autowired
    private PermisoRepository permisoRepository;


    @Override
    public Permiso registarPermisoAbs(Permiso permiso) {
        PermisoEntity permisoEntity = this.permisoRepository
                .save(PermisoMapper.INSTANCE.toPermisoEntity(permiso));
        return PermisoMapper.INSTANCE.toPermiso(permisoEntity);
    }

    @Override
    public Page<Permiso> listaDePermisosAbs(Pageable pageable) {
        Page<PermisoEntity> permisoRepositoryAll = this.permisoRepository.findAll(pageable);
        return permisoRepositoryAll.map(PermisoMapper.INSTANCE::toPermiso);
    }

    @Override
    public Optional<Permiso> buscarPermisoById(Long idPermiso) {
        Optional<PermisoEntity> byId = this.permisoRepository.findById(idPermiso);
        return byId.map(PermisoMapper.INSTANCE::toPermiso);
    }
}
