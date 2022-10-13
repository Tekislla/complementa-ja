package br.com.catolicasc.complementaja.entity;

import br.com.catolicasc.complementaja.repository.DocumentoRepository;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "documento", cascade = CascadeType.ALL)
    private List<Documento> documentos;

}
