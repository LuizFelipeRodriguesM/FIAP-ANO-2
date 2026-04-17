import java.util.ArrayList;
import java.util.List;

public class Carteira {

    private int id;
    private String nome;
    private String descricao;
    private Empresa empresa;
    private List<Aporte> aportes;

    public Carteira() {
        this.aportes = new ArrayList<>();
    }

    public Carteira(int id, String nome, String descricao, Empresa empresa) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.empresa = empresa;
        this.aportes = new ArrayList<>();
    }

    public void adicionarAporte(Aporte aporte) {
        this.aportes.add(aporte);
    }

    public double calcularValorAtual() {
        double total = 0;
        for (Aporte aporte : aportes) {
            total += aporte.calcularValorAtual();
        }
        return total;
    }

    public double calcularTotalInvestido() {
        double total = 0;
        for (Aporte aporte : aportes) {
            total += aporte.getValorInvestido();
        }
        return total;
    }

    public double calcularRentabilidade() {
        double totalInvestido = calcularTotalInvestido();
        if (totalInvestido == 0) {
            return 0;
        }
        double valorAtual = calcularValorAtual();
        return ((valorAtual - totalInvestido) / totalInvestido) * 100;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Aporte> getAportes() {
        return aportes;
    }

    @Override
    public String toString() {
        return "Carteira{id=" + id + ", nome=" + nome + ", aportes=" + aportes.size() + "}";
    }
}
