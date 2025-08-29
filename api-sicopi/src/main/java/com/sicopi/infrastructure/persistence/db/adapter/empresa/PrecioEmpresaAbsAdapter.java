package com.sicopi.infrastructure.persistence.db.adapter.empresa;

import com.sicopi.application.port.out.persistence.empresa.PrecioEmpresaAbs;
import com.sicopi.domain.model.empresa.PrecioEmpresa;
import com.sicopi.infrastructure.persistence.db.entity.empresa.PrecioEmpresaEntity;
import com.sicopi.infrastructure.persistence.db.map.empresa.PrecioEmpresaMapper;
import com.sicopi.infrastructure.persistence.db.repository.empresa.PrecioEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PrecioEmpresaAbsAdapter implements PrecioEmpresaAbs {

    @Autowired
    private PrecioEmpresaRepository precioEmpresaRepository;


    @Override
    public PrecioEmpresa registrarPrecioEmpresa(PrecioEmpresa precioEmpresa) {
        PrecioEmpresaEntity precioEmpresaEntity = PrecioEmpresaMapper.INSTANCE
                .toPrecioEmpresaEntity(precioEmpresa);
        this.precioEmpresaRepository.save(precioEmpresaEntity);
        return PrecioEmpresaMapper.INSTANCE.toPrecioEmpresa(precioEmpresaEntity);
    }

    @Override
    public Page<PrecioEmpresa> listaDePrecioEmpresa(Pageable pageable) {
        Page<PrecioEmpresaEntity> all = this.precioEmpresaRepository.findAll(pageable);
        return all.map(PrecioEmpresaMapper.INSTANCE::toPrecioEmpresa);
    }

    @Override
    public Optional<PrecioEmpresa> buscarPrecioEmpresaPorId(Long idPrecioEmpresa) {
        Optional<PrecioEmpresaEntity> byId = this.precioEmpresaRepository.findById(idPrecioEmpresa);
        return byId.map(PrecioEmpresaMapper.INSTANCE::toPrecioEmpresa);
    }
}
