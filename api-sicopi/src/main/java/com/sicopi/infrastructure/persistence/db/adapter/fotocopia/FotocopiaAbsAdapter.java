package com.sicopi.infrastructure.persistence.db.adapter.fotocopia;

import com.sicopi.application.port.out.persistence.fotocopia.FotocopiaAbs;
import com.sicopi.domain.model.fotocopia.Fotocopia;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.FotocopiaEntity;
import com.sicopi.infrastructure.persistence.db.entity.solicitud.SolicitudEntity;
import com.sicopi.infrastructure.persistence.db.map.fotocopia.FotocopiaMapper;
import com.sicopi.infrastructure.persistence.db.repository.fotocopia.FotocopiaRepository;
import com.sicopi.infrastructure.persistence.db.repository.solicitud.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FotocopiaAbsAdapter implements FotocopiaAbs {

    @Autowired
    private FotocopiaRepository fotocopiaRepository;
    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public Fotocopia registrarFotocopiaAbs(Fotocopia fotocopia) {
        SolicitudEntity solicitudEntity = this.solicitudRepository
                .findById(fotocopia.getSolicitud().getId()).orElse(null);

        FotocopiaEntity fotocopiaEntity = FotocopiaMapper.INSTANCE.toFotocopiaEntity(fotocopia);
        fotocopiaEntity.setSolicitud(solicitudEntity);
        this.fotocopiaRepository.save(fotocopiaEntity);
        return FotocopiaMapper.INSTANCE.toFotocopia(fotocopiaEntity);
    }
}
