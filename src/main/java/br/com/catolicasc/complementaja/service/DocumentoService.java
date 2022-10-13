package br.com.catolicasc.complementaja.service;

import br.com.catolicasc.complementaja.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentoService {
    @Autowired
    DocumentoRepository repo;
}
