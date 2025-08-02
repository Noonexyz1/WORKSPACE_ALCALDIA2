package com.sicopi.infrastructure.persistence.db.adapter.fotocopia;

import com.sicopi.application.port.out.persistence.fotocopia.FotoFinalizadaAbs;
import com.sicopi.domain.model.fotocopia.FotoFinalizada;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.FotoFinalizadaEntity;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.FotocopiaEntity;
import com.sicopi.infrastructure.persistence.db.map.fotocopia.FotoFinalizadaMapper;
import com.sicopi.infrastructure.persistence.db.repository.fotocopia.FotoFinalizadaRepository;
import com.sicopi.infrastructure.persistence.db.repository.fotocopia.FotocopiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FotoFinalizadaAbsAdapter implements FotoFinalizadaAbs {

    @Autowired
    private FotoFinalizadaRepository fotoFinalizadaRepository;
    @Autowired
    private FotocopiaRepository fotocopiaRepository;

    @Override
    public FotoFinalizada registrarFotoFinalizadaAbs(FotoFinalizada fotoFinalizada) {
        FotocopiaEntity fotocopiaEntity = this.fotocopiaRepository
                .findById(fotoFinalizada.getFotocopia().getId()).orElse(null);

        FotoFinalizadaEntity fotoFinalizadaEntity = FotoFinalizadaMapper
                .INSTANCE.toFotoFinalizadaEntity(fotoFinalizada);
        fotoFinalizadaEntity.setFotocopia(fotocopiaEntity);
        this.fotoFinalizadaRepository.save(fotoFinalizadaEntity);
        return FotoFinalizadaMapper.INSTANCE.toFotoFinalizada(fotoFinalizadaEntity);
    }
}
