package com.github.victormarchidev.uol.controllers;


import com.github.victormarchidev.uol.model.User;
import com.github.victormarchidev.uol.repository.UolRepository;
import com.github.victormarchidev.uol.services.CodinomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    private final UolRepository repository;
    private final CodinomeService codinomeService;

    public FormController(UolRepository repository, CodinomeService codinomeService) {
        this.repository = repository;
        this.codinomeService = codinomeService;
    }

    @GetMapping("/formulario")
    public String exibirForm(Model model){
        model.addAttribute("usuario", new User());
        return "formulario";
    }

    @PostMapping("/formulario")
    public String processarForm(@ModelAttribute User user, Model model){
            try{
                String codinome = codinomeService.obterCodinomeDisponivel(user.getGrupo());
                if(codinome == null){
                    model.addAttribute("mensagem", "Todos os codinomes deste grupo ja foram escolhidos");
                    return "erro";
                }

                user.setCodinome(codinome);
                repository.save(user);
                model.addAttribute("user", user);
                model.addAttribute("mensagem", "Usuário cadastrado com sucesso!");
                return "resultado";

            } catch (Exception e) {
                e.printStackTrace();
               model.addAttribute("mensagem", "Erro ao atribuir codinome ao usuario");
               return "erro";
            }
    }



}
