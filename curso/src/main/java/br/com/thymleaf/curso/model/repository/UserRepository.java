package br.com.thymleaf.curso.model.repository;

import br.com.thymleaf.curso.model.entity.PedidoModel;
import br.com.thymleaf.curso.model.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

    @Transactional
    Optional<UserModel> findByUsername(String username);

}
