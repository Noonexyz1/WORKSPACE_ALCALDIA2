package com.sicopi.infrastructure.persistence.db.repository.persona;

import com.sicopi.domain.model.persona.Persona;
import com.sicopi.infrastructure.persistence.db.entity.persona.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
    Optional<PersonaEntity> findByCi(String ci);
}
