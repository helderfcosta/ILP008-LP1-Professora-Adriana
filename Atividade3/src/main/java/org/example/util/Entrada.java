package org.example.util;

/**
 * Funções auxiliares para converter o texto digitado nos campos da tela.
 * Quando o valor é inválido, lançam IllegalArgumentException com uma mensagem
 * amigável, que o Controller mostra para o usuário.
 */
public final class Entrada {

    private Entrada() {
    }

    public static String lerTexto(String texto, String campo) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException("Preencha o campo \"" + campo + "\".");
        }
        return texto.trim();
    }

    public static double lerDouble(String texto, String campo) {
        try {
            double valor = Double.parseDouble(texto.trim().replace(',', '.'));
            if (!Double.isFinite(valor)) {
                throw new NumberFormatException();
            }
            return valor;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Informe um número válido no campo \"" + campo + "\".");
        }
    }

    public static int lerInteiro(String texto, String campo) {
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Informe um número inteiro válido no campo \"" + campo + "\".");
        }
    }
}
