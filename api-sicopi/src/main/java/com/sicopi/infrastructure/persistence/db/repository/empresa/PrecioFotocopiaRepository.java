package com.sicopi.infrastructure.persistence.db.repository.empresa;

import com.sicopi.infrastructure.persistence.db.entity.empresa.PrecioFotocopiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrecioFotocopiaRepository extends JpaRepository<PrecioFotocopiaEntity, Long> {

    @Query(value = """
            select *
            from precio_fotocopia pf
            where pf.anver_rever = :anverRever
            and pf.color  = :color
            and pf.tamano = :tamano
            and pf.activo = true
            """, nativeQuery = true)
    Optional<PrecioFotocopiaEntity> findPrecioByCampos(
            @Param("anverRever") String anverRever,
            @Param("color") String color,
            @Param("tamano") String tamano
    );
}
