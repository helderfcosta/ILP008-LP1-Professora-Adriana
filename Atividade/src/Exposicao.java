// IMAGEM 3 - parede onde as máscaras ficam expostas
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
    public boolean adicionarPeca() {
        if (quantidadePecas < capacidade) {
            quantidadePecas++;
            System.out.println("Peça adicionada à exposição " + nome + ".");
            return true;
        }
        System.out.println("Exposição lotada! Capacidade: " + capacidade + ".");
        return false;
    }

    public boolean removerPeca() {
        if (quantidadePecas > 0) {
            quantidadePecas--;
            System.out.println("Peça removida da exposição " + nome + ".");
            return true;
        }
        System.out.println("Não há peças para remover.");
        return false;
    }

    public void exibirOcupacao() {
        double percentual = (quantidadePecas * 100.0) / capacidade;
        System.out.printf("Exposição %s: %d de %d peças (%.0f%% ocupada).%n", nome, quantidadePecas, capacidade, percentual);
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
}
