import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var opcao = -1;

        do {
            System.out.println("\nQual você deseja executar?");
            System.out.println("1-Verificação de Múltiplo");
            System.out.println("2-Sistema de Login Simplificado");
            System.out.println("3-Compra com desconto");
            System.out.println("4-Temperatura");
            System.out.println("5-Os trinta e cinco camelos");
            System.out.println("6-Calculadora de viagem");
            System.out.println("7-Aluguel de carro");
            System.out.println("0-Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    VerificacaoMultiplo exercicio1 = new VerificacaoMultiplo();
                    exercicio1.executar();
                }
                case 2 -> {
                    SistemaLogin exercicio2 = new SistemaLogin();
                    exercicio2.executar();
                }
                case 3 -> {
                    CompraComDesconto exercicio3 = new CompraComDesconto();
                    exercicio3.executar();
                }
                case 4 -> {
                    Temperatura exercicio4 = new Temperatura();
                    exercicio4.executar();
                }
                case 5 -> {
                    TrintaCincoCamelos exercicio5 = new TrintaCincoCamelos();
                    exercicio5.executar();
                }
                case 6 -> {
                    CalculadoraViagem exercicio6 = new CalculadoraViagem();
                    exercicio6.executar();
                }
                case 7 -> {
                    AluguelDeCarro exercicio7 = new AluguelDeCarro();
                    exercicio7.executar();
                }
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}