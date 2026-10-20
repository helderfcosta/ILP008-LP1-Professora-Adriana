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
    public void cortar(double cm) {
        if (cm > 0) {
            comprimentoCm = Math.max(0, comprimentoCm - cm);
            System.out.printf("Cabelo cortado. Novo comprimento: %.1f cm%n", comprimentoCm);
        }
    }

    public void crescer(double cm) {
        if (cm > 0) {
            comprimentoCm += cm;
            System.out.printf("Cabelo cresceu. Novo comprimento: %.1f cm%n", comprimentoCm);
        }
    }

    public void pintar(String novaCor) {
        System.out.println("Cabelo pintado de " + cor + " para " + novaCor + ".");
        cor = novaCor;
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
        return "Penteado " + estilo + ", " + comprimentoCm + " cm, cor " + cor;
    }
}
