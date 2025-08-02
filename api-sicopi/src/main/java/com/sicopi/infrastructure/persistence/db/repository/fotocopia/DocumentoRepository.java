package com.sicopi.infrastructure.persistence.db.repository.fotocopia;

import com.sicopi.infrastructure.persistence.db.entity.fotocopia.DocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<DocumentoEntity, Long> {
}
