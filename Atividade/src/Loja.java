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
    public void receberPecas(int quantidade) {
        if (quantidade > 0) {
            quantidadePecas += quantidade;
            System.out.println(quantidade + " peças recebidas na " + nome + ".");
        }
    }

    public boolean venderPecas(int quantidade) {
        if (quantidade > 0 && quantidade <= quantidadePecas) {
            quantidadePecas -= quantidade;
            System.out.println(quantidade + " peças vendidas.");
            return true;
        }
        System.out.println("Estoque insuficiente para vender " + quantidade + " peças.");
        return false;
    }

    public void exibirSituacao() {
        System.out.println("Loja " + nome + " (" + cidade + ") - Estoque: " + quantidadePecas + " peças");
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
}
