package com.sicopi.application.port.out.persistence.fotocopia;

import com.sicopi.domain.model.fotocopia.Fotocopia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface FotocopiaAbs {
    Fotocopia registrarFotocopiaAbs(Fotocopia fotocopia);
    Page<Fotocopia> listaDeFotocopias(Pageable pageable);
    Optional<Fotocopia> buscarFotocopiaPorId(Long idFotocopia);
}
