package br.com.thymleaf.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oferta")
public class OfertaContoller {


    @GetMapping
    public String getFormularioParaOfertas(){
        return "ofertas/index";
    }
}
