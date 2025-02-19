package br.com.catolicasc.complementaja.dto;

import java.util.List;

public class UsuarioDTO {
    private Long id;
    private String nome;
    private Long cpf;
    private String email;
    private Integer horasConcluidas;
    private Integer horasNecessarias;
    private CursoDTO curso;
    private List<DocumentoUsuarioDetalheDTO> documentos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CursoDTO getCurso() {
        return curso;
    }

    public void setCurso(CursoDTO curso) {
        this.curso = curso;
    }

    public List<DocumentoUsuarioDetalheDTO> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoUsuarioDetalheDTO> documentos) {
        this.documentos = documentos;
    }
}
