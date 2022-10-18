package br.com.catolicasc.complementaja.controller;

import br.com.catolicasc.complementaja.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService service;

}
