package com.sicopi.infrastructure.persistence.db.repository.funcionario;

import com.sicopi.infrastructure.persistence.db.entity.funcionario.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {
}
