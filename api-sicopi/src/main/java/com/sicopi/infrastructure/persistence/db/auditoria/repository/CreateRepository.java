package com.sicopi.infrastructure.persistence.db.auditoria.repository;

import com.sicopi.infrastructure.persistence.db.auditoria.entity.CreateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateRepository extends JpaRepository<CreateEntity, Long> {
}
