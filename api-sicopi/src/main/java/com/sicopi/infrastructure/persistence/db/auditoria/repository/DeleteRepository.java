package com.sicopi.infrastructure.persistence.db.auditoria.repository;

import com.sicopi.infrastructure.persistence.db.auditoria.entity.DeleteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteRepository extends JpaRepository<DeleteEntity, Long> {
}
