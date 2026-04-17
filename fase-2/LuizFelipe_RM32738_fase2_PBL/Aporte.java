import java.time.LocalDate;

public class Aporte {

    private int id;
    private CriptoAtivo criptoAtivo;
    private double quantidade;
    private double valorInvestido;
    private double precoUnitarioNaCompra;
    private LocalDate dataAporte;

    public Aporte() {
    }

    public Aporte(int id, CriptoAtivo criptoAtivo, double quantidade,
                  double valorInvestido, double precoUnitarioNaCompra, LocalDate dataAporte) {
        this.id = id;
        this.criptoAtivo = criptoAtivo;
        this.quantidade = quantidade;
        this.valorInvestido = valorInvestido;
        this.precoUnitarioNaCompra = precoUnitarioNaCompra;
        this.dataAporte = dataAporte;
    }

    public double calcularValorAtual() {
        return quantidade * criptoAtivo.getPrecoAtualBrl();
    }

    public double calcularRentabilidade() {
        double valorAtual = calcularValorAtual();
        if (valorInvestido == 0) {
            return 0;
        }
        return ((valorAtual - valorInvestido) / valorInvestido) * 100;
    }

    public double calcularLucro() {
        return calcularValorAtual() - valorInvestido;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CriptoAtivo getCriptoAtivo() {
        return criptoAtivo;
    }

    public void setCriptoAtivo(CriptoAtivo criptoAtivo) {
        this.criptoAtivo = criptoAtivo;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public double getPrecoUnitarioNaCompra() {
        return precoUnitarioNaCompra;
    }

    public void setPrecoUnitarioNaCompra(double precoUnitarioNaCompra) {
        this.precoUnitarioNaCompra = precoUnitarioNaCompra;
    }

    public LocalDate getDataAporte() {
        return dataAporte;
    }

    public void setDataAporte(LocalDate dataAporte) {
        this.dataAporte = dataAporte;
    }

    @Override
    public String toString() {
        return "Aporte{id=" + id + ", cripto=" + criptoAtivo.getSigla() +
                ", quantidade=" + quantidade + ", valorInvestido=" + valorInvestido + "}";
    }
}
