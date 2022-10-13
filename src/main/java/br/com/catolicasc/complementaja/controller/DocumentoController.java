package br.com.catolicasc.complementaja.controller;

import br.com.catolicasc.complementaja.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/documento")
public class DocumentoController {
    @Autowired
    DocumentoService service;
}
