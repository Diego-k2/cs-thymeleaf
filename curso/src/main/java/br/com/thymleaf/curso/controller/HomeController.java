package br.com.thymleaf.curso.controller;

import br.com.thymleaf.curso.model.entity.PedidoModel;
import br.com.thymleaf.curso.model.entity.RoleModel;
import br.com.thymleaf.curso.model.entity.UserModel;
import br.com.thymleaf.curso.model.enuns.StatusPedido;
import br.com.thymleaf.curso.model.repository.RoleRepository;
import br.com.thymleaf.curso.model.repository.UserRepository;
import br.com.thymleaf.curso.model.service.PedidoService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class HomeController {

    final PedidoService pedidoService;
    final RoleRepository roleRepository;
    final UserRepository userRepository;
    public HomeController(PedidoService pedidoService, RoleRepository roleRepository, UserRepository userRepository) {
        this.pedidoService = pedidoService;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
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

//    @GetMapping("/save")
//    public String save(){
//
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//        UserModel userModel = new UserModel();
//        userModel.setUsername("maria");
//        userModel.setPassword(encoder.encode("123"));
//        RoleModel roleModel = roleRepository.findByRole("ADMIN").get();
//        List<RoleModel> roleModels = new ArrayList<>();
//        roleModels.add(roleModel);
//        userModel.setRoles(roleModels);
//
//        userRepository.save(userModel);
//        return "redirect:/login";
//    }

//    public String onNotFound(){
//        return "redirect:/";

//    }

}
