package com.sicopi.application.adapter.fotocopia;

import com.sicopi.application.port.in.fotocopia.FotocopiaService;
import com.sicopi.application.port.out.persistence.fotocopia.FotocopiaAbs;
import com.sicopi.domain.model.fotocopia.Fotocopia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class FotocopiaAdapter implements FotocopiaService {

    private final FotocopiaAbs fotocopiaAbs;

    public FotocopiaAdapter(FotocopiaAbs fotocopiaAbs) {
        this.fotocopiaAbs = fotocopiaAbs;
    }

    @Override
    public Fotocopia registrarFotocopia(Fotocopia fotocopia) {
        return this.fotocopiaAbs.registrarFotocopiaAbs(fotocopia);
    }

    @Override
    public Page<Fotocopia> listaDeFotocopias(Pageable pageable) {
        return this.fotocopiaAbs.listaDeFotocopias(pageable);
    }

    @Override
    public void autorizarFotocopia(Long idFotocopia) {
        Optional<Fotocopia> fotocopiaFinded = this.fotocopiaAbs
                .buscarFotocopiaPorId(idFotocopia);

        if (fotocopiaFinded.isEmpty())
            throw new RuntimeException("No existe fotocopia con este id");

        fotocopiaFinded.get().setPendiente(false);
        fotocopiaFinded.get().setAutorizado(true);
        this.fotocopiaAbs.registrarFotocopiaAbs(fotocopiaFinded.get());
    }
}
