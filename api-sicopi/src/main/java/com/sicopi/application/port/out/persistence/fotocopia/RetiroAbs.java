package com.sicopi.application.port.out.persistence.fotocopia;

import com.sicopi.domain.model.fotocopia.Retiro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RetiroAbs {
    Retiro registrarRetiroAbs(Retiro retiro);
    Optional<Retiro> buscarRetiroPorId(Long idRetiro);
    Page<Retiro> listaDeRetiros(Pageable pageable);
}
