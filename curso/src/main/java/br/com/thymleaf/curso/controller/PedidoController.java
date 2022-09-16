package br.com.thymleaf.curso.controller;

import br.com.thymleaf.curso.model.dto.PedidoDto;
import br.com.thymleaf.curso.model.entity.PedidoModel;
import br.com.thymleaf.curso.model.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


    @GetMapping("/formulario")
    public String formulario (Model model,PedidoDto pedidoDto){
        return "pedido/formulario";
    }

    @PostMapping("/novo")
    public String novoPedido(@Valid PedidoDto pedidoDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){ //tratando o erro
            return "pedido/formulario";
        }

        PedidoModel pedidoModel = pedidoDto.toPedido();
        pedidoService.save(pedidoModel);
        return "redirect:/";
    }

}
