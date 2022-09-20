package br.com.thymleaf.curso.controller;

import br.com.thymleaf.curso.model.entity.PedidoModel;
import br.com.thymleaf.curso.model.entity.UserModel;
import br.com.thymleaf.curso.model.repository.PedidoRepository;
import br.com.thymleaf.curso.model.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/teste")
public class Teste {

    final UserRepository userRepository;
    final PedidoRepository pedidoRepository;
    public Teste(UserRepository userRepository, PedidoRepository pedidoRepository) {
        this.userRepository = userRepository;
        this.pedidoRepository = pedidoRepository;
    }


    @GetMapping()
    public ResponseEntity<Object> home(Principal principal){

//        String username = principal.getName();

        UserModel userModel = userRepository.findByUsername(principal.getName()).get();

        List<PedidoModel> pedidos =pedidoRepository.findByUsuario(userModel.getUuid());
//
//        for (PedidoModel p:
//                pedidos) {
//            System.out.println(p.getNomeProduto());
//        }

//        model.addAttribute("pedidos", pedidos);
//        model.addAttribute("status", "todos");
        return ResponseEntity.status(HttpStatus.OK).body(pedidos);

//        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findByUsername("diego"));

    }
}
