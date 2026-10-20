package org.example.model;

/** MODEL: quem produz as máscaras (Imagem 3). */
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

    public String apresentar() {
        return nome + " (" + etnia + ") - " + anosDeOficio + " anos de ofício - nível " + classificarNivel() + ".";
    }

    // Métodos de acesso
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEtnia() { return etnia; }
    public void setEtnia(String etnia) { this.etnia = etnia; }
    public int getAnosDeOficio() { return anosDeOficio; }
    public void setAnosDeOficio(int anosDeOficio) { this.anosDeOficio = Math.max(0, anosDeOficio); }

    @Override
    public String toString() {
        return apresentar();
    }
}
