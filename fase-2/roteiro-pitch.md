# Roteiro — Pitch Video Fase 2

**Duracao:** ~1:40 - 2:00
**Formato:** gravacao de tela dos slides (pitch-slides.html) com narracao por cima. Take unico, sem corte.
**Gravacao:** qualquer integrante do grupo pode narrar — trabalho foi coletivo.

---

## Setup

- Abrir `fase-2/pitch-slides.html` em tela cheia (F11 no Chrome)
- Gravar com OBS, Loom ou compartilhamento de tela do Google Meet
- Avancar slides com seta direita ou espaco
- 4 slides no total — 1 por momento do roteiro

| Slide | Momento |
|---|---|
| 1 | Abertura — Cyphin + grupo 89 |
| 2 | Gap de mercado + o que o Cyphin resolve |
| 3 | Modelagem em Java — 8 classes + 2 enums |
| 4 | Fechamento — controle e inteligencia |

---

## Fala

### Slide 1 — Abertura (0:00 - 0:12)

> Ola, somos o grupo 89, e este e o pitch do **Cyphin**: o copiloto financeiro com inteligencia artificial para criptoativos.

### Slide 2 — Gap e Solucao (0:12 - 0:40)

> Hoje, as exchanges mostram apenas preco e saldo. Aplicativos tradicionais ignoram cripto. E plataformas famosas sao genericas — elas nao conhecem a sua carteira.
>
> O Cyphin preenche exatamente esse gap. Nossa plataforma web da inteligencia personalizada para o investidor pessoa fisica, baseada no perfil de risco dele e nos dados reais do seu portfolio em tempo real.

### Slide 3 — Modelagem em Java (0:40 - 1:40)

> Para tirar essa inteligencia do papel e garantir as entregas da Fase 1, desenvolvemos nossa modelagem em Java com **8 classes e 2 Enums**. Tudo orbita em torno de uma classe principal:
>
> - O **Usuario**. E nele que vinculamos o enum **PerfilRisco** (Conservador, Moderado ou Arrojado). E esse perfil que dita como a nossa inteligencia artificial vai agir.
>
> - Esse usuario organiza seu dinheiro em **Carteiras**, que podem estar vinculadas a diferentes **Empresas** de onde ele envia os valores.
>
> - Dentro das carteiras, temos a classe **Aportes**, que e o motor do sistema. Ela cruza o que foi comprado com o historico da classe **Cotacoes** (em real e dolar) do **CriptoAtivo**. E aqui que calculamos a rentabilidade real e tiramos o investidor da ilusao de preco.
>
> - Por fim, para evitar que o usuario "invista no escuro", criamos as classes **Metas** e **Alertas**. A meta calcula o que falta para o objetivo, e o Alerta (baseado no enum **TipoAlerta**) avisa sobre oportunidades de aporte ou quedas bruscas.

### Slide 4 — Fechamento (1:40 - 2:00)

> Nossa arquitetura em Java mapeia e resolve uma necessidade direta do produto validada na Fase 1, entregando controle e inteligencia para quem investe.
