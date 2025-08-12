package com.sicopi.infrastructure.persistence.db.adapter.autenticacion;

import com.sicopi.application.port.out.persistence.autenticacion.PermisoRolAbs;
import com.sicopi.domain.model.autenticacion.PermisoRol;
import com.sicopi.infrastructure.persistence.db.entity.autenticacion.PermisoEntity;
import com.sicopi.infrastructure.persistence.db.entity.autenticacion.PermisoRolEntity;
import com.sicopi.infrastructure.persistence.db.entity.autenticacion.RolEntity;
import com.sicopi.infrastructure.persistence.db.map.autenticacion.PermisoRolMapper;
import com.sicopi.infrastructure.persistence.db.repository.autenticacion.PermisoRepository;
import com.sicopi.infrastructure.persistence.db.repository.autenticacion.PermisoRolRepository;
import com.sicopi.infrastructure.persistence.db.repository.autenticacion.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PermisoRolAbsAdapter implements PermisoRolAbs {

    @Autowired
    private PermisoRolRepository permisoRolRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private PermisoRepository permisoRepository;


    @Override
    public PermisoRol registrarPermisoRolAbs(PermisoRol permisoRol) {
        if (permisoRol.getId() != null) {
            throw new RuntimeException("Este id debe ser nullo para poder registrar un perimiso-rol");
        }

        if (permisoRol.getPermiso() == null &&
                permisoRol.getRol() == null) {
            throw new RuntimeException("Debe existir un rol y permiso para registrar un perimiso-rol");
        }

        if (permisoRol.getPermiso().getId() == null &&
                permisoRol.getRol().getId() == null) {
            throw new RuntimeException("Rol y permiso deben tener un id valido perimiso-rol");
        }

        RolEntity rolEntity = this.rolRepository
                .findById(permisoRol.getPermiso().getId()).orElse(null);

        PermisoEntity permisoEntity = this.permisoRepository
                .findById(permisoRol.getRol().getId()).orElse(null);

        if (rolEntity == null && permisoEntity == null) {
            throw new RuntimeException("estos ids de Rol y permiso no existen");
        }

        PermisoRolEntity permisoRolEntity = PermisoRolMapper.INSTANCE.toPermisoRolEntity(permisoRol);
        permisoRolEntity.setRol(rolEntity);
        permisoRolEntity.setPermiso(permisoEntity);
        this.permisoRolRepository.save(permisoRolEntity);
        return PermisoRolMapper.INSTANCE.toPermisoRol(permisoRolEntity);
    }

    @Override
    public void deshabilitarPermisoRolAbs() {

    }

    @Override
    public Page<PermisoRol> listaDePermisoRolAbs(Pageable pageable) {
        Page<PermisoRolEntity> permisoRolEntities = this.permisoRolRepository.findAll(pageable);
        return permisoRolEntities.map(PermisoRolMapper.INSTANCE::toPermisoRol);
    }
}
