package com.sicopi.infrastructure.persistence.db.entity.funcionario;

import com.sicopi.infrastructure.persistence.db.entity.persona.PersonaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "funcionario")
public class FuncionarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean activo;

    @ManyToOne
    private PersonaEntity persona;

    @OneToMany(mappedBy = "funcionario")
    private List<FuncCargoEntity> funcCargoEntityList;
    @OneToMany(mappedBy = "funcionario")
    private List<FuncDependenciaEntity> funcDependenciaEntityList;


    private LocalDateTime fechaCreacion;

    @PrePersist
    public void iniciarValores() {
        this.fechaCreacion = LocalDateTime.now();
        this.activo = true;
    }
}
