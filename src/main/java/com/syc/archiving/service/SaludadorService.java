package com.syc.archiving.service;

import org.springframework.stereotype.Service;

/**
 * Created by domix on 6/22/16.
 */
@Service
public class SaludadorService {

  public String saluda(String nombre) {
    return String.format("Hola %s", nombre);
  }
}
