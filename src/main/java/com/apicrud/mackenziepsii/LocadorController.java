package com.apicrud.mackenziepsii;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locador")
public class LocadorController {
  
  @Autowired
  LocadorRepository locadorRepository;

  @GetMapping
  public List<Locador> getAllLocadores(){
    return locadorRepository.findAll();
  }

  @GetMapping("/{id}")
  public Locador getLocadorById(@PathVariable Long id){

    return locadorRepository.getById(id);
  } 

  @PostMapping
  public Locador insertNewLocador(@RequestBody Locador locador){

    return locadorRepository.save(locador);
  }

  @PutMapping()
  public boolean updateLocadorById(@RequestBody Locador locador){

    Long locadorId = locador.getId();

    if(!locadorRepository.existsById(locadorId)) return false;

    Locador novoLocador = locadorRepository.getById(locadorId);
    novoLocador = locador;

    locadorRepository.save(novoLocador);

    return true;
  }
}
