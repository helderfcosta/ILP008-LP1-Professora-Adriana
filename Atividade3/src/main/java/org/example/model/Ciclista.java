package org.example.model;

/** MODEL: pessoa pedalando na trilha (Imagem 2). Métodos devolvem texto para a tela. */
public class Ciclista {
    private String nome;
    private int idade;
    private int energia;   // 0 a 100

    public Ciclista(String nome, int idade) {
        this.nome = nome;
        this.idade = Math.max(0, idade);
        this.energia = 100;
    }

    // Métodos de negócio
    public String pedalar(Bicicleta bicicleta, int minutos) {
        if (bicicleta == null) {
            return "Escolha uma bicicleta.";
        }
        if (energia <= 0) {
            return nome + " está sem energia. Descanse antes de pedalar.";
        }
        int gasto = minutos / 2;                 // cada 2 minutos gastam 1 de energia
        setEnergia(energia - gasto);
        return nome + " pedalou " + minutos + " min. Energia: " + energia
                + "\n" + bicicleta.pedalar(10);  // usa o método da classe Bicicleta
    }

    public String beberAgua() {
        setEnergia(energia + 10);
        return nome + " bebeu água. Energia: " + energia;
    }

    public String descansar(int minutos) {
        setEnergia(energia + minutos / 2);
        return nome + " descansou " + minutos + " min. Energia: " + energia;
    }

    // Métodos de acesso
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = Math.max(0, idade); }
    public int getEnergia() { return energia; }
    public void setEnergia(int energia) { this.energia = Math.max(0, Math.min(100, energia)); }

    @Override
    public String toString() {
        return nome + " (" + idade + " anos) - energia " + energia;
    }
}
