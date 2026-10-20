import java.util.Scanner;

public class SistemaLogin {
    public void executar() {
        Scanner scanner = new Scanner(System.in);
        final String senhaCadastrada = "1234";

        System.out.println("Informe a senha: ");
        String senhaDigitada = scanner.nextLine().trim();

        if (senhaDigitada.equals(senhaCadastrada)) {
            System.out.println("Acesso permitido");
        } else {
            System.out.println("Acesso negado");
        }
    }
}
