package com.sicopi.infrastructure.persistence.db.repository.funcionario;

import com.sicopi.infrastructure.persistence.db.entity.funcionario.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {

    @Query(value = """
            select *
            from funcionario f
            where f.persona_id = :idPersona
            and f.activo = true
            """, nativeQuery = true)
    Optional<FuncionarioEntity> findByIdPersona(@Param("idPersona") Long idPersona);
}
