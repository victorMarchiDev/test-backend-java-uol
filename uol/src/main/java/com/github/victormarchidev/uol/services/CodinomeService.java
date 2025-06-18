package com.github.victormarchidev.uol.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.victormarchidev.uol.model.User;
import com.github.victormarchidev.uol.model.dto.CodinomeDTO;
import com.github.victormarchidev.uol.repository.UolRepository;
import com.github.victormarchidev.uol.wrappers.LigaDaJusticaWrapper;
import com.github.victormarchidev.uol.wrappers.VingadoresWrapper;
import jakarta.xml.bind.JAXB;
import jakarta.xml.bind.JAXBContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CodinomeService {

    private final UolRepository repository;

    public CodinomeService(UolRepository repository) {
        this.repository = repository;
    }


    public String obterCodinomeDisponivel(String grupo) throws Exception{
        Set<String> codinomesUsados = repository.findAll()
                .stream()
                .map(User::getCodinome)
                .collect(Collectors.toSet());

        if(grupo.equalsIgnoreCase("Vingadores")){
            InputStream is = new ClassPathResource("vingadores.json").getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            VingadoresWrapper dados = mapper.readValue(is, VingadoresWrapper.class);

            return dados.getVingadores()
                    .stream()
                    .map(CodinomeDTO::codinome)
                    .filter(c -> !codinomesUsados.contains(c))
                    .findFirst()
                    .orElse(null);
        } else if (grupo.equalsIgnoreCase("Liga da Justiça")) {
            InputStream is = new ClassPathResource("liga_da_justica.xml").getInputStream();
            JAXBContext context = JAXBContext.newInstance(LigaDaJusticaWrapper.class);
            LigaDaJusticaWrapper dados = (LigaDaJusticaWrapper) context.createUnmarshaller().unmarshal(is);
            return dados.getCodinomes()
                    .stream()
                    .filter(c -> !codinomesUsados.contains(c))
                    .findFirst()
                    .orElse(null);
        }

        return null;

    }

}
