package com.sicopi.application.adapter.fotocopia;

import com.sicopi.application.port.in.fotocopia.RetiroService;
import com.sicopi.application.port.out.persistence.fotocopia.RetiroAbs;
import com.sicopi.domain.model.fotocopia.Retiro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class RetiroAdapter implements RetiroService {

    private final RetiroAbs retiroAbs;

    public RetiroAdapter(RetiroAbs retiroAbs) {
        this.retiroAbs = retiroAbs;
    }

    @Override
    public Retiro registrarRetiro(Retiro retiro) {
        return this.retiroAbs.registrarRetiroAbs(retiro);
    }

    @Override
    public Retiro editarRetiro(Long idRetiro, Retiro retiro) {
        Optional<Retiro> retiroOpt = this.retiroAbs.buscarRetiroPorId(idRetiro);
        if (retiroOpt.isEmpty()) {
            throw new RuntimeException("No existe Retiro con este id");
        }
        retiro.setId(retiroOpt.get().getId());
        return this.retiroAbs.registrarRetiroAbs(retiro);
    }

    @Override
    public Page<Retiro> listaDeRetiros(Pageable pageable) {
        return this.retiroAbs.listaDeRetiros(pageable);
    }

    @Override
    public Optional<Retiro> buscarRetiro(Long idRetiro) {
        return this.retiroAbs.buscarRetiroPorId(idRetiro);
    }
}
