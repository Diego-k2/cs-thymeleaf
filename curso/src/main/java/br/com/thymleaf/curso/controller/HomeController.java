package br.com.thymleaf.curso.controller;

import br.com.thymleaf.curso.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        Pedido pedido = new Pedido();

        pedido.setNomeProduto("Redmi note 9");
        pedido.setUrlImagem("https://www.amazon.com.br/Celular-Xiaomi-Redmi-64GB-Dual/dp/B08B3VCF9G");
        pedido.setUrlProduto("https://www.amazon.com.br/Celular-Xiaomi-Redmi-64GB-Dual/dp/B08B3VCF9G");
        pedido.setDescricao("Descrição");


        List<Pedido> pedidoList = Arrays.asList(pedido);
        model.addAttribute("pedidos", pedidoList);

        return "index";
    }


}
