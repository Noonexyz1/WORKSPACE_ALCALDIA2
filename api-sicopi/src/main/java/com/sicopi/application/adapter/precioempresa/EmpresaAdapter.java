package com.sicopi.application.adapter.precioempresa;

import com.sicopi.application.port.in.precioempresa.EmpresaService;
import com.sicopi.application.port.out.persistence.precioempresa.EmpresaAbs;
import com.sicopi.domain.model.precioempresa.Empresa;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@RequiredArgsConstructor
public class EmpresaAdapter implements EmpresaService {

    private final EmpresaAbs empresaAbs;

    @Override
    public Empresa registrarEmpresa(Empresa empresa) {
        return this.empresaAbs.registrarEmpresa(empresa);
    }

    @Override
    public Empresa editarEmpresa(Long idEmpresa, Empresa empresa) {
        Optional<Empresa> empresaOpt = this.empresaAbs
                .encontrarEmpresaById(idEmpresa);
        if (empresaOpt.isEmpty()) {
            throw new RuntimeException("Este id de empresa no existe");
        }
        empresa.setId(empresaOpt.get().getId());
        return this.empresaAbs.registrarEmpresa(empresa);
    }

    @Override
    public Page<Empresa> listaDeEmpresas(Pageable pageable) {
        return this.empresaAbs.listaDeEmpresas(pageable);
    }
}
