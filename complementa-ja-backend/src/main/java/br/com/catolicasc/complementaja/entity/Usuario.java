package br.com.catolicasc.complementaja.entity;

import javax.persistence.*;

@Table(name = "usuario")
@Entity
public class Usuario {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "curso_id")
    private Long cursoId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private Long cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "horas_concluidas")
    private Integer horasConcluidas;

    @Column(name = "horas_necessarias")
    private Integer horasNecessarias;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
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
