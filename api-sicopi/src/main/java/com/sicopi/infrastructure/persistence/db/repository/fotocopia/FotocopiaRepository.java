package com.sicopi.infrastructure.persistence.db.repository.fotocopia;

import com.sicopi.infrastructure.persistence.db.entity.fotocopia.FotocopiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotocopiaRepository extends JpaRepository<FotocopiaEntity, Long> {
}
