package br.com.catolicasc.complementaja.enums;

public enum PeriodoEnum {
    MATUTINO(1, "Matutino"),
    NOTURNO(2, "Noturno");

    private Integer codPeriodo;
    private String descricao;

    PeriodoEnum(Integer codPeriodo, String descricao) {
        this.codPeriodo = codPeriodo;
        this.descricao = descricao;
    }

    public Integer getCodPeriodo() {
        return codPeriodo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static PeriodoEnum findPeriodo(Integer codPeriodo) {
        for (PeriodoEnum a : PeriodoEnum.values()) {
            if (a.getCodPeriodo().equals(codPeriodo)) {
                return a;
            }
        }
        return null;
    }
}
