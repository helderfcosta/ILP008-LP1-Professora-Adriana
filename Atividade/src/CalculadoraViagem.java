import java.util.Scanner;

public class CalculadoraViagem {
    public void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a distância percorrida na viagem (em Km):");
        var dist = scanner.nextDouble();

        System.out.println("Informe o preço do combustível:");
        var price = scanner.nextDouble();

        var litros = dist / 12;

        var valor = litros * price;

        if (dist > 500) {
            var desconto = valor * 0.05;
            var total = valor - desconto;
            System.out.printf("O valor da gasto na viagem foi de R$%.2f", total);
        } else {
            System.out.printf("O valor gasto na viagem foi de R$%.2f", valor);
        }


    }
}
