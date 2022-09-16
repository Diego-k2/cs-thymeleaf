package br.com.thymleaf.curso.model.repository;

import br.com.thymleaf.curso.model.entity.PedidoModel;
import br.com.thymleaf.curso.model.enuns.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, UUID> {

    @Transactional
    List<PedidoModel> findAllByStatusPedido(StatusPedido statusPedido);

}
