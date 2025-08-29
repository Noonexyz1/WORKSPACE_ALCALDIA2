package com.sicopi.infrastructure.persistence.db.adapter.empresa;

import com.sicopi.application.port.out.persistence.empresa.PrecioFotocopiaAbs;
import com.sicopi.domain.model.empresa.PrecioFotocopia;
import com.sicopi.infrastructure.persistence.db.entity.empresa.PrecioFotocopiaEntity;
import com.sicopi.infrastructure.persistence.db.map.empresa.PrecioFotocopiaMapper;
import com.sicopi.infrastructure.persistence.db.repository.empresa.PrecioFotocopiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PrecioFotocopiaAbsAdapter implements PrecioFotocopiaAbs {

    @Autowired
    private PrecioFotocopiaRepository precioFotocopiaRepository;

    @Override
    public PrecioFotocopia registrarPrecioFotocopiaAbs(PrecioFotocopia precioFotocopia) {
        PrecioFotocopiaEntity precioFotocopiaEntity = PrecioFotocopiaMapper
                .INSTANCE.toPrecioFotocopiaEntity(precioFotocopia);
        this.precioFotocopiaRepository.save(precioFotocopiaEntity);
        return PrecioFotocopiaMapper.INSTANCE.toPrecioFotocopia(precioFotocopiaEntity);
    }

    @Override
    public Page<PrecioFotocopia> listaDePrecioFotocopia(Pageable pageable) {
        Page<PrecioFotocopiaEntity> all = this.precioFotocopiaRepository.findAll(pageable);
        return all.map(PrecioFotocopiaMapper.INSTANCE::toPrecioFotocopia);
    }

    @Override
    public Optional<PrecioFotocopia> buscarPrecioFotocopiaById(Long idPrecioFotocopia) {
        Optional<PrecioFotocopiaEntity> byId = this.precioFotocopiaRepository.findById(idPrecioFotocopia);
        return byId.map(PrecioFotocopiaMapper.INSTANCE::toPrecioFotocopia);
    }
}
