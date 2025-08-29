package com.sicopi.infrastructure.persistence.db.repository.usuario;

import com.sicopi.infrastructure.persistence.db.entity.usuario.UsuarioRolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRolEntity, Long> {
    @Query(value = """
                select *
                from usuario_rol ur
                where ur.usuario_id = :idUsuario
                and ur.is_active = true
            """, nativeQuery = true)
    Optional<UsuarioRolEntity> findByIdUsuario(@Param("idUsuario") Long idUsuario);
}
