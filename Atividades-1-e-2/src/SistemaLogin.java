import java.util.Scanner;

public class SistemaLogin {
    public void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a senha: ");
        int senha = scanner.nextInt();

        if (senha==1234) {
            System.out.println("Acesso Permitido!");
        }else{
            System.out.println("Acesso Negado!");
        }
    }
}
