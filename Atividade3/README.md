# Atividade 3 - Interface gráfica (JavaFX)

Projeto Maven com JavaFX, seguindo o padrão **MVC** visto em aula:

| Parte | Onde fica | Função |
|---|---|---|
| Model | `src/main/java/org/example/model` | Classes com dados e regras (adaptadas da Atividade 2) |
| View | `src/main/resources/org/example/view` | Telas em FXML |
| Controller | `src/main/java/org/example/controller` | Reage aos botões e liga a View ao Model |

A janela principal (`main.fxml`) tem uma aba para cada classe Model. Os objetos cadastrados ficam em memória (classe `Repositorio`) e são compartilhados entre as abas.

**Telas (uma aba para cada classe Model):** Loja, Roupa, Manequim, Bicicleta, Ciclista, Trilha, Máscara, Artesão, Exposição, Penteado, Rosto e Cabeleireiro.

## Como executar
Abra a pasta no IntelliJ (como projeto Maven) e execute a classe `App`.
