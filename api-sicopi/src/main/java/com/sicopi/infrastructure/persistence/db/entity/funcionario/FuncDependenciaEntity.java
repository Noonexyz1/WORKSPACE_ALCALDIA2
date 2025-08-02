package com.sicopi.infrastructure.persistence.db.entity.funcionario;

import com.sicopi.infrastructure.persistence.db.entity.dependencia.DependenciaEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "func_dependencia")
public class FuncDependenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean activo;

    @ManyToOne
    private FuncionarioEntity funcionario;
    @ManyToOne
    private DependenciaEntity dependencia;
    //Al negocio no le importa que fecha empieza a trabajar o deja, le importa si
    //esta funcion esta activo para trabajar
}
