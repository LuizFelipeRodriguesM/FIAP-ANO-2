import java.util.ArrayList;
import java.util.List;

public class CriptoAtivo {

    private int id;
    private String nome;
    private String sigla;
    private String descricao;
    private List<Cotacao> historicoCotacoes;

    public CriptoAtivo() {
        this.historicoCotacoes = new ArrayList<>();
    }

    public CriptoAtivo(int id, String nome, String sigla, String descricao) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.descricao = descricao;
        this.historicoCotacoes = new ArrayList<>();
    }

    public void adicionarCotacao(Cotacao cotacao) {
        this.historicoCotacoes.add(cotacao);
    }

    public Cotacao getCotacaoAtual() {
        if (historicoCotacoes.isEmpty()) {
            return null;
        }
        return historicoCotacoes.get(historicoCotacoes.size() - 1);
    }

    public double getPrecoAtualBrl() {
        Cotacao cotacao = getCotacaoAtual();
        if (cotacao == null) {
            return 0;
        }
        return cotacao.getValorBrl();
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Cotacao> getHistoricoCotacoes() {
        return historicoCotacoes;
    }

    @Override
    public String toString() {
        return "CriptoAtivo{id=" + id + ", nome=" + nome + ", sigla=" + sigla + "}";
    }
}
