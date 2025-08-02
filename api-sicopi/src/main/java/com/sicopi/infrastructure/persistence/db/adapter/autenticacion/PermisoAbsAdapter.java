package com.sicopi.infrastructure.persistence.db.adapter.autenticacion;

import com.sicopi.application.port.out.persistence.autenticacion.PermisoAbs;
import com.sicopi.domain.model.autenticacion.Permiso;
import com.sicopi.infrastructure.persistence.db.entity.autenticacion.PermisoEntity;
import com.sicopi.infrastructure.persistence.db.map.autenticacion.PermisoMapper;
import com.sicopi.infrastructure.persistence.db.repository.autenticacion.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

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
    public Permiso editarPermisoAbs(Long idPermiso, Permiso permiso) {
        return null;
    }

    @Override
    public Page<Permiso> listaDePermisosAbs(Pageable pageable) {
        Page<PermisoEntity> permisoRepositoryAll = this.permisoRepository.findAll(pageable);
        return permisoRepositoryAll.map(PermisoMapper.INSTANCE::toPermiso);
    }

    @Override
    public void deshabilitarPermisoAbs() {

    }
}
