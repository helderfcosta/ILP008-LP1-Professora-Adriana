// IMAGEM 1 - peça de roupa exposta na loja
public class Roupa {
    private String tipo;      // ex.: "Camisa", "Terno"
    private String tamanho;   // ex.: "M", "G"
    private double preco;     // em reais

    public Roupa(String tipo, String tamanho, double preco) {
        this.tipo = tipo;
        this.tamanho = tamanho;
        setPreco(preco);
    }

    // Métodos de negócio
    public void aplicarDesconto(double percentual) {
        if (percentual > 0 && percentual <= 100) {
            preco = preco - (preco * percentual / 100);
            System.out.printf("Desconto de %.0f%% aplicado. Novo preço: R$ %.2f%n", percentual, preco);
        } else {
            System.out.println("Percentual de desconto inválido (use de 1 a 100).");
        }
    }

    public double calcularParcela(int quantidadeParcelas) {
        if (quantidadeParcelas <= 0) {
            return preco;
        }
        return preco / quantidadeParcelas;
    }

    public void exibirEtiqueta() {
        System.out.printf("[%s - Tam. %s - R$ %.2f]%n", tipo, tamanho, preco);
    }

    // Métodos de acesso
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = Math.max(0, preco); }
}
