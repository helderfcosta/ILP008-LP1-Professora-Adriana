# ILP008 - Linguagem de Programação 1 (Java)

Repositório com as atividades da disciplina **ILP008 - LP1**, FATEC São José dos Campos, Prof. Jessen Vidal.

**Aluno:** Hélder (GitHub: [helderfcosta](https://github.com/helderfcosta))

## Estrutura do repositório

```
ILP008-LP1-Professora-Adriana/
├─ README.md
├─ Atividades-1-e-2/     projeto Java simples (IntelliJ)
│  ├─ docs/uml.md        diagrama UML das 12 classes
│  └─ src/               código-fonte
└─ Atividade3/           projeto JavaFX (interface gráfica)
```

## Atividade 1 - Exercícios Java

Sete programas, cada um em sua classe, em `Atividades-1-e-2/src`:

| # | Exercício | Classe |
|---|---|---|
| 1 | Verificação de múltiplo | `VerificacaoMultiplo` |
| 2 | Sistema de login simplificado | `SistemaLogin` |
| 3 | Compra com desconto | `CompraComDesconto` |
| 4 | Temperatura | `Temperatura` |
| 5 | Os trinta e cinco camelos | `TrintaCincoCamelos` |
| 6 | Calculadora de viagem | `CalculadoraViagem` |
| 7 | Aluguel de carro | `AluguelDeCarro` |

## Atividade 2 - Menu e classes das imagens

**Menu:** a classe `Main` exibe um menu para escolher qual exercício da Atividade 1 executar. Nenhuma outra classe possui método `main`.

**Classes das 4 imagens:** 12 classes, cada uma com 3 atributos e 3 métodos (sem contar getters e setters). A classe `Principal` instancia e testa todas.

| Imagem | Classes |
|---|---|
| 1 - Loja de roupas | `Loja`, `Roupa`, `Manequim` |
| 2 - Ciclistas na trilha | `Bicicleta`, `Ciclista`, `Trilha` |
| 3 - Máscaras africanas | `MascaraAfricana`, `Artesao`, `Exposicao` |
| 4 - Rostos e penteados | `Penteado`, `Rosto`, `Cabeleireiro` |

Diagrama UML: [Atividades-1-e-2/docs/uml.md](Atividades-1-e-2/docs/uml.md)

### Como executar

1. Abra a pasta `Atividades-1-e-2` no IntelliJ IDEA.
2. Para o menu dos exercícios, execute `Main`.
3. Para o teste das classes das imagens, execute `Principal`.

## Atividade 3 - Interface gráfica (JavaFX)

Telas (View e Controller) para as classes Model da Atividade 2, seguindo o padrão MVC visto em aula.
Pasta: [Atividade3](Atividade3)

**Status:** Finalizado.
