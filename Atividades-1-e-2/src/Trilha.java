// IMAGEM 2 - estrada de terra na floresta
public class Trilha {
    private String nome;
    private double extensaoKm;
    private int dificuldade;   // 1 (muito fácil) a 5 (muito difícil)

    public Trilha(String nome, double extensaoKm, int dificuldade) {
        this.nome = nome;
        this.extensaoKm = extensaoKm;
        setDificuldade(dificuldade);
    }

    // Métodos de negócio
    public double calcularTempo(double velocidadeMediaKmH) {
        if (velocidadeMediaKmH <= 0) {
            return 0;
        }
        return extensaoKm / velocidadeMediaKmH;   // resultado em horas
    }

    public String classificar() {
        if (dificuldade <= 2) {
            return "Fácil";
        } else if (dificuldade <= 4) {
            return "Moderada";
        }
        return "Difícil";
    }

    public void descrever() {
        System.out.printf("Trilha %s: %.1f km, nível %s.%n", nome, extensaoKm, classificar());
    }

    // Métodos de acesso
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getExtensaoKm() { return extensaoKm; }
    public void setExtensaoKm(double extensaoKm) { this.extensaoKm = Math.max(0, extensaoKm); }
    public int getDificuldade() { return dificuldade; }
    public void setDificuldade(int dificuldade) { this.dificuldade = Math.max(1, Math.min(5, dificuldade)); }
}
