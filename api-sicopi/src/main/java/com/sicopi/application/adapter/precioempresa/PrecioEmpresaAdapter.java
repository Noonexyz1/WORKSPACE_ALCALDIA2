package com.sicopi.application.adapter.precioempresa;

import com.sicopi.application.port.in.precioempresa.PrecioEmpresaService;
import com.sicopi.application.port.out.persistence.precioempresa.EmpresaAbs;
import com.sicopi.application.port.out.persistence.precioempresa.PrecioEmpresaAbs;
import com.sicopi.application.port.out.persistence.precioempresa.PrecioFotocopiaAbs;
import com.sicopi.domain.model.precioempresa.Empresa;
import com.sicopi.domain.model.precioempresa.PrecioEmpresa;
import com.sicopi.domain.model.precioempresa.PrecioFotocopia;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

//Este Precio Emprededor adapter aglutina dos entidades fuetes mas la intermedia que es esta:
//entonces esta logica de aplicacion se puede permitir tener varias injecciones
@RequiredArgsConstructor
public class PrecioEmpresaAdapter implements PrecioEmpresaService {

    private final PrecioEmpresaAbs precioEmpresaAbs;
    private final PrecioFotocopiaAbs precioFotocopiaAbs;
    private final EmpresaAbs empresaAbs;


    @Override
    public PrecioEmpresa registrarPrecioEmpresa(PrecioEmpresa precioEmpresa) {
        Optional<Empresa> empresa = this.empresaAbs
                .encontrarEmpresaById(precioEmpresa.getEmpresa().getId());

        if (empresa.isEmpty()) {
            throw new RuntimeException("id de empresa no encontrado");
        }

        Optional<PrecioFotocopia> precioFotocopia = this.precioFotocopiaAbs
                .buscarPrecioFotocopiaById(precioEmpresa.getPrecioFotocopia().getId());

        if (precioFotocopia.isEmpty()) {
            throw new RuntimeException("id de Precio-fotocopia no existe");
        }

        precioEmpresa.setEmpresa(empresa.get());
        precioEmpresa.setPrecioFotocopia(precioFotocopia.get());
        return this.precioEmpresaAbs.registrarPrecioEmpresa(precioEmpresa);
    }

    @Override
    public Page<PrecioEmpresa> listaDePrecioEmpresa(Pageable pageable) {
        return this.precioEmpresaAbs.listaDePrecioEmpresa(pageable);
    }

    @Override
    public void habilitarPrecioEmpresa(Long idPrecioEmpresa) {
        Optional<PrecioEmpresa> precioEmpresa = this.precioEmpresaAbs
                .buscarPrecioEmpresaPorId(idPrecioEmpresa);
        if (precioEmpresa.isEmpty()) {
            throw new RuntimeException("Este Precio-empresa con este id no existe");
        }
        precioEmpresa.get().setActivo(true);
        this.precioEmpresaAbs.registrarPrecioEmpresa(precioEmpresa.get());
    }

    @Override
    public void deshabilitarPrecioEmpresa(Long idPrecioEmpresa) {
        Optional<PrecioEmpresa> precioEmpresa = this.precioEmpresaAbs
                .buscarPrecioEmpresaPorId(idPrecioEmpresa);
        if (precioEmpresa.isEmpty()) {
            throw new RuntimeException("Este Precio-empresa con este id no existe");
        }
        precioEmpresa.get().setActivo(false);
        this.precioEmpresaAbs.registrarPrecioEmpresa(precioEmpresa.get());
    }
}
