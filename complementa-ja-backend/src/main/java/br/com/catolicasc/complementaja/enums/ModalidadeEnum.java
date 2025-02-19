package br.com.catolicasc.complementaja.enums;

public enum ModalidadeEnum {
    PRESENCIAL(1, "Presencial"),
    SEMIPRESENCIAL(2, "Semipresencial"),
    EAD(3, "EAD");

    private Integer codModalidade;
    private String descricao;

    ModalidadeEnum(Integer codModalidade, String descricao) {
        this.codModalidade = codModalidade;
        this.descricao = descricao;
    }

    public Integer getCodModalidade() {
        return codModalidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ModalidadeEnum findModalidade(Integer codModalidade) {
        for (ModalidadeEnum a : ModalidadeEnum.values()) {
            if (a.getCodModalidade().equals(codModalidade)) {
                return a;
            }
        }
        return null;
    }
}
