package com.github.victormarchidev.uol.controllers;


import com.github.victormarchidev.uol.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {

    @GetMapping("/formulario")
    public String exibirForm(Model model){
        model.addAttribute("usuario", new User());
    }

}
