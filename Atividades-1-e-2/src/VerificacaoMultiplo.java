import java.util.Scanner;

public class VerificacaoMultiplo {
    public void executar() {
        Scanner scanner = new Scanner(System.in);

        int num1 = lerInteiro(scanner, "Informe um número: ");
        int num2 = lerInteiro(scanner, "Informe outro número: ");

        if (num2 == 0) {
            System.out.println("Não é possível verificar: o segundo número não pode ser 0.");
        } else if (num1 % num2 == 0) {
            System.out.printf("%d é múltiplo de %d!%n", num1, num2);
        } else {
            System.out.printf("%d não é múltiplo de %d!%n", num1, num2);
        }
    }

    // Lê um número inteiro e pede de novo se o usuário digitar algo inválido
    private int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.println(mensagem);
            String texto = scanner.nextLine().trim();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
    }
}
