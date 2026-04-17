# Entendendo as Classes Java do Cyphin

Esse arquivo foi feito pra voce ler de cima pra baixo, sem pular nada. Cada secao usa so o que ja foi explicado antes.

---

## Parte 1 — Conceitos basicos antes de ver codigo

### O que e uma classe?

Pensa numa **ficha de cadastro**. Quando voce vai ao medico, preenche uma ficha com nome, CPF, data de nascimento. Uma classe e esse modelo de ficha.

Em codigo, uma classe minima e assim:

```java
public class Carro {
    // aqui dentro vao os dados e as acoes do carro
}
```

So isso ja e uma classe valida. `public` = qualquer um pode usar. `class` = estou criando uma classe. `Carro` = nome dela.

### O que e um objeto?

A classe e o **molde**. O objeto e a **peca pronta**. Voce cria um objeto assim:

```java
Carro meuCarro = new Carro();
//  ^     ^        ^
//  |     |        └── "new" cria um novo objeto usando o molde Carro
//  |     └── nome da variavel (como voce vai se referir a esse carro)
//  └── tipo (qual classe esse objeto segue)
```

Pode criar quantos quiser a partir do mesmo molde:

```java
Carro carroDoLuiz = new Carro();
Carro carroDoTioPatinhas = new Carro();
// Dois objetos diferentes, mesma classe
```

### O que sao atributos?

Sao os **dados que o objeto guarda**. O que ele TEM.

```java
public class Carro {
    private String cor;           // dado: qual a cor
    private String modelo;        // dado: qual o modelo
    private int velocidade;       // dado: velocidade atual
}
```

Cada `private String cor;` e um atributo. O carro TEM cor, TEM modelo, TEM velocidade.

### O que sao metodos?

Sao as **acoes que o objeto faz**. Em JavaScript voce chamaria de "funcao", mas em Java todo metodo pertence a uma classe.

```java
public class Carro {
    private int velocidade;

    // METODO — uma acao que o carro sabe fazer
    public void acelerar() {         // void = nao retorna nada, so faz algo
        velocidade = velocidade + 10;
    }

    public int getVelocidade() {     // int = retorna um numero inteiro
        return velocidade;           // return = devolve o valor
    }
}
```

Em JavaScript seria:

```javascript
function acelerar() { velocidade += 10; }   // funcao solta
```

Em Java nao existe funcao solta. O metodo sempre esta dentro de uma classe.

### Tipos de dados

Todo atributo e todo metodo tem um tipo. Esses sao os que usamos:

| Tipo | O que guarda | Exemplo de uso |
|---|---|---|
| `int` | Numero inteiro | `private int id = 1;` |
| `double` | Numero com decimais | `private double preco = 1500.50;` |
| `boolean` | Verdadeiro ou falso | `private boolean lido = false;` |
| `String` | Texto | `private String nome = "Bitcoin";` |
| `LocalDate` | Data (sem hora) | `LocalDate.of(2026, 4, 15)` |
| `LocalDateTime` | Data com hora | `LocalDateTime.now()` |
| `List<X>` | Lista de coisas do tipo X | `List<String> nomes = new ArrayList<>();` |

### O que e `private` e `public`?

Sao **modificadores de acesso**. Controlam quem pode mexer no atributo ou metodo.

```java
public class Carro {
    private String cor;              // PRIVATE — so o proprio Carro acessa

    public String getCor() {         // PUBLIC — qualquer um pode chamar
        return cor;
    }

    public void setCor(String cor) { // PUBLIC — qualquer um pode chamar
        this.cor = cor;
    }
}
```

```java
// EM OUTRA CLASSE:
Carro c = new Carro();
c.cor = "vermelho";          // ERRO! cor e private, nao pode acessar direto
c.setCor("vermelho");        // OK! setCor e public
String x = c.getCor();       // OK! getCor e public. x = "vermelho"
```

A regra e: **atributos sempre `private`**, acesso sempre via **getter** (pegar) e **setter** (alterar). Isso se chama **encapsulamento**.

### O que e um construtor?

E um metodo especial que **cria o objeto**. Tem o mesmo nome da classe e nao tem tipo de retorno:

```java
public class Carro {
    private String cor;
    private String modelo;

    // CONSTRUTOR VAZIO — cria carro sem dados
    public Carro() {
    }

    // CONSTRUTOR COM PARAMETROS — cria carro ja preenchido
    public Carro(String cor, String modelo) {
        this.cor = cor;
        this.modelo = modelo;
    }
}
```

```java
// Usando o construtor vazio:
Carro c1 = new Carro();
c1.setCor("vermelho");       // preenche depois

// Usando o construtor com parametros:
Carro c2 = new Carro("azul", "Civic");    // ja cria preenchido
```

### O que e `this`?

Significa "eu mesmo". Serve pra diferenciar o atributo da classe do parametro que tem o mesmo nome:

```java
public Carro(String cor, String modelo) {
    this.cor = cor;
    //  ^       ^
    //  |       └── "cor" que me passaram como parametro
    //  └── "cor" que e MEU atributo
    this.modelo = modelo;
}
```

Sem `this`, o Java nao saberia qual `cor` voce ta falando — o parametro ou o atributo.

### O que e `@Override` e `toString`?

Quando voce "imprime" um objeto, o Java chama o metodo `toString()`. Se voce nao criar o seu, ele imprime um codigo estranho tipo `Carro@1a2b3c`. Pra mostrar algo util, voce sobrescreve:

```java
@Override                                   // "estou substituindo o toString padrao"
public String toString() {
    return "Carro{cor=" + cor + ", modelo=" + modelo + "}";
}
// Agora ao imprimir: "Carro{cor=azul, modelo=Civic}"
```

### O que e um enum?

Uma classe especial com **valores fixos**. Use quando as opcoes sao predefinidas e nunca mudam:

```java
public enum Tamanho {
    PEQUENO,
    MEDIO,
    GRANDE
}
```

```java
// Usando:
Tamanho t = Tamanho.MEDIO;    // so pode ser um dos tres
```

No Cyphin usamos pra perfil de risco (CONSERVADOR, MODERADO, ARROJADO) e tipo de alerta.

### O que e `List` e `ArrayList`?

`List` e o conceito de "uma lista de coisas". `ArrayList` e a lista que realmente funciona. Sempre criamos assim:

```java
List<String> nomes = new ArrayList<>();
// "Uma lista que so aceita Strings, comecando vazia"

nomes.add("Luiz");           // adiciona no final → ["Luiz"]
nomes.add("Patinhas");       // adiciona no final → ["Luiz", "Patinhas"]
nomes.get(0);                // pega o primeiro → "Luiz" (posicoes comecam em 0)
nomes.get(1);                // pega o segundo → "Patinhas"
nomes.size();                // quantos itens → 2
nomes.isEmpty();             // ta vazia? → false
```

### O que e `for-each`?

Um jeito de percorrer todos os itens de uma lista, um por um:

```java
List<String> nomes = new ArrayList<>();
nomes.add("Luiz");
nomes.add("Patinhas");
nomes.add("Fernanda");

for (String nome : nomes) {       // pra cada String (que chamei de "nome") dentro de "nomes"...
    System.out.println(nome);      // imprime o nome
}
// Saida:
// Luiz
// Patinhas
// Fernanda
```

Em JavaScript seria: `for (const nome of nomes) { console.log(nome); }`

---

## Parte 2 — As classes do Cyphin (da mais simples pra mais complexa)

Agora que voce conhece todos os conceitos, vamos ver cada classe. A ordem vai do mais simples pro mais complexo — cada uma usa coisas que a anterior ja mostrou.

---

### 1. Empresa.java — a mais simples

**Por que existe:** O Tio Patinhas tem varias empresas de onde envia dinheiro pros investimentos. Precisamos guardar os dados de cada empresa.

**Por que criou dessa forma:** E a classe mais basica possivel — so guarda dados (id, nome, cnpj, descricao). Nao faz nenhum calculo.

```java
public class Empresa {

    // ATRIBUTOS — o que toda empresa tem
    private int id;                             // numero unico pra identificar
    private String nome;                        // ex: "Patinhas Mineracao"
    private String cnpj;                        // CNPJ
    private String descricao;                   // descricao livre

    // CONSTRUTOR VAZIO — cria empresa sem dados (preenche depois com setters)
    public Empresa() {
    }

    // CONSTRUTOR COM DADOS — cria empresa ja preenchida
    public Empresa(int id, String nome, String cnpj, String descricao) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.descricao = descricao;
    }

    // GETTERS E SETTERS — caminho pra acessar os atributos private
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    // TOSTRING — como a empresa aparece quando impressa
    @Override
    public String toString() {
        return "Empresa{id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + "}";
    }
    // Saida: "Empresa{id=1, nome=Patinhas Mineracao, cnpj=12345678000100}"
}
```

**Padrao importante:** TODAS as classes seguem essa mesma estrutura (atributos → construtores → metodos → getters/setters → toString). As proximas so adicionam metodos de negocio.

---

### 2. PerfilRisco.java — enum simples

**Por que existe:** No Cyphin, o usuario responde um questionario e e classificado como conservador, moderado ou arrojado. Esses 3 valores sao fixos.

**Por que enum e nao classe?** Ninguem vai inventar um quarto perfil em tempo de execucao. O enum garante que so existem essas 3 opcoes.

```java
public enum PerfilRisco {
    // Os 3 valores possiveis. Cada um recebe descricao e percentual sugerido em cripto:
    CONSERVADOR("Conservador", 0.10),           // ate 10% em cripto
    MODERADO("Moderado", 0.30),                 // ate 30%
    ARROJADO("Arrojado", 0.50);                 // ate 50%

    private final String descricao;             // "final" = nunca muda depois de criado
    private final double percentualCriptoSugerido;

    // Construtor — chamado automaticamente pra cada valor acima
    PerfilRisco(String descricao, double percentualCriptoSugerido) {
        this.descricao = descricao;
        this.percentualCriptoSugerido = percentualCriptoSugerido;
    }

    // So getters — sem setters porque valores de enum nao mudam
    public String getDescricao() { return descricao; }
    public double getPercentualCriptoSugerido() { return percentualCriptoSugerido; }
}
// Como usar: PerfilRisco.CONSERVADOR
```

---

### 3. TipoAlerta.java — enum simples

**Por que existe:** Os tipos de alerta do sistema tambem sao fixos e predefinidos.

```java
public enum TipoAlerta {
    QUEDA_PRECO("Queda de preco"),              // ex: "Bitcoin caiu 15%"
    ALTA_PRECO("Alta de preco"),                // ex: "Ethereum subiu 20%"
    META_ATINGIDA("Meta atingida"),             // ex: "Voce atingiu R$ 30.000!"
    REBALANCEAMENTO("Sugestao de rebalanceamento"),
    OPORTUNIDADE("Oportunidade de aporte");

    private final String descricao;

    TipoAlerta(String descricao) { this.descricao = descricao; }
    public String getDescricao() { return descricao; }
}
```

---

### 4. Cotacao.java — classe simples com um calculo

**Por que existe:** O preco de um cripto muda toda hora. Precisamos guardar o preco em reais e dolares num momento especifico pra montar historico.

```java
import java.time.LocalDateTime;

public class Cotacao {

    private int id;
    private double valorBrl;                    // preco em reais (ex: 350000.00)
    private double valorUsd;                    // preco em dolares (ex: 65000.00)
    private LocalDateTime dataHora;             // quando esse preco foi registrado

    public Cotacao() { }

    public Cotacao(int id, double valorBrl, double valorUsd, LocalDateTime dataHora) {
        this.id = id;
        this.valorBrl = valorBrl;
        this.valorUsd = valorUsd;
        this.dataHora = dataHora;
    }

    // METODO DE NEGOCIO — compara com outra cotacao e calcula variacao
    public double getVariacaoPercentual(Cotacao outra) {
        if (outra.getValorBrl() == 0) {         // evita divisao por zero
            return 0;
        }
        return ((this.valorBrl - outra.getValorBrl()) / outra.getValorBrl()) * 100;
        // Formula: (novo - antigo) / antigo * 100
        // Ex: this = R$ 120, outra = R$ 100 → (120-100)/100*100 = +20%
    }

    // Getters e Setters (mesmo padrao da Empresa)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public double getValorBrl() { return valorBrl; }
    public void setValorBrl(double valorBrl) { this.valorBrl = valorBrl; }
    public double getValorUsd() { return valorUsd; }
    public void setValorUsd(double valorUsd) { this.valorUsd = valorUsd; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    @Override
    public String toString() {
        return "Cotacao{valorBrl=" + valorBrl + ", valorUsd=" + valorUsd +
                ", dataHora=" + dataHora + "}";
    }
}
```

---

### 5. Alerta.java — classe com enum e boolean

**Por que existe:** No escopo do Cyphin, o sistema envia notificacoes contextualizadas pro usuario (ex: "ETH caiu 15%, pode ser bom momento pra comprar"). Cada notificacao e um Alerta.

```java
import java.time.LocalDateTime;

public class Alerta {

    private int id;
    private TipoAlerta tipoAlerta;              // usa o enum TipoAlerta que criamos antes
    private String mensagem;                    // texto do alerta
    private LocalDateTime dataGeracao;          // quando foi criado
    private boolean lido;                       // ja leu? true = sim, false = nao

    public Alerta() {
        this.lido = false;                      // todo alerta novo comeca como nao lido
    }

    public Alerta(int id, TipoAlerta tipoAlerta, String mensagem, LocalDateTime dataGeracao) {
        this.id = id;
        this.tipoAlerta = tipoAlerta;
        this.mensagem = mensagem;
        this.dataGeracao = dataGeracao;
        this.lido = false;
    }

    // METODO DE NEGOCIO — marca como lido
    // Por que nao usar setLido(true) direto? Poderia. Mas marcarComoLido()
    // e mais claro — outro programador lendo o codigo entende a intencao na hora.
    public void marcarComoLido() {
        this.lido = true;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public TipoAlerta getTipoAlerta() { return tipoAlerta; }
    public void setTipoAlerta(TipoAlerta tipoAlerta) { this.tipoAlerta = tipoAlerta; }
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
    public LocalDateTime getDataGeracao() { return dataGeracao; }
    public void setDataGeracao(LocalDateTime dataGeracao) { this.dataGeracao = dataGeracao; }
    public boolean isLido() { return lido; }    // boolean usa "is" em vez de "get" (convencao Java)
    public void setLido(boolean lido) { this.lido = lido; }

    @Override
    public String toString() {
        return "Alerta{id=" + id + ", tipo=" + tipoAlerta +
                ", mensagem=" + mensagem + ", lido=" + lido + "}";
    }
}
```

---

### 6. CriptoAtivo.java — classe com lista e logica

**Por que existe:** Representa uma criptomoeda (Bitcoin, Ethereum, etc). Cada cripto tem um historico de precos (lista de cotacoes).

**Por que tem List<Cotacao>?** O preco muda toda hora. Guardamos o historico pra saber o preco atual e calcular variacao.

```java
import java.util.ArrayList;
import java.util.List;

public class CriptoAtivo {

    private int id;
    private String nome;                        // ex: "Bitcoin"
    private String sigla;                       // ex: "BTC"
    private String descricao;
    private List<Cotacao> historicoCotacoes;     // lista de precos ao longo do tempo

    public CriptoAtivo() {
        this.historicoCotacoes = new ArrayList<>();  // cria lista vazia
    }

    public CriptoAtivo(int id, String nome, String sigla, String descricao) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.descricao = descricao;
        this.historicoCotacoes = new ArrayList<>();
    }

    // Adiciona nova cotacao ao historico
    public void adicionarCotacao(Cotacao cotacao) {
        this.historicoCotacoes.add(cotacao);     // .add() coloca no final da lista
    }

    // Pega a cotacao mais recente (ultima da lista)
    public Cotacao getCotacaoAtual() {
        if (historicoCotacoes.isEmpty()) {       // se a lista ta vazia...
            return null;                        // retorna "nada"
        }
        return historicoCotacoes.get(historicoCotacoes.size() - 1);
        // .size() = quantos itens tem. .get(posicao) = pega item naquela posicao
        // Posicoes comecam em 0, entao o ultimo e size() - 1
        // Ex: lista com 5 itens → posicoes 0,1,2,3,4 → ultimo = 5 - 1 = 4
    }

    // Atalho: retorna o preco em reais direto (sem precisar lidar com o objeto Cotacao)
    public double getPrecoAtualBrl() {
        Cotacao cotacao = getCotacaoAtual();
        if (cotacao == null) {                  // se nao tem cotacao nenhuma
            return 0;
        }
        return cotacao.getValorBrl();           // chama o getter da Cotacao
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSigla() { return sigla; }
    public void setSigla(String sigla) { this.sigla = sigla; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public List<Cotacao> getHistoricoCotacoes() { return historicoCotacoes; }

    @Override
    public String toString() {
        return "CriptoAtivo{id=" + id + ", nome=" + nome + ", sigla=" + sigla + "}";
    }
}
```

---

### 7. Aporte.java — classe que usa outra classe pra calcular

**Por que existe:** Cada vez que o usuario compra cripto, registra um aporte. O aporte sabe o que comprou, quanto pagou e quando — e calcula lucro/rentabilidade.

**Por que tem um atributo CriptoAtivo?** Porque o aporte precisa saber QUAL cripto foi comprado pra buscar o preco atual e calcular o valor de hoje.

```java
import java.time.LocalDate;

public class Aporte {

    private int id;
    private CriptoAtivo criptoAtivo;            // qual cripto comprou (objeto, nao texto)
    private double quantidade;                  // ex: 0.1 BTC
    private double valorInvestido;              // ex: R$ 5.000
    private double precoUnitarioNaCompra;       // preco de 1 unidade no dia (ex: R$ 50.000 por BTC)
    private LocalDate dataAporte;               // data da compra

    public Aporte() { }

    public Aporte(int id, CriptoAtivo criptoAtivo, double quantidade,
                  double valorInvestido, double precoUnitarioNaCompra, LocalDate dataAporte) {
        this.id = id;
        this.criptoAtivo = criptoAtivo;
        this.quantidade = quantidade;
        this.valorInvestido = valorInvestido;
        this.precoUnitarioNaCompra = precoUnitarioNaCompra;
        this.dataAporte = dataAporte;
    }

    // Quanto esse aporte vale HOJE
    public double calcularValorAtual() {
        return quantidade * criptoAtivo.getPrecoAtualBrl();
        // Aqui o Aporte chama um metodo do CriptoAtivo pra saber o preco atual
        // Ex: 0.1 BTC * R$ 70.000 = R$ 7.000
    }

    // Percentual de lucro ou prejuizo
    public double calcularRentabilidade() {
        double valorAtual = calcularValorAtual();
        if (valorInvestido == 0) { return 0; }  // evita divisao por zero
        return ((valorAtual - valorInvestido) / valorInvestido) * 100;
        // Ex: (7000 - 5000) / 5000 * 100 = 40%
    }

    // Lucro em reais
    public double calcularLucro() {
        return calcularValorAtual() - valorInvestido;
        // Ex: 7000 - 5000 = R$ 2.000
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public CriptoAtivo getCriptoAtivo() { return criptoAtivo; }
    public void setCriptoAtivo(CriptoAtivo criptoAtivo) { this.criptoAtivo = criptoAtivo; }
    public double getQuantidade() { return quantidade; }
    public void setQuantidade(double quantidade) { this.quantidade = quantidade; }
    public double getValorInvestido() { return valorInvestido; }
    public void setValorInvestido(double valorInvestido) { this.valorInvestido = valorInvestido; }
    public double getPrecoUnitarioNaCompra() { return precoUnitarioNaCompra; }
    public void setPrecoUnitarioNaCompra(double precoUnitarioNaCompra) { this.precoUnitarioNaCompra = precoUnitarioNaCompra; }
    public LocalDate getDataAporte() { return dataAporte; }
    public void setDataAporte(LocalDate dataAporte) { this.dataAporte = dataAporte; }

    @Override
    public String toString() {
        return "Aporte{id=" + id + ", cripto=" + criptoAtivo.getSigla() +
                ", quantidade=" + quantidade + ", valorInvestido=" + valorInvestido + "}";
    }
}
```

---

### 8. Carteira.java — classe com lista e for-each

**Por que existe:** Um usuario tem varias carteiras (portfolios). Ex: uma pessoal, uma da empresa X, uma da empresa Y. Cada carteira contem varios aportes.

**Por que tem Empresa?** Requisito do PO: "possui varias empresas nas quais ele pode enviar valores para investimentos." Cada carteira pode ser financiada por uma empresa.

```java
import java.util.ArrayList;
import java.util.List;

public class Carteira {

    private int id;
    private String nome;                        // ex: "Carteira Pessoal"
    private String descricao;
    private Empresa empresa;                    // empresa que financia (ou null se for pessoal)
    private List<Aporte> aportes;               // lista de investimentos dessa carteira

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

    // Soma o valor atual de TODOS os aportes
    public double calcularValorAtual() {
        double total = 0;
        for (Aporte aporte : aportes) {         // pra cada aporte na lista...
            total += aporte.calcularValorAtual(); // soma o valor atual dele
            // "+=" significa "total = total + valor"
        }
        return total;
        // Ex: 3 aportes valendo R$ 7.000, R$ 3.000 e R$ 5.000
        // total = 0 + 7000 + 3000 + 5000 = R$ 15.000
    }

    // Soma quanto foi investido no total
    public double calcularTotalInvestido() {
        double total = 0;
        for (Aporte aporte : aportes) {
            total += aporte.getValorInvestido();
        }
        return total;
    }

    // Rentabilidade geral da carteira
    public double calcularRentabilidade() {
        double totalInvestido = calcularTotalInvestido();
        if (totalInvestido == 0) { return 0; }
        double valorAtual = calcularValorAtual();
        return ((valorAtual - totalInvestido) / totalInvestido) * 100;
        // Ex: investiu R$ 10.000, vale R$ 15.000
        // (15000-10000)/10000*100 = 50%
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Empresa getEmpresa() { return empresa; }
    public void setEmpresa(Empresa empresa) { this.empresa = empresa; }
    public List<Aporte> getAportes() { return aportes; }

    @Override
    public String toString() {
        return "Carteira{id=" + id + ", nome=" + nome + ", aportes=" + aportes.size() + "}";
        // .size() mostra quantos aportes tem, nao a lista inteira
    }
}
```

---

### 9. Meta.java — classe que depende de outra pra calcular

**Por que existe:** No escopo, o Cyphin tem simulador de metas. O usuario define um objetivo (ex: "juntar R$ 30.000 em 18 meses") e o sistema acompanha.

**Por que referencia Carteira?** A meta precisa saber o valor atual da carteira pra calcular progresso. Sem isso, nao saberia "quanto ja tenho".

```java
import java.time.LocalDate;

public class Meta {

    private int id;
    private String descricao;                   // ex: "Dar entrada no apartamento"
    private double valorAlvo;                   // quanto quer atingir (ex: 30000.00)
    private int prazoMeses;                     // prazo (ex: 18 meses)
    private LocalDate dataCriacao;              // quando criou a meta
    private Carteira carteira;                  // qual carteira acompanha

    public Meta() { }

    public Meta(int id, String descricao, double valorAlvo, int prazoMeses,
                LocalDate dataCriacao, Carteira carteira) {
        this.id = id;
        this.descricao = descricao;
        this.valorAlvo = valorAlvo;
        this.prazoMeses = prazoMeses;
        this.dataCriacao = dataCriacao;
        this.carteira = carteira;
    }

    // Quanto % da meta ja foi atingido
    public double calcularProgresso() {
        if (valorAlvo == 0) { return 0; }
        double valorAtual = carteira.calcularValorAtual();
        return (valorAtual / valorAlvo) * 100;
        // Ex: carteira vale R$ 18.000, meta R$ 30.000
        // 18000/30000*100 = 60%
    }

    // Ja bateu a meta?
    public boolean isAtingida() {
        return carteira.calcularValorAtual() >= valorAlvo;
        // ">=" = maior ou igual
        // Retorna true se ja atingiu, false se ainda nao
    }

    // Quanto precisa investir por mes pra bater a meta
    public double calcularAporteMensalNecessario() {
        double valorAtual = carteira.calcularValorAtual();
        double faltante = valorAlvo - valorAtual;
        if (faltante <= 0 || prazoMeses <= 0) { return 0; }
        // "||" = OU. Se ja atingiu OU prazo invalido, retorna 0
        return faltante / prazoMeses;
        // Ex: faltam R$ 12.000, prazo 12 meses → R$ 1.000/mes
    }

    // Data limite pra atingir a meta
    public LocalDate getDataLimite() {
        return dataCriacao.plusMonths(prazoMeses);
        // .plusMonths() soma meses a uma data
        // Ex: criou 2026-01-01, prazo 18 meses → 2027-07-01
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public double getValorAlvo() { return valorAlvo; }
    public void setValorAlvo(double valorAlvo) { this.valorAlvo = valorAlvo; }
    public int getPrazoMeses() { return prazoMeses; }
    public void setPrazoMeses(int prazoMeses) { this.prazoMeses = prazoMeses; }
    public LocalDate getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }
    public Carteira getCarteira() { return carteira; }
    public void setCarteira(Carteira carteira) { this.carteira = carteira; }

    @Override
    public String toString() {
        return "Meta{id=" + id + ", descricao=" + descricao + ", valorAlvo=" + valorAlvo + "}";
    }
}
```

---

### 10. Usuario.java — a classe central que conecta tudo

**Por que existe:** Representa o investidor (Tio Patinhas, Lucas, Fernanda). E o ponto central — conecta carteiras, empresas, metas e alertas.

**Por que tantas listas?** Porque o PO tem varias empresas, varias carteiras, varias metas e recebe varios alertas. Cada relacao "tem varios" vira uma List.

```java
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
    private PerfilRisco perfilRisco;             // enum (CONSERVADOR, MODERADO, ARROJADO)
    private List<Carteira> carteiras;            // suas carteiras/portfolios
    private List<Empresa> empresas;              // suas empresas
    private List<Meta> metas;                    // suas metas financeiras
    private List<Alerta> alertas;                // suas notificacoes

    public Usuario() {
        this.carteiras = new ArrayList<>();      // cria listas vazias
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

    // Metodos pra adicionar itens nas listas
    // As listas sao private, entao esses metodos sao o unico caminho
    public void adicionarCarteira(Carteira carteira) { this.carteiras.add(carteira); }
    public void adicionarEmpresa(Empresa empresa) { this.empresas.add(empresa); }
    public void adicionarMeta(Meta meta) { this.metas.add(meta); }
    public void adicionarAlerta(Alerta alerta) { this.alertas.add(alerta); }

    // Patrimonio total = soma do valor de todas as carteiras
    public double calcularPatrimonioTotal() {
        double total = 0;
        for (Carteira carteira : carteiras) {
            total += carteira.calcularValorAtual();
        }
        return total;
        // Cadeia de chamadas que acontece por baixo:
        // Usuario.calcularPatrimonioTotal()
        //   └── Carteira.calcularValorAtual()
        //         └── Aporte.calcularValorAtual()
        //               └── CriptoAtivo.getPrecoAtualBrl()
        //                     └── Cotacao.getValorBrl()
        // Cada classe cuida da sua parte. Isso e orientacao a objetos.
    }

    // Conta alertas nao lidos
    public int getAlertasNaoLidos() {
        int count = 0;
        for (Alerta alerta : alertas) {
            if (!alerta.isLido()) {              // "!" = negacao. "se NAO foi lido"
                count++;                         // soma 1
            }
        }
        return count;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public PerfilRisco getPerfilRisco() { return perfilRisco; }
    public void setPerfilRisco(PerfilRisco perfilRisco) { this.perfilRisco = perfilRisco; }
    public List<Carteira> getCarteiras() { return carteiras; }
    public List<Empresa> getEmpresas() { return empresas; }
    public List<Meta> getMetas() { return metas; }
    public List<Alerta> getAlertas() { return alertas; }

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nome=" + nome + ", email=" + email +
                ", perfilRisco=" + perfilRisco + "}";
    }
}
```

---

## Parte 3 — Como tudo se conecta

```
Usuario (investidor)
│
├── tem 1 PerfilRisco (conservador/moderado/arrojado)
│
├── possui varias Empresas (de onde vem o dinheiro)
│
├── possui varias Carteiras (portfolios)
│   │
│   ├── pode ser financiada por 1 Empresa
│   │
│   └── contem varios Aportes (investimentos)
│       │
│       └── cada aporte e de 1 CriptoAtivo
│           │
│           └── cada cripto tem varias Cotacoes (historico de precos)
│
├── define varias Metas (objetivos financeiros)
│   └── cada meta acompanha 1 Carteira
│
└── recebe varios Alertas (notificacoes)
    └── cada alerta tem 1 TipoAlerta
```

---

## Parte 4 — Duvidas e anotacoes

### Metodos em Java vs funcoes em JavaScript

Em Java nao existe a palavra `function`. O que define um metodo e o **tipo de retorno**:

```javascript
// JS
function calcularLucro() { return 2000; }
```

```java
// Java — o tipo (double) fica onde estaria "function"
public double calcularLucro() { return 2000; }
```

- `double`, `int`, `String`, etc. = retorna algo desse tipo
- `void` = nao retorna nada (so executa uma acao)
