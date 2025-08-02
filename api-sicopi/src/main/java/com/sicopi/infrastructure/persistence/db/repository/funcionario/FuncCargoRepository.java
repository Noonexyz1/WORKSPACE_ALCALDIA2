package com.sicopi.infrastructure.persistence.db.repository.funcionario;

import com.sicopi.infrastructure.persistence.db.entity.funcionario.FuncCargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncCargoRepository extends JpaRepository<FuncCargoEntity, Long> {
}
