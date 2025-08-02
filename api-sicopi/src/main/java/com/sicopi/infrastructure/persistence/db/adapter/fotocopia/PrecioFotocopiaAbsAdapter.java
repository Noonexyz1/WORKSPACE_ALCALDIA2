package com.sicopi.infrastructure.persistence.db.adapter.fotocopia;

import com.sicopi.application.port.out.persistence.fotocopia.PrecioFotocopiaAbs;
import com.sicopi.domain.model.fotocopia.PrecioFotocopia;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.PrecioFotocopiaEntity;
import com.sicopi.infrastructure.persistence.db.map.fotocopia.PrecioFotocopiaMapper;
import com.sicopi.infrastructure.persistence.db.repository.fotocopia.PrecioFotocopiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
