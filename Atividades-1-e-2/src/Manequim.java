// IMAGEM 1 - manequim que exibe as roupas na vitrine
public class Manequim {
    private double altura;      // em cm
    private int anguloGiro;     // 0 a 359 graus
    private Roupa roupaAtual;   // null = sem roupa

    public Manequim(double altura) {
        this.altura = altura;
        this.anguloGiro = 0;
        this.roupaAtual = null;
    }

    // Métodos de negócio
    public void vestir(Roupa roupa) {
        if (roupa == null) {
            System.out.println("Nenhuma roupa informada.");
            return;
        }
        roupaAtual = roupa;
        System.out.println("Manequim vestiu: " + roupa.getTipo() + " (" + roupa.getTamanho() + ").");
    }

    public void despir() {
        if (roupaAtual == null) {
            System.out.println("O manequim já está sem roupa.");
        } else {
            System.out.println("Manequim tirou: " + roupaAtual.getTipo() + ".");
            roupaAtual = null;
        }
    }

    public void girar(int graus) {
        // o cálculo abaixo mantém o ângulo sempre entre 0 e 359
        anguloGiro = ((anguloGiro + graus) % 360 + 360) % 360;
        System.out.println("Manequim girou. Ângulo atual: " + anguloGiro + " graus.");
    }

    // Métodos de acesso
    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }
    public int getAnguloGiro() { return anguloGiro; }
    public void setAnguloGiro(int anguloGiro) { this.anguloGiro = ((anguloGiro % 360) + 360) % 360; }
    public Roupa getRoupaAtual() { return roupaAtual; }
    public void setRoupaAtual(Roupa roupaAtual) { this.roupaAtual = roupaAtual; }
}
