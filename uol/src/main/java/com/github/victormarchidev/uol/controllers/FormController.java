package com.github.victormarchidev.uol.controllers;


import com.github.victormarchidev.uol.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @GetMapping("/formulario")
    public String exibirForm(Model model){
        model.addAttribute("usuario", new User());
        return "formulario";
    }

    @PostMapping("/formulario")
    public String processarForm(@ModelAttribute User user, Model model){
            model.addAttribute("mensagem", "Formulário recebido com sucesso");
            return "resultado";
    }



}
