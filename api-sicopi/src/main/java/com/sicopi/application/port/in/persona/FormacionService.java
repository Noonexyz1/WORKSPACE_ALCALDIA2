package com.sicopi.application.port.in.persona;

import com.sicopi.domain.model.persona.Formacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FormacionService {
    //Casos de uso, segun historias de usuario CREAR FUNCIONARIO,
    // Vemos la BD, para ver que operaciones
    //anteriores implican hacer o registrar antes de crear un FUNCIONARIO
    Formacion registrarFormacion(Formacion formacion);
    Formacion editarFormacion(Long idFormacion, Formacion formacion);
    void deshabilitarFormacion(Formacion formacion);
    Page<Formacion> listaDeFormaciones(Pageable pageable);
}



