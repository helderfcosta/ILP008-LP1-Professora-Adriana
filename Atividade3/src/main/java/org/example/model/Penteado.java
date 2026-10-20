package org.example.model;

/** MODEL: o penteado/cabelo (Imagem 4). Métodos devolvem texto para a tela. */
public class Penteado {
    private String estilo;
    private double comprimentoCm;
    private String cor;

    public Penteado(String estilo, double comprimentoCm, String cor) {
        this.estilo = estilo;
        setComprimentoCm(comprimentoCm);
        this.cor = cor;
    }

    // Métodos de negócio
    public String cortar(double cm) {
        if (cm > 0) {
            comprimentoCm = Math.max(0, comprimentoCm - cm);
            return String.format("Cabelo cortado. Novo comprimento: %.1f cm", comprimentoCm);
        }
        return "Informe um valor maior que 0 para cortar.";
    }

    public String crescer(double cm) {
        if (cm > 0) {
            comprimentoCm += cm;
            return String.format("Cabelo cresceu. Novo comprimento: %.1f cm", comprimentoCm);
        }
        return "Informe um valor maior que 0 para crescer.";
    }

    public String pintar(String novaCor) {
        String mensagem = "Cabelo pintado de " + cor + " para " + novaCor + ".";
        cor = novaCor;
        return mensagem;
    }

    // Métodos de acesso
    public String getEstilo() { return estilo; }
    public void setEstilo(String estilo) { this.estilo = estilo; }
    public double getComprimentoCm() { return comprimentoCm; }
    public void setComprimentoCm(double comprimentoCm) { this.comprimentoCm = Math.max(0, comprimentoCm); }
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    @Override
    public String toString() {
        return String.format("Penteado %s, %.1f cm, cor %s", estilo, comprimentoCm, cor);
    }
}
