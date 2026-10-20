import java.util.Scanner;

public class Temperatura {
    public void executar() {
        Scanner scanner = new Scanner(System.in);

        double[] temp = new double[5];
        double tempTotal = 0.0;

        System.out.println("Informe a temperatura (°C) dos últimos 5 dias de São José dos Campos:");

        for (int i = 0; i < temp.length; i++) {
            temp[i] = lerDouble(scanner, "Temperatura do dia " + (i + 1) + ": ");
            tempTotal += temp[i];
        }

        double mediaTemp = tempTotal / temp.length;

        System.out.println();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] < 18) {
                System.out.printf("Dia %d: %.1f °C - Frio%n", i + 1, temp[i]);
            } else {
                System.out.printf("Dia %d: %.1f °C - Temperatura agradável%n", i + 1, temp[i]);
            }
        }

        System.out.printf("%nMédia: %.2f °C%n", mediaTemp);
        if (mediaTemp < 18) {
            System.out.println("Em geral, em São José dos Campos faz frio.");
        } else {
            System.out.println("Em geral, em São José dos Campos a temperatura é agradável.");
        }
    }

    // Lê um número decimal; aceita vírgula ou ponto e pede de novo se for inválido
    private double lerDouble(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine().trim().replace(',', '.');
            try {
                double valor = Double.parseDouble(texto);
                if (Double.isFinite(valor)) {
                    return valor;
                }
            } catch (NumberFormatException e) {
                // cai na mensagem abaixo
            }
            System.out.println("Valor inválido. Digite um número.");
        }
    }
}
