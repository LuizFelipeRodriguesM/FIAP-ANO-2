# Cyphin — FIAP PBL 2026

## Sobre o projeto

Este repo organiza as entregas do PBL (Problem Based Learning) da FIAP, 2o ano de Engenharia de Software (EAD), 2026.

**Projeto:** Cyphin — copiloto financeiro com IA para investidores de criptoativos.
**Cenario ficticio:** Empresa VOLTZ recebeu pedido do Tio Patinhas (PO) para construir sistema web de investimentos em cripto.
**Grupo:** 89

| Nome | RM |
|---|---|
| Luiz Felipe Rodrigues Machado | RM32738 |
| Vitor Gomes | RM561317 |
| Pedro Sato | RM564859 |
| Felipe Wunder | RM561366 |

## Estrutura do repo

```
fase-N/
├── enunciado.md    # o que a FIAP pediu
├── entrega.md      # o que o grupo entregou
├── explicacao.md    # explicacao detalhada (quando aplicavel)
├── TODO.md          # checklist de entrega (quando aplicavel)
└── ...              # arquivos da entrega (classes, diagramas, etc)
```

- Cada ano tem **7 fases**, cada uma com uma entrega diferente
- O projeto Cyphin e o mesmo o ano todo, muda o que e entregue em cada fase
- Sempre salvar **enunciado** (o que pediram) e **entrega** (o que fizemos) separados

## Requisitos do PO (Tio Patinhas)

1. Investir em criptoativos de maneira online
2. Acompanhamento diario dos investimentos
3. Seguranca dos dados e valores trafegados em rede
4. Possui varias empresas de onde envia valores para investimentos
5. Acesso exclusivamente via sistema WEB (nao confia em app)

## Progresso

- **Fase 1:** Entregue (14/03/2026) — Escopo do Produto (problema, publico-alvo, solucao)
- **Fase 2:** Em andamento — Classes Java + Diagrama de Classes + Pitch Video (3 min)
- **Fases 3-7:** Pendentes

## Como trabalhar neste repo

### Ao receber conteudo de uma nova fase:
1. Salvar o enunciado em `fase-N/enunciado.md`
2. Criar TODO.md com checklist baseado nos entregaveis
3. Implementar os entregaveis na pasta `fase-N/`
4. Salvar a entrega final em `fase-N/entrega.md`

### Sobre o usuario:
- Luiz Felipe nao tem experiencia com Java — explicar decisoes de codigo de forma didatica
- Comparacoes com JavaScript ajudam (ele tem familiaridade basica com JS)
- Quando criar arquivos de explicacao, organizar de forma linear (conceito → codigo → exemplo) sem exigir pulos no texto
- Evitar overengineering: manter o nivel tecnico compativel com 2o ano de faculdade
- Nao usar features avancadas de Java que ainda nao foram ensinadas (streams, generics complexos, Map, method references, design patterns)

### Nivel tecnico adequado para as entregas:
- Java basico: classes, atributos, metodos, construtores, encapsulamento (private + getters/setters)
- Tipos: int, double, boolean, String, LocalDate, LocalDateTime
- Colecoes: List + ArrayList com generics simples
- Enums basicos
- for-each para iterar listas
- Evitar: HashMap, streams, lambdas, method references, constructor chaining com this(), ternarios, String.format
