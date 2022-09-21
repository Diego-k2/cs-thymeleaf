package br.com.thymleaf.curso.controller;

import br.com.thymleaf.curso.model.entity.PedidoModel;
import br.com.thymleaf.curso.model.entity.UserModel;
import br.com.thymleaf.curso.model.enuns.StatusPedido;
import br.com.thymleaf.curso.model.repository.RoleRepository;
import br.com.thymleaf.curso.model.repository.UserRepository;
import br.com.thymleaf.curso.model.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {


    final PedidoService pedidoService;
    final RoleRepository roleRepository;
    final UserRepository userRepository;
    public UsuarioController(PedidoService pedidoService, RoleRepository roleRepository, UserRepository userRepository) {
        this.pedidoService = pedidoService;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @GetMapping()
    public String home(Model model, Principal principal){

        UserModel userModel = userRepository.findByUsername(principal.getName()).get();

        List<PedidoModel> pedidos = pedidoService.findAllByUser(userModel);

        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", "todos");
        return "usuario/index";
    }

    @GetMapping("/{status}")
    public String aguardando(@PathVariable("status") String status, Model model, Principal principal){
        UserModel userModel = userRepository.findByUsername(principal.getName()).get();
        List<PedidoModel> pedidos =  pedidoService.findAllByUserAndStatusPedido( userModel, StatusPedido.valueOf(status.toUpperCase()));

        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);
        return "usuario/index";
    }
}
