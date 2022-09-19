package br.com.thymleaf.curso.model.repository;

import br.com.thymleaf.curso.model.entity.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleModel, UUID> {

    Optional<RoleModel> findByRole(String role);
}
