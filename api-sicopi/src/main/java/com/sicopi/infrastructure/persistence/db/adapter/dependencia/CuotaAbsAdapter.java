package com.sicopi.infrastructure.persistence.db.adapter.dependencia;

import com.sicopi.application.port.out.persistence.dependencia.CuotaAbs;
import com.sicopi.domain.model.dependencia.Cuota;
import com.sicopi.infrastructure.persistence.db.entity.dependencia.CuotaEntity;
import com.sicopi.infrastructure.persistence.db.entity.dependencia.DependenciaEntity;
import com.sicopi.infrastructure.persistence.db.map.dependencia.CuotaMapper;
import com.sicopi.infrastructure.persistence.db.repository.dependencia.CuotaRepository;
import com.sicopi.infrastructure.persistence.db.repository.dependencia.DependenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class CuotaAbsAdapter implements CuotaAbs {

    @Autowired
    private CuotaRepository cuotaRepository;
    @Autowired
    private DependenciaRepository dependenciaRepository;


    @Override
    @Transactional
    public Cuota registrarCuotaAbs(Cuota cuota) {
        if (cuota.getDependencia().getId() == null) {
            throw new RuntimeException("Ingrese un id de dependencia valido");
        }

        DependenciaEntity dependenciaEntity = this.dependenciaRepository
                .findById(cuota.getDependencia().getId()).orElse(null);

        if (dependenciaEntity == null) {
            throw new RuntimeException("No existe esta dependencia con este ID");
        }

        CuotaEntity cuotaEntity = CuotaMapper.INSTANCE.toCuotaEntity(cuota);
        cuotaEntity.setDependencia(dependenciaEntity);
        this.cuotaRepository.save(cuotaEntity);
        return CuotaMapper.INSTANCE.toCuota(cuotaEntity);
    }

    @Override
    public Cuota editarCuotaAbs(Cuota cuota) {
        CuotaEntity cuotaEntity = this.cuotaRepository
                .save(CuotaMapper.INSTANCE.toCuotaEntity(cuota));
        return CuotaMapper.INSTANCE.toCuota(cuotaEntity);
    }

    @Override
    public void deshabilitarCuotaAbs() {

    }

    @Override
    public Cuota findCuotaPorId(Long idCuota) {
        Optional<CuotaEntity> cuotaEntity = this.cuotaRepository.findById(idCuota);
        return cuotaEntity.map(CuotaMapper.INSTANCE::toCuota).orElse(null);
    }
}
