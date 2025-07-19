package com.sicopi.domain.model.funcionario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FuncDependencia {
    private Long id;
    private Funcionario funcionario;
    private Dependencia dependencia;
    private Boolean activo;
    //Al negocio no le importa que fecha empieza a trabajar o deja, le importa si
    //esta funcion esta activo para trabajar
}
