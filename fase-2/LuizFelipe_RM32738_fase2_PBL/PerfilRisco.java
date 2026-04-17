public enum PerfilRisco {
    CONSERVADOR("Conservador", 0.10),
    MODERADO("Moderado", 0.30),
    ARROJADO("Arrojado", 0.50);

    private final String descricao;
    private final double percentualCriptoSugerido;

    PerfilRisco(String descricao, double percentualCriptoSugerido) {
        this.descricao = descricao;
        this.percentualCriptoSugerido = percentualCriptoSugerido;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPercentualCriptoSugerido() {
        return percentualCriptoSugerido;
    }
}
