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
    public void pedalar(double incremento) {
        if (incremento > 0) {
            velocidade += incremento * marchaAtual * 0.5;
        }
        System.out.printf("Pedalando... velocidade: %.1f km/h%n", velocidade);
    }

    public void frear() {
        velocidade = 0;
        System.out.println("Bicicleta " + marca + " parou.");
    }

    public void trocarMarcha(int novaMarcha) {
        if (novaMarcha >= 1 && novaMarcha <= MARCHA_MAXIMA) {
            marchaAtual = novaMarcha;
            System.out.println("Marcha alterada para " + marchaAtual + ".");
        } else {
            System.out.println("Marcha inválida (1 a " + MARCHA_MAXIMA + ").");
        }
    }

    // Métodos de acesso
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public int getMarchaAtual() { return marchaAtual; }
    public void setMarchaAtual(int marchaAtual) { trocarMarcha(marchaAtual); }
    public double getVelocidade() { return velocidade; }
    public void setVelocidade(double velocidade) { this.velocidade = Math.max(0, velocidade); }
}
