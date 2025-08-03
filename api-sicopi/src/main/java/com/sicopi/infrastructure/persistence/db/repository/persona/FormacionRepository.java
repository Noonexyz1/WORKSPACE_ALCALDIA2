package com.sicopi.infrastructure.persistence.db.repository.persona;

import com.sicopi.infrastructure.persistence.db.entity.persona.FormacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FormacionRepository extends JpaRepository<FormacionEntity, Long> {
    @Query(value = """
            SELECT * FROM formacion f
            WHERE f.persona_id = :idPersona
            ORDER BY f.fecha_creacion DESC
            LIMIT 1
            """, nativeQuery = true)
    FormacionEntity ultimaFormacionDePersona(@Param("idPersona") Long idPersona);
}
