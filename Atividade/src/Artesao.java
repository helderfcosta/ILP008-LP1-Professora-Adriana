// IMAGEM 3 - quem produz as máscaras
public class Artesao {
    private String nome;
    private String etnia;
    private int anosDeOficio;

    public Artesao(String nome, String etnia, int anosDeOficio) {
        this.nome = nome;
        this.etnia = etnia;
        setAnosDeOficio(anosDeOficio);
    }

    // Métodos de negócio
    public MascaraAfricana esculpir(String material, int anoAtual) {
        System.out.println(nome + " esculpiu uma máscara de " + material + ".");
        return new MascaraAfricana(etnia, material, anoAtual);   // cria e devolve a máscara
    }

    public String classificarNivel() {
        if (anosDeOficio < 5) {
            return "Aprendiz";
        } else if (anosDeOficio < 20) {
            return "Experiente";
        }
        return "Mestre";
    }

    public void apresentar() {
        System.out.println(nome + " (" + etnia + ") - " + anosDeOficio + " anos de ofício - nível " + classificarNivel() + ".");
    }

    // Métodos de acesso
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEtnia() { return etnia; }
    public void setEtnia(String etnia) { this.etnia = etnia; }
    public int getAnosDeOficio() { return anosDeOficio; }
    public void setAnosDeOficio(int anosDeOficio) { this.anosDeOficio = Math.max(0, anosDeOficio); }
}
