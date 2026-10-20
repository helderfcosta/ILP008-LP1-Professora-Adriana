package org.example.model;

/** MODEL: os rostos desenhados (Imagem 4). Métodos devolvem texto para a tela. */
public class Rosto {
    private String formato;     // ex.: "oval", "redondo"
    private String tomDePele;
    private String expressao;   // ex.: "neutra", "sorrindo"

    public Rosto(String formato, String tomDePele) {
        this.formato = formato;
        this.tomDePele = tomDePele;
        this.expressao = "neutra";
    }

    // Métodos de negócio
    public String sorrir() {
        expressao = "sorrindo";
        return "Rosto " + formato + " está " + expressao + ".";
    }

    public String piscar() {
        return "Rosto " + formato + " piscou (expressão atual: " + expressao + ").";
    }

    public String mudarExpressao(String novaExpressao) {
        String mensagem = "Expressão mudou de " + expressao + " para " + novaExpressao + ".";
        expressao = novaExpressao;
        return mensagem;
    }

    // Métodos de acesso
    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }
    public String getTomDePele() { return tomDePele; }
    public void setTomDePele(String tomDePele) { this.tomDePele = tomDePele; }
    public String getExpressao() { return expressao; }
    public void setExpressao(String expressao) { this.expressao = expressao; }

    @Override
    public String toString() {
        return "Rosto " + formato + " - pele " + tomDePele + " - expressão: " + expressao;
    }
}
