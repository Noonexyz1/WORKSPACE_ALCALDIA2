package com.sicopi.application.port.in.formulario;

import com.sicopi.domain.model.fotocopia.Retiro;

import java.util.List;

public interface FormularioRetiroService {
    void registrarFormularioRetiro(List<Retiro> retiroList);
}
