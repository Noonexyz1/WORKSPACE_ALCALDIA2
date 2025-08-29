package com.sicopi.infrastructure.persistence.db.entity.persona;

import com.sicopi.infrastructure.persistence.db.entity.usuario.UsuarioEntity;
import com.sicopi.infrastructure.persistence.db.entity.funcionario.FuncionarioEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "persona")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ci;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    @OneToMany(mappedBy = "persona")
    private List<FormacionEntity> formacionEntityList;
    @OneToMany(mappedBy = "persona")
    private List<FuncionarioEntity> funcionarioEntityList;
    @OneToMany(mappedBy = "persona")
    private List<UsuarioEntity> usuarioEntityList;


    private LocalDateTime fechaCreacion;

    @PrePersist
    public void iniciarValores() {
        this.fechaCreacion = LocalDateTime.now();
    }
}
