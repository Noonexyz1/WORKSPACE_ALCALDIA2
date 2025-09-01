package com.sicopi.infrastructure.persistence.db.repository.fotocopia;

import com.sicopi.infrastructure.persistence.db.entity.fotocopia.RetiroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RetiroRepository extends JpaRepository<RetiroEntity, Long> {
    @Query(value = """       
            SELECT *
            FROM retiro
            WHERE documento_id = :idDocumento
            ORDER BY id DESC
            LIMIT 1
            """, nativeQuery = true)
    Optional<RetiroEntity> findLastByDocumentoId(@Param("idDocumento") Long idDocumento);
}
