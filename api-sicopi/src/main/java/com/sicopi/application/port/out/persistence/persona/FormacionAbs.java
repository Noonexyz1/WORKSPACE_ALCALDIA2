package com.sicopi.application.port.out.persistence.persona;

import com.sicopi.domain.model.persona.Formacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface FormacionAbs {
    //Casos de uso, segun historias de usuario CREAR FUNCIONARIO,
    // Vemos la BD, para ver que operaciones
    //anteriores implican hacer o registrar antes de crear un FUNCIONARIO
    Formacion registrarFormacionAbs(Formacion formacion);
    Formacion editarFormacionAbs(Formacion formacion);
    Page<Formacion> listaDeFormacionesAbs(Pageable pageable);
    Optional<Formacion> findFormacionById(Long idFormacion);
}



