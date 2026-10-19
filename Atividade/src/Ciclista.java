// IMAGEM 2 - pessoa pedalando na trilha
public class Ciclista {
    private String nome;
    private int idade;
    private int energia;   // 0 a 100

    public Ciclista(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.energia = 100;
    }

    // Métodos de negócio
    public void pedalar(Bicicleta bicicleta, int minutos) {
        if (energia <= 0) {
            System.out.println(nome + " está sem energia. Descanse antes de pedalar.");
            return;
        }
        int gasto = minutos / 2;                 // cada 2 minutos gastam 1 de energia
        setEnergia(energia - gasto);
        System.out.println(nome + " pedalou " + minutos + " min. Energia: " + energia);
        bicicleta.pedalar(10);                   // usa o método da classe Bicicleta
    }

    public void beberAgua() {
        setEnergia(energia + 10);
        System.out.println(nome + " bebeu água. Energia: " + energia);
    }

    public void descansar(int minutos) {
        setEnergia(energia + minutos / 2);
        System.out.println(nome + " descansou " + minutos + " min. Energia: " + energia);
    }

    // Métodos de acesso
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public int getEnergia() { return energia; }
    public void setEnergia(int energia) { this.energia = Math.max(0, Math.min(100, energia)); }
}
