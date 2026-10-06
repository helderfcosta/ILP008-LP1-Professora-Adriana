import java.util.Scanner;

public class AluguelDeCarro {
    public void executar() {
        Scanner scanner = new Scanner(System.in);

        final double diaria = 100.0;
        final double limite_km = 200.0;
        final double taxa = 0.50;

        System.out.println("Informe a quantidade de dias de aluguel: ");
        var dias = scanner.nextInt();

        System.out.println("Informe a quilometragem percorrida: ");
        var kmPercorrido = scanner.nextDouble();

        var custoDiarias = dias * diaria;

        var kmExcedente = 0.0;
        if (kmPercorrido > limite_km) {
            kmExcedente = kmPercorrido - limite_km;
        }

        var custoExcedente = kmExcedente * taxa;
        var custoTotal = custoDiarias + custoExcedente;

        System.out.printf("Custo total do aluguel: R$ %.2f%n", custoTotal);



    }
}
