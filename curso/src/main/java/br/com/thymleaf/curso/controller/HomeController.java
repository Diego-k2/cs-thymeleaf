package br.com.thymleaf.curso.controller;

import br.com.thymleaf.curso.model.entity.PedidoModel;
import br.com.thymleaf.curso.model.enuns.StatusPedido;
import br.com.thymleaf.curso.model.service.PedidoService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    final PedidoService pedidoService;
    public HomeController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


    @GetMapping("/{page}")
    public String home(Model model, @PathVariable("page") Integer page){

        Sort sort = Sort.by("dtEntrega").descending(); // para ordenar por data da entrega

        PageRequest paginacao = PageRequest.of( page, 1, sort); //Paginação

        List<PedidoModel> pedidos = pedidoService.findAllByStatus(StatusPedido.ENTREGUE, paginacao);

        model.addAttribute("pedidos", pedidos);

        return "index";
    }

    @ExceptionHandler(IllegalArgumentException.class) //em caso de erro redirecionar para index
    public String onError(){
        return "redirect:/";
    }

    public String onNotFound(){
        return "redirect:/";

    }

}
