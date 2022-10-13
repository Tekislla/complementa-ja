package br.com.catolicasc.complementaja.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

@Table(name = "documento")
@Entity
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usuarioId;
    private File arquivo;
    private String nomeDocumento;
    private Integer codTipoDocumento;
    private Integer horasValidas;
    private Date dataEmissao;
    private String instituicaoEmissora;
    private Boolean aceito;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    public String getNomeDocumento() {
        return nomeDocumento;
    }

    public void setNomeDocumento(String nomeDocumento) {
        this.nomeDocumento = nomeDocumento;
    }

    public Integer getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public void setCodTipoDocumento(Integer codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    public Integer getHorasValidas() {
        return horasValidas;
    }

    public void setHorasValidas(Integer horasValidas) {
        this.horasValidas = horasValidas;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getInstituicaoEmissora() {
        return instituicaoEmissora;
    }

    public void setInstituicaoEmissora(String instituicaoEmissora) {
        this.instituicaoEmissora = instituicaoEmissora;
    }

    public Boolean getAceito() {
        return aceito;
    }

    public void setAceito(Boolean aceito) {
        this.aceito = aceito;
    }
}
