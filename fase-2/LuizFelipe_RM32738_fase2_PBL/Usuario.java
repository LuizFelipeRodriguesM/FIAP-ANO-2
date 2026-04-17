import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private LocalDate dataNascimento;
    private PerfilRisco perfilRisco;
    private List<Carteira> carteiras;
    private List<Empresa> empresas;
    private List<Meta> metas;
    private List<Alerta> alertas;

    public Usuario() {
        this.carteiras = new ArrayList<>();
        this.empresas = new ArrayList<>();
        this.metas = new ArrayList<>();
        this.alertas = new ArrayList<>();
    }

    public Usuario(int id, String nome, String email, String senha, String cpf,
                   LocalDate dataNascimento, PerfilRisco perfilRisco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.perfilRisco = perfilRisco;
        this.carteiras = new ArrayList<>();
        this.empresas = new ArrayList<>();
        this.metas = new ArrayList<>();
        this.alertas = new ArrayList<>();
    }

    public void adicionarCarteira(Carteira carteira) {
        this.carteiras.add(carteira);
    }

    public void adicionarEmpresa(Empresa empresa) {
        this.empresas.add(empresa);
    }

    public void adicionarMeta(Meta meta) {
        this.metas.add(meta);
    }

    public void adicionarAlerta(Alerta alerta) {
        this.alertas.add(alerta);
    }

    public double calcularPatrimonioTotal() {
        double total = 0;
        for (Carteira carteira : carteiras) {
            total += carteira.calcularValorAtual();
        }
        return total;
    }

    public int getAlertasNaoLidos() {
        int count = 0;
        for (Alerta alerta : alertas) {
            if (!alerta.isLido()) {
                count++;
            }
        }
        return count;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public PerfilRisco getPerfilRisco() {
        return perfilRisco;
    }

    public void setPerfilRisco(PerfilRisco perfilRisco) {
        this.perfilRisco = perfilRisco;
    }

    public List<Carteira> getCarteiras() {
        return carteiras;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public List<Meta> getMetas() {
        return metas;
    }

    public List<Alerta> getAlertas() {
        return alertas;
    }

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nome=" + nome + ", email=" + email +
                ", perfilRisco=" + perfilRisco + "}";
    }
}
