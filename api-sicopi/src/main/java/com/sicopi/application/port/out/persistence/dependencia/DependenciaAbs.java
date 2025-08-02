package com.sicopi.application.port.out.persistence.dependencia;

import com.sicopi.domain.model.dependencia.Dependencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DependenciaAbs {
    Dependencia registrarDependenciaAbs(Dependencia dependencia);
    Page<Dependencia> listaDeDependenciasAbs(Pageable pageable);
    void editarDependenciaAbs();
    void deshabilitarDependenciaAbs();

    Dependencia getDependenciaById(Long idDependencia);
}
