package com.sicopi.infrastructure.persistence.db.repository.fotocopia;

import com.sicopi.infrastructure.persistence.db.entity.fotocopia.RetiroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetiroRepository extends JpaRepository<RetiroEntity, Long> {
}
