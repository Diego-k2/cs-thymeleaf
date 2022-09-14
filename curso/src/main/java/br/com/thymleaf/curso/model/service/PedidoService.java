package br.com.thymleaf.curso.model.service;

import br.com.thymleaf.curso.model.entity.PedidoModel;
import br.com.thymleaf.curso.model.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
