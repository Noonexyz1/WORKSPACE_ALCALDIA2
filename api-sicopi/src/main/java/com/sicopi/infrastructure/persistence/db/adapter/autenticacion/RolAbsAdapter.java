package com.sicopi.infrastructure.persistence.db.adapter.autenticacion;

import com.sicopi.application.port.out.persistence.autenticacion.RolAbs;
import com.sicopi.domain.model.autenticacion.Rol;
import com.sicopi.infrastructure.persistence.db.entity.autenticacion.RolEntity;
import com.sicopi.infrastructure.persistence.db.map.autenticacion.RolMapper;
import com.sicopi.infrastructure.persistence.db.repository.autenticacion.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class RolAbsAdapter implements RolAbs {

    @Autowired
    private RolRepository rolRepository;


    @Override
    public Rol registarRolAbs(Rol rol) {
        RolEntity rolEntity = this.rolRepository.save(RolMapper.INSTANCE.toRolEntity(rol));
        return RolMapper.INSTANCE.toRol(rolEntity);
    }

    @Override
    public Rol editarRolAbs(Long idRol, Rol rol) {
        return null;
    }

    @Override
    public Page<Rol> listaDeRolesAbs(Pageable pageable) {
        Page<RolEntity> rolRepositoryAll = this.rolRepository.findAll(pageable);
        return rolRepositoryAll.map(RolMapper.INSTANCE::toRol);
    }

    @Override
    public void deshabilitarRolAbs() {

    }
}
