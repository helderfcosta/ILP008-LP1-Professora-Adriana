package org.example.model;

/** MODEL: a loja de roupas (Imagem 1). Métodos devolvem texto para a tela. */
public class Loja {
    private String nome;
    private String cidade;
    private int quantidadePecas;

    public Loja(String nome, String cidade, int quantidadePecas) {
        this.nome = nome;
        this.cidade = cidade;
        setQuantidadePecas(quantidadePecas);
    }

    // Métodos de negócio
    public String receberPecas(int quantidade) {
        if (quantidade > 0) {
            quantidadePecas += quantidade;
            return quantidade + " peças recebidas na " + nome + ".";
        }
        return "A quantidade recebida deve ser maior que 0.";
    }

    public String venderPecas(int quantidade) {
        if (quantidade > 0 && quantidade <= quantidadePecas) {
            quantidadePecas -= quantidade;
            return quantidade + " peças vendidas.";
        }
        return "Estoque insuficiente para vender " + quantidade + " peças.";
    }

    public String exibirSituacao() {
        return "Loja " + nome + " (" + cidade + ") - Estoque: " + quantidadePecas + " peças";
    }

    // Métodos de acesso
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public int getQuantidadePecas() { return quantidadePecas; }
    public void setQuantidadePecas(int quantidadePecas) {
        this.quantidadePecas = Math.max(0, quantidadePecas);
    }

    @Override
    public String toString() {
        return exibirSituacao();
    }
}
