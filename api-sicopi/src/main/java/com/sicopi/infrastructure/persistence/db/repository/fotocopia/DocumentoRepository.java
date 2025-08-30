package com.sicopi.infrastructure.persistence.db.repository.fotocopia;

import com.sicopi.infrastructure.persistence.db.entity.fotocopia.DocumentoEntity;
import com.sicopi.infrastructure.persistence.db.entity.fotocopia.FotocopiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentoRepository extends JpaRepository<DocumentoEntity, Long> {
    List<DocumentoEntity> findAllByFotocopia(FotocopiaEntity fotocopiaEntity);
}
