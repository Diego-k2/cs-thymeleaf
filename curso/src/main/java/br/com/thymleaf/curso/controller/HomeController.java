package br.com.thymleaf.curso.controller;

import br.com.thymleaf.curso.model.entity.PedidoModel;
import br.com.thymleaf.curso.model.enuns.StatusPedido;
import br.com.thymleaf.curso.model.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class HomeController {

    final PedidoService pedidoService;
    public HomeController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping()
    public String home(Model model){
        PedidoModel pedido = new PedidoModel();

        List<PedidoModel> pedidos = pedidoService.findAll();
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", "todos");
        return "index";
    }

    @GetMapping("/{status}")
    public String aguardando(@PathVariable("status") String status, Model model){
       List<PedidoModel> pedidos =  pedidoService.findAllByStatus(StatusPedido.valueOf(status.toUpperCase(Locale.ROOT)));
       model.addAttribute("pedidos", pedidos);
       model.addAttribute("status", status);
       return "index";
    }

    @ExceptionHandler(IllegalArgumentException.class) //em caso de erro redirecionar para index
    public String onError(){
        return "redirect:/";
    }

//    public String onNotFound(){
//        return "redirect:/";

//    }

}
