import java.util.Scanner;

public class CalculadoraViagem {
    public void executar() {
        Scanner scanner = new Scanner(System.in);
        final double consumoKmPorLitro = 12.0;

        double dist = lerDouble(scanner, "Informe a distância da viagem (em km): ");
        double preco = lerDouble(scanner, "Informe o preço do combustível (R$ por litro): ");

        double litros = dist / consumoKmPorLitro;
        double valor = litros * preco;

        // Viagem com mais de 500 km ganha 5% de desconto no custo calculado
        if (dist > 500) {
            double desconto = valor * 0.05;
            valor = valor - desconto;
            System.out.printf("Viagem acima de 500 km: desconto de 5%% (R$ %.2f) aplicado.%n", desconto);
        }

        System.out.printf("O valor gasto na viagem será de R$ %.2f%n", valor);
    }

    // Lê um número decimal (0 ou mais); aceita vírgula ou ponto
    private double lerDouble(Scanner scanner, String mensagem) {
        while (true) {
            System.out.println(mensagem);
            String texto = scanner.nextLine().trim().replace(',', '.');
            try {
                double valor = Double.parseDouble(texto);
                if (Double.isFinite(valor) && valor >= 0) {
                    return valor;
                }
            } catch (NumberFormatException e) {
                // cai na mensagem abaixo
            }
            System.out.println("Valor inválido. Digite um número maior ou igual a 0.");
        }
    }
}
