package br.com.thymleaf.curso.api;

import br.com.thymleaf.curso.model.entity.PedidoModel;
import br.com.thymleaf.curso.model.enuns.StatusPedido;
import br.com.thymleaf.curso.model.service.PedidoService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRest {


    final PedidoService pedidoService;
    public PedidoRest(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/aguardando")
    public ResponseEntity<Object> getPedidosAguardando(){

        Sort sort = Sort.by("id").descending(); // para ordenar por data da entrega
        PageRequest paginacao = PageRequest.of( 0, 1000, sort); //Paginação

        return ResponseEntity.status(HttpStatus.FOUND).body(pedidoService.findAllByStatus(StatusPedido.AGUARDANDO, paginacao));
    }
}
