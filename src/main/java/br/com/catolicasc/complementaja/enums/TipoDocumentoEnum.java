package br.com.catolicasc.complementaja.enums;

public enum TipoDocumentoEnum {
    CERTIFICADO_CURSO(1, "Certificado de curso"),
    CERTIFICADO_PALESTRA(2, "Certificado de participação em palestra"),
    CERTIFICADO_PROJETO_SOCIAL(3, "Certificado de participação em projeto social"),
    OUTROS(4, "Outros");

    private Integer codTipoDocumento;
    private String descricao;

    TipoDocumentoEnum(Integer codTipoDocumento, String descricao) {
        this.codTipoDocumento = codTipoDocumento;
        this.descricao = descricao;
    }

    public Integer getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoDocumentoEnum findTipoDocumento(Integer codTipoDocumento) {
        for (TipoDocumentoEnum a : TipoDocumentoEnum.values()) {
            if (a.getCodTipoDocumento().equals(codTipoDocumento)) {
                return a;
            }
        }
        return null;
    }
}
