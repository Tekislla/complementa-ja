package br.com.catolicasc.complementaja.enums;

public enum SemestreEnum {

    PRIMEIRO(1, "Primeiro semestre"),
    SEGUNDO(2, "Segundo semestre"),
    TERCEIRO(3, "Terceiro semestre"),
    QUARTO(4, "Quarto semestre"),
    QUINTO(5, "Quinto semestre"),
    SEXTO(6, "Sexto semestre"),
    SETIMO(7, "Sétimo semestre"),
    OITAVO(8, "Oitavo semestre"),
    NONO(9, "Nono semestre"),
    DECIMO(10, "Décimo semestre");

    private Integer codSemestre;
    private String descricao;

    SemestreEnum(Integer codSemestre, String descricao) {
        this.codSemestre = codSemestre;
        this.descricao = descricao;
    }

    public Integer getCodSemestre() {
        return codSemestre;
    }

    public String getDescricao() {
        return descricao;
    }

    public static SemestreEnum findSemestre(Integer codSemestre) {
        for (SemestreEnum a : SemestreEnum.values()) {
            if (a.getCodSemestre().equals(codSemestre)) {
                return a;
            }
        }
        return null;
    }
}
