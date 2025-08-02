package com.sicopi.infrastructure.persistence.db.repository.persona;

import com.sicopi.infrastructure.persistence.db.entity.persona.FormacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormacionRepository extends JpaRepository<FormacionEntity, Long> {
}
