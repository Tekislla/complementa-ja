package br.com.catolicasc.complementaja.dto;

import br.com.catolicasc.complementaja.entity.Usuario;

import java.util.Date;

public class DocumentoUsuarioDetalheDTO {
    private String nomeDocumento;
    private String tipoDocumento;
    private Integer horasValidas;
    private Date dataEmissao;
    private Date dataEnvio;
    private String instituicaoEmissora;
    private Boolean aceito;
    private byte[] arquivo;

    public String getNomeDocumento() {
        return nomeDocumento;
    }

    public void setNomeDocumento(String nomeDocumento) {
        this.nomeDocumento = nomeDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
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

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }
}
