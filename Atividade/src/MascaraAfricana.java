public class MascaraAfricana {
    private String etnia;
    private String material;
    private int anoCriacao;

    public MascaraAfricana(String etnia, String material, int anoCriacao) {
        this.etnia = etnia;
        this.material = material;
        this.anoCriacao = anoCriacao;
    }

    // Métodos de negócio
    public int calcularIdade(int anoAtual) {
        return anoAtual - anoCriacao;
    }

    public boolean ehAntiga(int anoAtual) {
        return calcularIdade(anoAtual) >= 100;
    }

    public void descrever(int anoAtual) {
        System.out.println("Máscara da etnia " + etnia + ", feita de " + material
                + ", com " + calcularIdade(anoAtual) + " anos"
                + (ehAntiga(anoAtual) ? " (peça antiga)." : "."));
    }

    // Métodos de acesso
    public String getEtnia() { return etnia; }
    public void setEtnia(String etnia) { this.etnia = etnia; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public int getAnoCriacao() { return anoCriacao; }
    public void setAnoCriacao(int anoCriacao) { this.anoCriacao = anoCriacao; }
}
