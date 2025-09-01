package com.sicopi.infrastructure.persistence.db.adapter.fotocopia;

import com.sicopi.application.port.out.persistence.fotocopia.RetiroAbs;
import com.sicopi.domain.model.fotocopia.Retiro;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.DocumentoEntity;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.RetiroEntity;
import com.sicopi.infrastructure.persistence.db.map.fotocopia.RetiroMapper;
import com.sicopi.infrastructure.persistence.db.repository.fotocopia.DocumentoRepository;
import com.sicopi.infrastructure.persistence.db.repository.fotocopia.RetiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RetiroAbsAdapter implements RetiroAbs {

    @Autowired
    private RetiroRepository retiroRepository;
    @Autowired
    private DocumentoRepository documentoRepository;

    @Override
    public Retiro registrarRetiroAbs(Retiro retiro) {
        DocumentoEntity documentoEntity = this.documentoRepository
                .findById(retiro.getDocumento().getId()).orElse(null);

        RetiroEntity retiroEntity = RetiroMapper.INSTANCE.toRetiroEntity(retiro);
        retiroEntity.setDocumento(documentoEntity);
        this.retiroRepository.save(retiroEntity);
        return RetiroMapper.INSTANCE.toRetiro(retiroEntity);
    }

    @Override
    public Optional<Retiro> buscarRetiroPorId(Long idRetiro) {
        Optional<RetiroEntity> byId = this.retiroRepository.findById(idRetiro);
        return byId.map(RetiroMapper.INSTANCE::toRetiro);
    }

    @Override
    public Page<Retiro> listaDeRetiros(Pageable pageable) {
        Page<RetiroEntity> all = this.retiroRepository.findAll(pageable);
        return all.map(RetiroMapper.INSTANCE::toRetiro);
    }

    @Override
    public Optional<Retiro> buscarUltimoRetiroPorIdDocumento(Long idDocumento) {
        Optional<RetiroEntity> retiroEntityFinded = this.retiroRepository
                .findLastByDocumentoId(idDocumento);
        return retiroEntityFinded.map(RetiroMapper.INSTANCE::toRetiro);
    }
}
