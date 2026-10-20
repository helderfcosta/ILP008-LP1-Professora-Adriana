package org.example.model;

/** MODEL: parede onde as máscaras ficam expostas (Imagem 3). Métodos devolvem texto para a tela. */
public class Exposicao {
    private String nome;
    private int capacidade;
    private int quantidadePecas;

    public Exposicao(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = Math.max(1, capacidade);
        this.quantidadePecas = 0;
    }

    // Métodos de negócio
    public String adicionarPeca() {
        if (quantidadePecas < capacidade) {
            quantidadePecas++;
            return "Peça adicionada à exposição " + nome + ".";
        }
        return "Exposição lotada! Capacidade: " + capacidade + ".";
    }

    public String removerPeca() {
        if (quantidadePecas > 0) {
            quantidadePecas--;
            return "Peça removida da exposição " + nome + ".";
        }
        return "Não há peças para remover.";
    }

    public String exibirOcupacao() {
        double percentual = (quantidadePecas * 100.0) / capacidade;
        return String.format("Exposição %s: %d de %d peças (%.0f%% ocupada).", nome, quantidadePecas, capacidade, percentual);
    }

    // Métodos de acesso
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getCapacidade() { return capacidade; }
    public void setCapacidade(int capacidade) { this.capacidade = Math.max(1, capacidade); }
    public int getQuantidadePecas() { return quantidadePecas; }
    public void setQuantidadePecas(int quantidadePecas) {
        this.quantidadePecas = Math.max(0, Math.min(capacidade, quantidadePecas));
    }

    @Override
    public String toString() {
        return exibirOcupacao();
    }
}
