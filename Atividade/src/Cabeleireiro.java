// IMAGEM 4 - quem cuida dos penteados
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
    public void atender(Penteado penteado, double cmParaCortar) {
        System.out.println(nome + " atendeu no salão " + salao + ".");
        penteado.cortar(cmParaCortar);   // usa o método da classe Penteado
    }

    public double calcularPreco(Penteado penteado) {
        return precoBase + penteado.getComprimentoCm() * TAXA_POR_CM;
    }

    public void apresentar() {
        System.out.printf("Cabeleireiro %s - salão %s - atendimento a partir de R$ %.2f%n", nome, salao, precoBase);
    }

    // Métodos de acesso
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSalao() { return salao; }
    public void setSalao(String salao) { this.salao = salao; }
    public double getPrecoBase() { return precoBase; }
    public void setPrecoBase(double precoBase) { this.precoBase = Math.max(0, precoBase); }
}
