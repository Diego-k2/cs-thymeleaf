package br.com.thymleaf.curso.controller;

import br.com.thymleaf.curso.model.entity.PedidoModel;
import br.com.thymleaf.curso.model.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    final PedidoService pedidoService;
    public HomeController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


    @GetMapping("/")
    public String home(Model model){
        PedidoModel pedido = new PedidoModel();

        List<PedidoModel> pedidos = pedidoService.findAll();
        model.addAttribute("pedidos", pedidos);

        return "index";
    }


}
