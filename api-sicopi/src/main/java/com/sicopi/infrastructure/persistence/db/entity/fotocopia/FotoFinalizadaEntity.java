package com.sicopi.infrastructure.persistence.db.entity.fotocopia;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "foto_finalizada")
public class FotoFinalizadaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private FotocopiaEntity fotocopia;
}
