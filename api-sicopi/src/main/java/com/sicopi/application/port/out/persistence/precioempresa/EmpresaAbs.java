package com.sicopi.application.port.out.persistence.precioempresa;

import com.sicopi.domain.model.precioempresa.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmpresaAbs {
    Empresa registrarEmpresa(Empresa empresa);
    Optional<Empresa> encontrarEmpresaById(Long idEmpresa);
    Page<Empresa> listaDeEmpresas(Pageable pageable);
}
