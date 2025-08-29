package com.sicopi.infrastructure.persistence.db.adapter.empresa;

import com.sicopi.application.port.out.persistence.empresa.EmpresaAbs;
import com.sicopi.domain.model.empresa.Empresa;
import com.sicopi.infrastructure.persistence.db.entity.empresa.EmpresaEntity;
import com.sicopi.infrastructure.persistence.db.map.empresa.EmpresaMapper;
import com.sicopi.infrastructure.persistence.db.repository.empresa.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmpresaAbsAdapter implements EmpresaAbs {

    @Autowired
    private EmpresaRepository empresaRepository;


    @Override
    public Empresa registrarEmpresa(Empresa empresa) {
        EmpresaEntity empresaEntity = EmpresaMapper.INSTANCE.toEmpresaEntity(empresa);
        this.empresaRepository.save(empresaEntity);
        return EmpresaMapper.INSTANCE.toEmpresa(empresaEntity);
    }

    @Override
    public Optional<Empresa> encontrarEmpresaById(Long idEmpresa) {
        Optional<EmpresaEntity> byId = this.empresaRepository.findById(idEmpresa);
        return byId.map(EmpresaMapper.INSTANCE::toEmpresa);
    }

    @Override
    public Page<Empresa> listaDeEmpresas(Pageable pageable) {
        Page<EmpresaEntity> all = this.empresaRepository.findAll(pageable);
        return all.map(EmpresaMapper.INSTANCE::toEmpresa);
    }
}
