package com.sicopi.infrastructure.http.rest.dto;

import com.sicopi.domain.model.dependencia.Dependencia;
import com.sicopi.domain.model.funcionario.Cargo;
import com.sicopi.domain.model.persona.Formacion;
import com.sicopi.domain.model.persona.Persona;
import lombok.Data;

@Data
public class FuncionarioDTO {
    private Persona persona;
    private Cargo cargo;
    private Dependencia dependencia;
    private Formacion formacion;
}
