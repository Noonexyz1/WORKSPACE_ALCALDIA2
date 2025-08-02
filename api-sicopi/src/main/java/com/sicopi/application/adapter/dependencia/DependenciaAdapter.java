package com.sicopi.application.adapter.dependencia;

import com.sicopi.application.port.in.dependencia.DependenciaService;
import com.sicopi.application.port.out.persistence.dependencia.DependenciaAbs;
import com.sicopi.domain.model.dependencia.Dependencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class DependenciaAdapter implements DependenciaService {

    private final DependenciaAbs dependenciaAbs;

    public DependenciaAdapter(DependenciaAbs dependenciaAbs) {
        this.dependenciaAbs = dependenciaAbs;
    }


    @Override
    public Dependencia registrarDependencia(Dependencia dependencia) {
        return this.dependenciaAbs.registrarDependenciaAbs(dependencia);
    }

    @Override
    public Dependencia editarDependencia(Long idDependencia, Dependencia dependencia) {
        Dependencia dependenciaEncontrada = this.dependenciaAbs.getDependenciaById(idDependencia);
        if (dependenciaEncontrada == null) {
            throw new RuntimeException("No hay dependencia con este Id");
        }
        dependencia.setId(dependenciaEncontrada.getId());
        return this.dependenciaAbs.registrarDependenciaAbs(dependencia);
    }

    @Override
    public Page<Dependencia> listaDeDependencias(Pageable pageable) {
        return this.dependenciaAbs.listaDeDependenciasAbs(pageable);
    }

    @Override
    public void deshabilitarDependencia() {

    }
}
