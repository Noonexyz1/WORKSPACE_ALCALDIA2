package com.sicopi.application.port.in.fotocopia;

import com.sicopi.domain.model.fotocopia.Retiro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RetiroService {
    Retiro registrarRetiro(Retiro retiro);
    Retiro editarRetiro(Long idRetiro, Retiro retiro);
    Page<Retiro> listaDeRetiros(Pageable pageable);
    Optional<Retiro> buscarRetiro(Long idRetiro);
    Optional<Retiro> buscarUltimoRetiroPorIdDocumento(Long idDocumento);
}
