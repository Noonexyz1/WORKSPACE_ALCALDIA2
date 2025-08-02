package com.sicopi.domain.model.funcionario;

import com.sicopi.domain.model.persona.Persona;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Funcionario {
    private Long id;
    private Boolean activo;
    private Persona persona;
}
