package com.sicopi.application.port.in.dependencia;

import com.sicopi.domain.model.dependencia.Dependencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DependenciaService {
    Dependencia registrarDependencia(Dependencia dependencia);
    Dependencia editarDependencia(Long idDependencia, Dependencia dependencia);
    Page<Dependencia> listaDeDependencias(Pageable pageable);
    void deshabilitarDependencia();
}
