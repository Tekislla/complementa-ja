package br.com.catolicasc.complementaja.controller;

import br.com.catolicasc.complementaja.dto.UsuarioDTO;
import br.com.catolicasc.complementaja.dto.UsuarioLoginDTO;
import br.com.catolicasc.complementaja.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService service;

    @GetMapping(value = "/{id}")
    public UsuarioDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody UsuarioLoginDTO dto) {
        UsuarioDTO u = service.login(dto);
        if (u != null) {
            return ResponseEntity.ok().body(u);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
