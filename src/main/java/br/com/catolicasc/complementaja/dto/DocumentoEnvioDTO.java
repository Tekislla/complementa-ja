package br.com.catolicasc.complementaja.dto;

public class DocumentoEnvioDTO {
    private Long usuarioId;
    private byte[] arquivo;
    private String nomeDocumento;
    private Integer codTipoDocumento;
    private Integer horasValidas;
    private String dataEmissao;
    private String instituicaoEmissora;

    public DocumentoEnvioDTO() {

    }

    public DocumentoEnvioDTO(Long usuarioId, byte[] arquivo, String nomeDocumento, Integer codTipoDocumento, Integer horasValidas, String dataEmissao, String instituicaoEmissora) {
        this.usuarioId = usuarioId;
        this.arquivo = arquivo;
        this.nomeDocumento = nomeDocumento;
        this.codTipoDocumento = codTipoDocumento;
        this.horasValidas = horasValidas;
        this.dataEmissao = dataEmissao;
        this.instituicaoEmissora = instituicaoEmissora;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
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

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getInstituicaoEmissora() {
        return instituicaoEmissora;
    }

    public void setInstituicaoEmissora(String instituicaoEmissora) {
        this.instituicaoEmissora = instituicaoEmissora;
    }
}
