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

        double[] precos = new double[itens.length];       // preço de 1 unidade
        int[] quantidades = new int[itens.length];        // quantas unidades
        double[] parciais = new double[itens.length];     // preço x quantidade
        double subtotal = 0;

        System.out.println("=== COMPRA DO LUCAS ===");
        for (int i = 0; i < itens.length; i++) {
            System.out.println("\n" + itens[i]);
            precos[i] = lerDouble(scanner, "  Preço unitário (R$): ");
            quantidades[i] = lerInteiro(scanner, "  Quantidade: ");
            parciais[i] = precos[i] * quantidades[i];
            subtotal += parciais[i];
        }

        // Regra: desconto de 10% apenas se a compra for MAIOR que R$ 100
        double desconto = 0.0;
        if (subtotal > 100) {
            desconto = subtotal * 0.10;
        }
        double totalFinal = subtotal - desconto;

        System.out.println("\n============== CAIXA ==============");
        System.out.printf("%-28s %4s %10s %10s%n", "Item", "Qtd", "Unitário", "Parcial");
        for (int i = 0; i < itens.length; i++) {
            if (quantidades[i] > 0) {
                System.out.printf("%-28s %4d %10.2f %10.2f%n", itens[i], quantidades[i], precos[i], parciais[i]);
            }
        }
        System.out.println("-----------------------------------");
        System.out.printf("Subtotal: R$ %.2f%n", subtotal);
        if (desconto > 0) {
            System.out.printf("Desconto de 10%%: -R$ %.2f%n", desconto);
        } else {
            System.out.println("Sem desconto (compra até R$ 100,00).");
        }
        System.out.printf("TOTAL A PAGAR: R$ %.2f%n", totalFinal);
    }

    // Lê um número decimal; aceita vírgula ou ponto e pede de novo se for inválido
    private double lerDouble(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
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

    // Lê um número inteiro (0 ou mais) e pede de novo se for inválido
    private int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine().trim();
            try {
                int valor = Integer.parseInt(texto);
                if (valor >= 0) {
                    return valor;
                }
            } catch (NumberFormatException e) {
                // cai na mensagem abaixo
            }
            System.out.println("Quantidade inválida. Digite um número inteiro maior ou igual a 0.");
        }
    }
}
