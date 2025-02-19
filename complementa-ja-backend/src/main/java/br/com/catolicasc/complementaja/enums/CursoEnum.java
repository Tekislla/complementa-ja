package br.com.catolicasc.complementaja.enums;

public enum CursoEnum {
    ADMINISTRAÇAO(1, "Administração"),
    ARQUITETURA_E_URBANISMO(2, "Arquitetura e Urbanismo"),
    BIOMEDICINA(3, "Biomedicina"),
    CIENCIAS_CONTABEIS(4, "Ciências Contábeis"),
    DESIGN(5, "Design"),
    DESIGN_DE_MODA(6, "Design de Moda"),
    DIREITO(7, "Direito"),
    ENGENHARIA_CIVIL(8, "Engenharia Civil"),
    ENGENHARIA_DE_PRODUCAO(9, "Engenharia de Produção"),
    ENGENHARIA_DE_SOFTWARE(10, "Engenharia de Software"),
    ENGENHARIA_ELETRICA(11, "Engenharia Elétrica"),
    ENGENHARIA_MECANICA(12, "Engenharia Mecânica"),
    NUTRICAO(13, "Nutrição"),
    PSICOLOGIA(14, "Psicologia"),
    TEOLOGIA(15, "Teologia"),
    ENGENHARIA_QUIMICA(16, "Engenharia Química"),
    GESTAO_DA_PRODUCAO_INDUSTRIAL(17, "Gestão da Produção Industrial"),
    ANALISE_E_DESENVOLVIMENTO_DE_SISTEMAS(18, "Análise e Desenvolvimento de Sistemas"),
    EDUCACAO_FISICA(19, "Educação Física"),
    GESTAO_COMERCIAL(20, "Gestão Comercial"),
    GESTAO_DE_RECURSOS_HUMANOS(21, "Gestão de Recursos Humanos"),
    GESTAO_DE_VAREJO(22, "Gestão de Varejo"),
    GESTAO_E_EMPREENDEDORISMO(23, "Gestão e Empreendedorismo"),
    GESTAO_FINANCEIRA(24, "Gestão Financeira"),
    GESTAO_PUBLICA(25, "Gestão Pública"),
    LOGISTICA(26, "Logística"),
    PEDAGOGIA(27, "Pedagogia"),
    PROCESSOS_GERENCIAIS(28, "Processos Gerenciais"),
    SERVICO_SOCIAL(29, "Serviço Social");

    private Integer codCurso;
    private String descricao;

    CursoEnum(Integer codCurso, String descricao) {
        this.codCurso = codCurso;
        this.descricao = descricao;
    }

    public Integer getCodCurso() {
        return codCurso;
    }

    public String getDescricao() {
        return descricao;
    }

    public static CursoEnum findCurso(Integer codCurso) {
        for (CursoEnum a : CursoEnum.values()) {
            if (a.getCodCurso().equals(codCurso)) {
                return a;
            }
        }
        return null;
    }
}
