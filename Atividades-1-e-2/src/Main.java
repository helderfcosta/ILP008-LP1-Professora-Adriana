import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

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

            // Lê a linha inteira e converte; se não for número, avisa em vez de travar
            String entrada = scanner.nextLine().trim();
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcao = -1;
                System.out.println("Opção inválida! Digite um número de 0 a 7.");
                continue;
            }

            switch (opcao) {
                case 1 -> new VerificacaoMultiplo().executar();
                case 2 -> new SistemaLogin().executar();
                case 3 -> new CompraComDesconto().executar();
                case 4 -> new Temperatura().executar();
                case 5 -> new TrintaCincoCamelos().executar();
                case 6 -> new CalculadoraViagem().executar();
                case 7 -> new AluguelDeCarro().executar();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida! Digite um número de 0 a 7.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
