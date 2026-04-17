public enum TipoAlerta {
    QUEDA_PRECO("Queda de preco"),
    ALTA_PRECO("Alta de preco"),
    META_ATINGIDA("Meta atingida"),
    REBALANCEAMENTO("Sugestao de rebalanceamento"),
    OPORTUNIDADE("Oportunidade de aporte");

    private final String descricao;

    TipoAlerta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
