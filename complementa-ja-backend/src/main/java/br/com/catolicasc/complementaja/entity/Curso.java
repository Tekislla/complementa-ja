package br.com.catolicasc.complementaja.entity;

import javax.persistence.*;

@Table(name = "curso")
@Entity
public class Curso {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cod_curso")
    private Integer codCurso;

    @Column(name = "cod_periodo")
    private Integer codPeriodo;

    @Column(name = "cod_semestre")
    private Integer codSemestre;

    @Column(name = "cod_modalidade")
    private Integer codModalidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public Integer getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Integer codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Integer getCodSemestre() {
        return codSemestre;
    }

    public void setCodSemestre(Integer codSemestre) {
        this.codSemestre = codSemestre;
    }

    public Integer getCodModalidade() {
        return codModalidade;
    }

    public void setCodModalidade(Integer codModalidade) {
        this.codModalidade = codModalidade;
    }
}
