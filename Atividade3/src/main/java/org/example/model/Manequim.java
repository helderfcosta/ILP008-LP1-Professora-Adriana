package org.example.model;

/** MODEL: manequim da vitrine (Imagem 1). Métodos devolvem texto para a tela. */
public class Manequim {
    private double altura;      // em cm
    private int anguloGiro;     // 0 a 359 graus
    private Roupa roupaAtual;   // null = sem roupa

    public Manequim(double altura) {
        this.altura = Math.max(0, altura);
        this.anguloGiro = 0;
        this.roupaAtual = null;
    }

    // Métodos de negócio
    public String vestir(Roupa roupa) {
        if (roupa == null) {
            return "Nenhuma roupa informada.";
        }
        roupaAtual = roupa;
        return "Manequim vestiu: " + roupa.getTipo() + " (" + roupa.getTamanho() + ").";
    }

    public String despir() {
        if (roupaAtual == null) {
            return "O manequim já está sem roupa.";
        }
        String mensagem = "Manequim tirou: " + roupaAtual.getTipo() + ".";
        roupaAtual = null;
        return mensagem;
    }

    public String girar(int graus) {
        // o cálculo abaixo mantém o ângulo sempre entre 0 e 359
        anguloGiro = ((anguloGiro + graus) % 360 + 360) % 360;
        return "Manequim girou. Ângulo atual: " + anguloGiro + " graus.";
    }

    // Métodos de acesso
    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = Math.max(0, altura); }
    public int getAnguloGiro() { return anguloGiro; }
    public void setAnguloGiro(int anguloGiro) { this.anguloGiro = ((anguloGiro % 360) + 360) % 360; }
    public Roupa getRoupaAtual() { return roupaAtual; }
    public void setRoupaAtual(Roupa roupaAtual) { this.roupaAtual = roupaAtual; }

    @Override
    public String toString() {
        String roupa = (roupaAtual == null) ? "sem roupa" : "vestindo " + roupaAtual.getTipo();
        return String.format("Manequim %.0f cm - ângulo %d° - %s", altura, anguloGiro, roupa);
    }
}
