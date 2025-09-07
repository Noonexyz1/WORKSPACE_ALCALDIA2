package com.sicopi.application.port.in.fotocopia;

import com.sicopi.domain.model.fotocopia.Fotocopia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FotocopiaService {
    Fotocopia registrarFotocopia(Fotocopia fotocopia);
    Page<Fotocopia> listaDeFotocopias(Pageable pageable);
    void autorizarFotocopia(Long idFotocopia);
}
