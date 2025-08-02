package com.sicopi.infrastructure.persistence.db.entity.funcionario;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "func_cargo")
public class FuncCargoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean activo;

    @ManyToOne
    private FuncionarioEntity funcionario;
    @ManyToOne
    private CargoEntity cargo;
    //Al negocio no le importa que fecha empieza a trabajar o deja, le importa si
    //esta funcion esta activo para trabajar
}
