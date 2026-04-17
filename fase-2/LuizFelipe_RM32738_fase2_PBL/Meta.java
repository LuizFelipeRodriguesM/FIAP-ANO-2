import java.time.LocalDate;

public class Meta {

    private int id;
    private String descricao;
    private double valorAlvo;
    private int prazoMeses;
    private LocalDate dataCriacao;
    private Carteira carteira;

    public Meta() {
    }

    public Meta(int id, String descricao, double valorAlvo, int prazoMeses,
                LocalDate dataCriacao, Carteira carteira) {
        this.id = id;
        this.descricao = descricao;
        this.valorAlvo = valorAlvo;
        this.prazoMeses = prazoMeses;
        this.dataCriacao = dataCriacao;
        this.carteira = carteira;
    }

    public double calcularProgresso() {
        if (valorAlvo == 0) {
            return 0;
        }
        double valorAtual = carteira.calcularValorAtual();
        return (valorAtual / valorAlvo) * 100;
    }

    public boolean isAtingida() {
        return carteira.calcularValorAtual() >= valorAlvo;
    }

    public double calcularAporteMensalNecessario() {
        double valorAtual = carteira.calcularValorAtual();
        double faltante = valorAlvo - valorAtual;
        if (faltante <= 0 || prazoMeses <= 0) {
            return 0;
        }
        return faltante / prazoMeses;
    }

    public LocalDate getDataLimite() {
        return dataCriacao.plusMonths(prazoMeses);
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorAlvo() {
        return valorAlvo;
    }

    public void setValorAlvo(double valorAlvo) {
        this.valorAlvo = valorAlvo;
    }

    public int getPrazoMeses() {
        return prazoMeses;
    }

    public void setPrazoMeses(int prazoMeses) {
        this.prazoMeses = prazoMeses;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    @Override
    public String toString() {
        return "Meta{id=" + id + ", descricao=" + descricao +
                ", valorAlvo=" + valorAlvo + "}";
    }
}
