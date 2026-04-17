# Roteiro — Pitch Video Fase 2

**Duracao:** ~1:40 - 2:00
**Formato:** gravacao de tela (Google Slides / Canva) com voce narrando por cima. Webcam no canto opcional. Sem cortes, take unico.

---

## Setup

- Montar **3 slides** num Canva ou Google Slides
- Gravar com OBS, Loom ou o proprio Google Meet (compartilhar tela + gravar)
- Nao precisa editar: e um take so, passando os slides enquanto fala

| Slide | Conteudo |
|---|---|
| 1 | Nome "Cyphin", subtitulo "Copiloto financeiro com IA para cripto", nome do grupo e RMs |
| 2 | Titulo "O Problema" + 3 bullet points curtos (investidor no escuro / exchanges so mostram preco / ninguem oferece inteligencia) |
| 3 | Diagrama de classes (imagem do `diagrama-classes.png`) |

---

## Fala

### Slide 1 (0:00 - 0:15)

> Ola, meu nome e Luiz Felipe, grupo 89, e esse e o pitch do Cyphin.
>
> O Cyphin e um copiloto financeiro com inteligencia artificial pra investidores de criptoativos. Uma plataforma web onde o usuario registra seus aportes, acompanha o portfolio em tempo real e recebe analises personalizadas.

### Slide 2 (0:15 - 0:40)

> Na Fase 1 a gente identificou que o Brasil tem mais de 10 milhoes de investidores em cripto, e a maioria investe no escuro. Compra por impulso, vende por panico, nao sabe quanto ganhou ou perdeu de verdade.
>
> As exchanges mostram preco e saldo, nada mais. Os apps financeiros nem reconhecem cripto. E plataformas como CoinGecko sao genericas — nao conhecem o portfolio do usuario.
>
> O Cyphin preenche esse gap: da inteligencia personalizada pro investidor pessoa fisica, com base no perfil de risco dele e nos dados reais da carteira.

### Slide 3 — diagrama (0:40 - 1:45)

> Agora a modelagem em Java. Sao 8 classes e 2 enums.
>
> O centro de tudo e o **Usuario**. Ele tem dados pessoais e um **PerfilRisco** — um enum com tres niveis: conservador, moderado e arrojado.
>
> O Usuario possui **Empresas**, porque o PO tem varias empresas de onde envia valores pra investimento. E ele organiza esses investimentos em **Carteiras**. Cada carteira pode estar vinculada a uma empresa.
>
> Dentro da carteira ficam os **Aportes** — o registro do investimento: qual cripto comprou, quanto pagou e quando. O aporte referencia um **CriptoAtivo**, tipo Bitcoin ou Ethereum, que tem um historico de **Cotacoes** em real e dolar. E assim o sistema calcula a rentabilidade real.
>
> O usuario tambem define **Metas** financeiras ligadas a uma carteira. A Meta calcula o progresso e quanto falta aportar por mes pra atingir o objetivo.
>
> E por ultimo, o sistema gera **Alertas** contextualizados. O enum **TipoAlerta** define as categorias: queda de preco, alta, meta atingida, oportunidade de aporte.
>
> Cada classe existe porque mapeia uma necessidade real do produto. Esse foi o Cyphin, grupo 89. Obrigado!
