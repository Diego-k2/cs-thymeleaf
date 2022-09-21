package br.com.thymleaf.curso.model.service;

import br.com.thymleaf.curso.model.entity.PedidoModel;
import br.com.thymleaf.curso.model.entity.UserModel;
import br.com.thymleaf.curso.model.enuns.StatusPedido;
import br.com.thymleaf.curso.model.repository.PedidoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PedidoService {

    final PedidoRepository pedidoRepository;
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Transactional
    public List<PedidoModel> findAll() {
        return pedidoRepository.findAll();
    }

    @Transactional
    public PedidoModel save(PedidoModel pedidoModel){
        return pedidoRepository.save(pedidoModel);
    }

    @Transactional
    public List<PedidoModel> findAllByStatus(StatusPedido statusPedido, PageRequest sort){
        return pedidoRepository.findAllByStatusPedido(statusPedido, sort);
    }

    @Transactional
    public List<PedidoModel> findAllByUserAndStatusPedido(UserModel userModel, StatusPedido statusPedido){
        return pedidoRepository.findAllByUserAndStatusPedido(userModel, statusPedido);
    }



    @Transactional
    public List<PedidoModel> findAllByUser(UserModel userModel){
        return pedidoRepository.findAllByUser(userModel);
    }


}
