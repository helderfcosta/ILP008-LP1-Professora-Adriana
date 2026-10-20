import java.util.Scanner;

public class CompraComDesconto {
    public void executar() {
        Scanner scanner = new Scanner(System.in);
        String[] itens = {"Arroz tipo 1 (5kg)",
                "Feijão carioca (1kg)",
                "Óleo de soja (900ml)",
                "Açúcar refinado (1kg)",
                "Café torrado e moído (500g)",
                "Macarrão espaguete (500g)",
                "Farinha de trigo (1kg)",
                "Fubá de milho (500g)",
                "Molho de tomate (300g)",
                "Sal refinado (1kg)"};

        double[] precos = new double[itens.length];
        double total = 0;

        for (int i = 0; i < itens.length; i++) {
            System.out.printf("Informe o preço do %s ", itens[i]);
            precos[i] = scanner.nextDouble();
            total += precos[i];
        }

        double desconto = 0.0;

        if (total > 100) {
            desconto = total * 0.10;
        }

        double totalFinal = total - desconto;

        System.out.println("LISTAGEM");

        for (int i = 0; i < itens.length; i++) {
            System.out.println(itens[i] + " R$ " + precos[i]);
        }
        System.out.println("=========================");
        System.out.println("Subtotal: " + total);
        System.out.println("Desconto: R$" + desconto);
        System.out.println("Total: R$" + totalFinal);


    }
}
