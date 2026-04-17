public class Empresa {

    private int id;
    private String nome;
    private String cnpj;
    private String descricao;

    public Empresa() {
    }

    public Empresa(int id, String nome, String cnpj, String descricao) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.descricao = descricao;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Empresa{id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + "}";
    }
}
