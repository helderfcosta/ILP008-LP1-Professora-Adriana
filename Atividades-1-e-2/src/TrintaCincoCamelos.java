import java.util.Scanner;

public class TrintaCincoCamelos {
    public void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o total de camelos a serem divididos?");
        var totalCam = scanner.nextInt();

        System.out.println("Em quantas pessoas serão dividos?");
        var totalPess = scanner.nextInt();

        int[] parcela = new int[totalPess];
        int[] denominador = new int[totalPess];

        for (var i = 0; i < parcela.length; i++) {
            System.out.printf("Informe o denominador da pessoa %d%n", i + 1);
            denominador[i] = scanner.nextInt();
        }

        var totalEmprestado = totalCam + 1;
        var somaDistribuida = 0;

        for (var i = 0; i < parcela.length; i++) {
            parcela[i] = totalEmprestado / denominador[i];
            somaDistribuida += parcela[i];
        }

        var sobra = totalEmprestado - somaDistribuida;

        System.out.println("\n===== DIVISÃO DOS CAMELOS =====");

        for (var i = 0; i < parcela.length; i++) {
            System.out.printf("Pessoa %d recebeu: %d camelos%n", i + 1, parcela[i]);
        }

        System.out.println("--------------------------------");
        System.out.println("Camelo emprestado devolvido: 1");
        System.out.println("Camelos que sobraram (sem contar o emprestado): " + (sobra - 1));




    }
}
