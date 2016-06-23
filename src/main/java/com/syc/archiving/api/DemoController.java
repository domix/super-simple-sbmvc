package com.syc.archiving.api;

import com.syc.archiving.service.SaludadorService;
import com.syc.archiving.service.SaludoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by domix on 6/22/16.
 */
@RestController
@RequestMapping("/")
public class DemoController {

  @Autowired
  private SaludadorService saludadorService;

  @RequestMapping(method = GET)
  Map holaMundo() {
    Map result = new HashMap<>();
    result.put("saludo", saludadorService.saluda("Mundo"));

    return result;
  }

  @RequestMapping(path = "{nombre}", method = GET)
  Map holaMundoCustom(@PathVariable("nombre") String nombre) {
    Map result = new HashMap<>();
    result.put("saludo", saludadorService.saluda(nombre));

    return result;
  }

  @RequestMapping(path = "_q", method = GET)
  Map holaMundoCustomQuery(@RequestParam(name = "nombre", required = false, defaultValue = "Desconocido") String nombre) {

    Map result = new HashMap<>();
    result.put("saludo", saludadorService.saluda(nombre));

    return result;
  }

  @RequestMapping(method = POST)
  HttpEntity<?> holamundoPayload(@Valid @RequestBody SaludoBean saludoBean, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return ResponseEntity.badRequest().body(saludoBean);
    }
    Map result = new HashMap<>();
    result.put("saludo", saludadorService.saluda(saludoBean.getNombre()));

    return ResponseEntity.ok(result);
  }
}
