package com.sicopi.infrastructure.persistence.db.repository.funcionario;

import com.sicopi.infrastructure.persistence.db.entity.funcionario.FuncDependenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncDependenciaRepository extends JpaRepository<FuncDependenciaEntity, Long> {
}
