package com.sicopi.domain.model.funcionario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FuncCargo {
    private Long id;
    private Funcionario funcionario;
    private Cargo cargo;
    private Boolean activo;
    //Al negocio no le importa que fecha empieza a trabajar o deja, le importa si
    //esta funcion esta activo para trabajar
}
