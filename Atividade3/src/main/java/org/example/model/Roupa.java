package org.example.model;

/**
 * MODEL: peça de roupa exposta na loja (Imagem 1).
 * Adaptação para a interface gráfica: os métodos agora DEVOLVEM um texto
 * (String) em vez de imprimir no console, para o Controller mostrar na tela.
 */
public class Roupa {
    private String tipo;
    private String tamanho;
    private double preco;

    public Roupa(String tipo, String tamanho, double preco) {
        this.tipo = tipo;
        this.tamanho = tamanho;
        setPreco(preco);
    }

    // Métodos de negócio
    public String aplicarDesconto(double percentual) {
        if (percentual > 0 && percentual <= 100) {
            preco = preco - (preco * percentual / 100);
            return String.format("Desconto de %.0f%% aplicado. Novo preço: R$ %.2f", percentual, preco);
        }
        return "Percentual de desconto inválido (use de 1 a 100).";
    }

    public double calcularParcela(int quantidadeParcelas) {
        if (quantidadeParcelas <= 0) {
            return preco;
        }
        return preco / quantidadeParcelas;
    }

    public String exibirEtiqueta() {
        return String.format("[%s - Tam. %s - R$ %.2f]", tipo, tamanho, preco);
    }

    // Métodos de acesso
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = Math.max(0, preco); }

    // É o texto que aparece na lista da tela
    @Override
    public String toString() {
        return exibirEtiqueta();
    }
}
