import java.util.Scanner;

public class VerificacaoMultiplo {
    public void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe um número: ");
        int num1 = scanner.nextInt();

        System.out.println("Informe outro número: ");
        int num2 = scanner.nextInt();

        if (num1 % num2 == 0) {
            System.out.printf("%d é múltiplo de %d!%n", num1, num2);
        } else {
            System.out.printf("O número %d não é múltiplo de %d!%n", num1, num2);
        }

    }


}




