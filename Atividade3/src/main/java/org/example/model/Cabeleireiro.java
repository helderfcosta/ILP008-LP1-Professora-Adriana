package org.example.model;

/** MODEL: quem cuida dos penteados (Imagem 4). Métodos devolvem texto para a tela. */
public class Cabeleireiro {
    private String nome;
    private String salao;
    private double precoBase;   // valor fixo do atendimento

    private static final double TAXA_POR_CM = 0.50;   // valor extra por cm de cabelo

    public Cabeleireiro(String nome, String salao, double precoBase) {
        this.nome = nome;
        this.salao = salao;
        setPrecoBase(precoBase);
    }

    // Métodos de negócio
    public String atender(Penteado penteado, double cmParaCortar) {
        if (penteado == null) {
            return "Escolha um penteado.";
        }
        return nome + " atendeu no salão " + salao + ".\n" + penteado.cortar(cmParaCortar);
    }

    public double calcularPreco(Penteado penteado) {
        return precoBase + penteado.getComprimentoCm() * TAXA_POR_CM;
    }

    public String apresentar() {
        return String.format("Cabeleireiro %s - salão %s - atendimento a partir de R$ %.2f", nome, salao, precoBase);
    }

    // Métodos de acesso
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSalao() { return salao; }
    public void setSalao(String salao) { this.salao = salao; }
    public double getPrecoBase() { return precoBase; }
    public void setPrecoBase(double precoBase) { this.precoBase = Math.max(0, precoBase); }

    @Override
    public String toString() {
        return apresentar();
    }
}
