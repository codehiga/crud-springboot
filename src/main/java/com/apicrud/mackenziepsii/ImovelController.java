package com.apicrud.mackenziepsii;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imovel")
public class ImovelController {

  @Autowired
  ImovelRepository imovelRepository;
  
  @GetMapping
  public List<Imovel> getImoveis(){
    return imovelRepository.findAll();
  }

  @PostMapping
  public Imovel insertImovel(@RequestBody Imovel imovel){

    return imovelRepository.save(imovel);
  }

  @PutMapping("/{id}")
  public void deleteImovelById(@PathVariable Long id){

    imovelRepository.deleteById(id);
  }

  @GetMapping("/{id}")
  public Optional<Imovel> getImovelById(@PathVariable Long id){

    return imovelRepository.findById(id);
  }

  @PutMapping
  public boolean updateImovelById(@RequestBody Imovel imovel){

    Long imovelId = imovel.getId();

    if(!imovelRepository.existsById(imovelId)) return false;

    Imovel novoImovel = imovelRepository.getById(imovelId);
    novoImovel = imovel;

    imovelRepository.save(novoImovel);

    return true;
  }

}
