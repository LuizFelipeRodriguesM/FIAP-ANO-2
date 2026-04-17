import java.time.LocalDateTime;

public class Cotacao {

    private int id;
    private double valorBrl;
    private double valorUsd;
    private LocalDateTime dataHora;

    public Cotacao() {
    }

    public Cotacao(int id, double valorBrl, double valorUsd, LocalDateTime dataHora) {
        this.id = id;
        this.valorBrl = valorBrl;
        this.valorUsd = valorUsd;
        this.dataHora = dataHora;
    }

    public double getVariacaoPercentual(Cotacao outra) {
        if (outra.getValorBrl() == 0) {
            return 0;
        }
        return ((this.valorBrl - outra.getValorBrl()) / outra.getValorBrl()) * 100;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorBrl() {
        return valorBrl;
    }

    public void setValorBrl(double valorBrl) {
        this.valorBrl = valorBrl;
    }

    public double getValorUsd() {
        return valorUsd;
    }

    public void setValorUsd(double valorUsd) {
        this.valorUsd = valorUsd;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Cotacao{valorBrl=" + valorBrl + ", valorUsd=" + valorUsd +
                ", dataHora=" + dataHora + "}";
    }
}
