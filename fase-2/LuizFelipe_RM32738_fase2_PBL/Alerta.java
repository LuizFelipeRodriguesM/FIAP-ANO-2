import java.time.LocalDateTime;

public class Alerta {

    private int id;
    private TipoAlerta tipoAlerta;
    private String mensagem;
    private LocalDateTime dataGeracao;
    private boolean lido;

    public Alerta() {
        this.lido = false;
    }

    public Alerta(int id, TipoAlerta tipoAlerta, String mensagem, LocalDateTime dataGeracao) {
        this.id = id;
        this.tipoAlerta = tipoAlerta;
        this.mensagem = mensagem;
        this.dataGeracao = dataGeracao;
        this.lido = false;
    }

    public void marcarComoLido() {
        this.lido = true;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoAlerta getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(TipoAlerta tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(LocalDateTime dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public boolean isLido() {
        return lido;
    }

    public void setLido(boolean lido) {
        this.lido = lido;
    }

    @Override
    public String toString() {
        return "Alerta{id=" + id + ", tipo=" + tipoAlerta +
                ", mensagem=" + mensagem + ", lido=" + lido + "}";
    }
}
