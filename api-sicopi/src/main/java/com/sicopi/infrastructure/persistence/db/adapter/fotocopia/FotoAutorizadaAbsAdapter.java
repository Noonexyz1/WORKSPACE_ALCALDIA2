package com.sicopi.infrastructure.persistence.db.adapter.fotocopia;

import com.sicopi.application.port.out.persistence.fotocopia.FotoAutorizadaAbs;
import com.sicopi.domain.model.fotocopia.FotoAutorizada;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.FotoAutorizadaEntity;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.FotocopiaEntity;
import com.sicopi.infrastructure.persistence.db.map.fotocopia.FotoAutorizadaMapper;
import com.sicopi.infrastructure.persistence.db.repository.fotocopia.FotoAutorizadaRepository;
import com.sicopi.infrastructure.persistence.db.repository.fotocopia.FotocopiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FotoAutorizadaAbsAdapter implements FotoAutorizadaAbs {

    @Autowired
    private FotoAutorizadaRepository fotoAutorizadaRepository;
    @Autowired
    private FotocopiaRepository fotocopiaRepository;

    @Override
    public FotoAutorizada registrarFotoAutorizadaAbs(FotoAutorizada fotoAutorizada) {
        FotocopiaEntity fotocopiaEntity = this.fotocopiaRepository
                .findById(fotoAutorizada.getFotocopia().getId()).orElse(null);

        FotoAutorizadaEntity fotoAutorizadaEntity = FotoAutorizadaMapper
                .INSTANCE.toFotoAutorizadaEntity(fotoAutorizada);
        fotoAutorizadaEntity.setFotocopia(fotocopiaEntity);
        this.fotoAutorizadaRepository.save(fotoAutorizadaEntity);
        return FotoAutorizadaMapper.INSTANCE.toFotoAutorizada(fotoAutorizadaEntity);
    }
}
