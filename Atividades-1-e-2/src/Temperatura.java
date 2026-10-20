import java.util.Scanner;

public class Temperatura {
    public void executar() {
        Scanner scanner = new Scanner(System.in);

        double[] temp = new double[5];
        var tempTotal = 0.0;

        System.out.println("Informe a temperatura dos últimos 5 dias!");

        for (int i = 0; i < temp.length; i++) {
            System.out.printf("Informe a temperatura do dia %d%n", (i + 1));
            temp[i] = scanner.nextDouble();
            tempTotal += (temp[i]);
        }

        var mediaTemp = tempTotal / 5;

        System.out.printf("A média da temperatura é: %.2f%n", mediaTemp);
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] < 18) {
                System.out.println("Temperatura: " + temp[i] + " , Frio!");
            } else {
                System.out.println("Temperatura: " + temp[i] + " , Adradável!");
            }
        }
        if (mediaTemp < 18) {
            System.out.println("São José dos Campos possui em geral, um clima Frio!");
        } else {
            System.out.println("São José dos Campos possui em geral, uma temperatura Agradável!!");
        }

    }
}
