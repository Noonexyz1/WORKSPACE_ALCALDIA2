package com.sicopi.application.adapter.persona;

import com.sicopi.application.port.in.persona.FormacionService;
import com.sicopi.application.port.out.persistence.persona.FormacionAbs;
import com.sicopi.application.port.out.persistence.persona.PersonaAbs;
import com.sicopi.domain.model.persona.Formacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class FormacionAdapter implements FormacionService {

    private final FormacionAbs formacionAbs;
    private final PersonaAbs personaAbs;

    public FormacionAdapter(
            FormacionAbs formacionAbs,
            PersonaAbs personaAbs
    ) {
        this.formacionAbs = formacionAbs;
        this.personaAbs = personaAbs;
    }


    @Override
    public Formacion registrarFormacion(Formacion formacion) {
        formacion.setActivo(true);
        return this.formacionAbs.registrarFormacionAbs(formacion);
    }


    @Override
    public Formacion editarFormacion(Long idFormacion, Formacion formacion) {
        Optional<Formacion> formacionFinded = this.formacionAbs.findFormacionById(idFormacion);
        if (formacionFinded.isEmpty()) {
            throw new RuntimeException("Formacion no encontrado con este id");
        }
        formacion.setId(formacionFinded.get().getId());
        return this.formacionAbs.editarFormacionAbs(formacion);
    }

    @Override
    public Page<Formacion> listaDeFormaciones(Pageable pageable) {
        return this.formacionAbs.listaDeFormacionesAbs(pageable);
    }

    @Override
    public void deshabilitarFormacion(Long idFormacion) {
        Optional<Formacion> formacionFinded = this.formacionAbs.findFormacionById(idFormacion);
        if (formacionFinded.isEmpty()) {
            throw new RuntimeException("Formacion no encontrado con este id");
        }
        formacionFinded.get().setActivo(false);
        this.formacionAbs.registrarFormacionAbs(formacionFinded.get());
    }
}
