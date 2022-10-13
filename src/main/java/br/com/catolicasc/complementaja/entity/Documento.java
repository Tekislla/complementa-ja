package br.com.catolicasc.complementaja.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Table
@Entity
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
