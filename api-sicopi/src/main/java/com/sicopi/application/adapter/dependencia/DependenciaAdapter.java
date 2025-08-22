package com.sicopi.application.adapter.dependencia;

import com.sicopi.application.port.in.dependencia.DependenciaService;
import com.sicopi.application.port.out.persistence.dependencia.DependenciaAbs;
import com.sicopi.domain.model.dependencia.Dependencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

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
        Optional<Dependencia> dependenciaEncontrada = this.dependenciaAbs
                .getDependenciaById(idDependencia);
        if (dependenciaEncontrada.isEmpty()) {
            throw new RuntimeException("No hay dependencia con este Id");
        }
        dependencia.setId(dependenciaEncontrada.get().getId());
        return this.dependenciaAbs.registrarDependenciaAbs(dependencia);
    }

    @Override
    public Page<Dependencia> listaDeDependencias(Pageable pageable) {
        return this.dependenciaAbs.listaDeDependenciasAbs(pageable);
    }

    @Override
    public void deshabilitarDependencia(Long idDependencia) {
        Optional<Dependencia> dependencia = this.dependenciaAbs
                .getDependenciaById(idDependencia);
        if (dependencia.isEmpty()) {
            throw new RuntimeException("Este id de depemendicia no existe");
        }
        dependencia.get().setActivo(false);
        this.dependenciaAbs.registrarDependenciaAbs(dependencia.get());
    }

    @Override
    public void habilitarDependencia(Long idDependencia) {
        Optional<Dependencia> dependencia = this.dependenciaAbs
                .getDependenciaById(idDependencia);
        if (dependencia.isEmpty()) {
            throw new RuntimeException("Este id de depemendicia no existe");
        }
        dependencia.get().setActivo(true);
        this.dependenciaAbs.registrarDependenciaAbs(dependencia.get());
    }
}
