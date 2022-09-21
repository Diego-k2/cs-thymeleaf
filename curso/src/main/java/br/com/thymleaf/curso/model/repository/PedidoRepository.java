package br.com.thymleaf.curso.model.repository;

import br.com.thymleaf.curso.model.entity.PedidoModel;
import br.com.thymleaf.curso.model.entity.UserModel;
import br.com.thymleaf.curso.model.enuns.StatusPedido;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, UUID> {

    @Transactional
    @Cacheable("findStatus") //Cria um cache
    List<PedidoModel> findAllByStatusPedido(StatusPedido statusPedido, PageRequest sort);

    @Transactional
    List<PedidoModel> findAllByUser(UserModel userModel); //EXIBINDO ORDENANDO TEMOS QUE PASSAR O SORT

    @Query("SELECT p FROM PedidoModel p WHERE p.user.uuid = :uuid" )
    List<PedidoModel> findByUsuario(@Param("uuid") UUID uuid);

    @Transactional
    List<PedidoModel> findAllByUserAndStatusPedido(UserModel userModel, StatusPedido statusPedido);

}
