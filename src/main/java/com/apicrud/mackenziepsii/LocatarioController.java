package com.apicrud.mackenziepsii;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locatario")
public class LocatarioController {

    @Autowired
    LocatarioRepository locatarioRepository;

    @GetMapping
    List<Locatario> getLocatarios(){

        return locatarioRepository.findAll();
    }

    @PostMapping
    Locatario insertLocatario(Locatario locatarioParameter){

        return locatarioRepository.save(locatarioParameter);
    }

    
}
