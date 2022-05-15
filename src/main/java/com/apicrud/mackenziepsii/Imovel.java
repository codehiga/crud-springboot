package com.apicrud.mackenziepsii;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Imovel {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;

  String endereco;
  String idProprietario;
  String valor;
  String dataDisponivel;
  boolean propriedadeColaborativa;
  boolean disponibilidade;


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getProprietario() {
    return this.idProprietario;
  }

  public void setProprietario(String proprietario) {
    this.idProprietario = proprietario;
  }

  public String getValor() {
    return this.valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  public String getDataDisponivel() {
    return this.dataDisponivel;
  }

  public void setDataDisponivel(String dataDisponivel) {
    this.dataDisponivel = dataDisponivel;
  }

  public boolean isPropriedadeColaborativa() {
    return this.propriedadeColaborativa;
  }

  public boolean getPropriedadeColaborativa() {
    return this.propriedadeColaborativa;
  }

  public void setPropriedadeColaborativa(boolean propriedadeColaborativa) {
    this.propriedadeColaborativa = propriedadeColaborativa;
  }

  public boolean isDisponibilidade() {
    return this.disponibilidade;
  }

  public boolean getDisponibilidade() {
    return this.disponibilidade;
  }

  public void setDisponibilidade(boolean disponibilidade) {
    this.disponibilidade = disponibilidade;
  }

}
