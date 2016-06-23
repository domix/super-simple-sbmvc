package com.syc.archiving.service;

import javax.validation.constraints.NotNull;

/**
 * Created by domix on 6/22/16.
 */
public class SaludoBean {
  @NotNull
  private String saludo;
  @NotNull
  private String nombre;
  @NotNull
  private Integer algo;

  public String getSaludo() {
    return saludo;
  }

  public void setSaludo(String saludo) {
    this.saludo = saludo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getAlgo() {
    return algo;
  }

  public void setAlgo(Integer algo) {
    this.algo = algo;
  }
}
