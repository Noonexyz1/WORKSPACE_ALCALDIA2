package com.sicopi.application.port.in.empresa;

import com.sicopi.domain.model.empresa.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmpresaService {
    Empresa registrarEmpresa(Empresa empresa);
    Empresa editarEmpresa(Long idEmpresa, Empresa empresa);
    Page<Empresa> listaDeEmpresas(Pageable pageable);
}
