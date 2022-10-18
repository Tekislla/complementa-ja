package br.com.catolicasc.complementaja.service;

import br.com.catolicasc.complementaja.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repo;

}
