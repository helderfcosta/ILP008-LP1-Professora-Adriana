// IMAGEM 4 - os rostos desenhados
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
    public void sorrir() {
        expressao = "sorrindo";
        System.out.println("Rosto " + formato + " está " + expressao + ".");
    }

    public void piscar() {
        System.out.println("Rosto " + formato + " piscou (expressão atual: " + expressao + ").");
    }

    public void mudarExpressao(String novaExpressao) {
        System.out.println("Expressão mudou de " + expressao + " para " + novaExpressao + ".");
        expressao = novaExpressao;
    }

    // Métodos de acesso
    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }
    public String getTomDePele() { return tomDePele; }
    public void setTomDePele(String tomDePele) { this.tomDePele = tomDePele; }
    public String getExpressao() { return expressao; }
    public void setExpressao(String expressao) { this.expressao = expressao; }
}
