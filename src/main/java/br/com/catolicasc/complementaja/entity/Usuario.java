package br.com.catolicasc.complementaja.entity;

import javax.persistence.*;

@Table(name = "usuario")
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cursoId;
    private String nome;
    private Long cpf;
    private String email;
    private String senha;
    private Integer horasConcluidas;
    private Integer horasNecessarias;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getHorasConcluidas() {
        return horasConcluidas;
    }

    public void setHorasConcluidas(Integer horasConcluidas) {
        this.horasConcluidas = horasConcluidas;
    }

    public Integer getHorasNecessarias() {
        return horasNecessarias;
    }

    public void setHorasNecessarias(Integer horasNecessarias) {
        this.horasNecessarias = horasNecessarias;
    }
}
