package org.example.model;

/** MODEL: bicicleta (Imagem 2). Métodos devolvem texto para a tela. */
public class Bicicleta {
    private String marca;
    private int marchaAtual;
    private double velocidade; // km/h

    private static final int MARCHA_MAXIMA = 21;

    public Bicicleta(String marca) {
        this.marca = marca;
        this.marchaAtual = 1;
        this.velocidade = 0;
    }

    // Métodos de negócio
    public String pedalar(double incremento) {
        if (incremento > 0) {
            velocidade += incremento * marchaAtual * 0.5;
        }
        return String.format("Pedalando... velocidade: %.1f km/h", velocidade);
    }

    public String frear() {
        velocidade = 0;
        return "Bicicleta " + marca + " parou.";
    }

    public String trocarMarcha(int novaMarcha) {
        if (novaMarcha >= 1 && novaMarcha <= MARCHA_MAXIMA) {
            marchaAtual = novaMarcha;
            return "Marcha alterada para " + marchaAtual + ".";
        }
        return "Marcha inválida (1 a " + MARCHA_MAXIMA + ").";
    }

    // Métodos de acesso
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public int getMarchaAtual() { return marchaAtual; }
    public void setMarchaAtual(int marchaAtual) { trocarMarcha(marchaAtual); }
    public double getVelocidade() { return velocidade; }
    public void setVelocidade(double velocidade) { this.velocidade = Math.max(0, velocidade); }

    @Override
    public String toString() {
        return String.format("Bicicleta %s - marcha %d - %.1f km/h", marca, marchaAtual, velocidade);
    }
}
