package br.com.thymleaf.curso.controller;

import br.com.thymleaf.curso.model.dto.PedidoDto;
import br.com.thymleaf.curso.model.entity.PedidoModel;
import br.com.thymleaf.curso.model.entity.UserModel;
import br.com.thymleaf.curso.model.repository.UserRepository;
import br.com.thymleaf.curso.model.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    final PedidoService pedidoService;
    final UserRepository userRepository;
    public PedidoController(PedidoService pedidoService, UserRepository userRepository) {
        this.pedidoService = pedidoService;
        this.userRepository = userRepository;
    }


    @GetMapping("/formulario")
    public String formulario (Model model,PedidoDto pedidoDto){
        return "pedido/formulario";
    }

    @PostMapping("/novo")
    public String novoPedido(@Valid PedidoDto pedidoDto, BindingResult bindingResult, Principal principal){

        if(bindingResult.hasErrors()){ //tratando o erro
            return "pedido/formulario";
        }

        PedidoModel pedidoModel = pedidoDto.toPedido();

        UserModel userModel = userRepository.findByUsername(principal.getName()).get();

        pedidoModel.setUser(userModel);

        pedidoService.save(pedidoModel);
        return "redirect:/";
    }

}
