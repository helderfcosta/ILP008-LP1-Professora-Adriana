import java.time.Year;

public class Principal {
    public static void main(String[] args) {
        int anoAtual = Year.now().getValue();

        // ===================== IMAGEM 1 =====================
        System.out.println("=== Imagem 1: Loja de roupas ===");
        Loja loja = new Loja("Dorinho's", "São José dos Campos", 200);
        loja.exibirSituacao();
        loja.receberPecas(50);
        loja.venderPecas(30);
        loja.venderPecas(500);   // deve falhar: estoque insuficiente
        loja.exibirSituacao();

        Roupa terno = new Roupa("Terno", "M", 899.90);
        terno.exibirEtiqueta();
        terno.aplicarDesconto(10);
        System.out.printf("Em 3x: R$ %.2f cada%n", terno.calcularParcela(3));

        Manequim manequim = new Manequim(180);
        manequim.vestir(terno);
        manequim.girar(90);
        manequim.girar(300);
        manequim.despir();

        // ===================== IMAGEM 2 =====================
        System.out.println("\n=== Imagem 2: Ciclistas na trilha ===");
        Bicicleta bike = new Bicicleta("Caloi");
        bike.pedalar(10);
        bike.trocarMarcha(5);
        bike.pedalar(10);
        bike.trocarMarcha(30);   // deve falhar: marcha inválida
        bike.frear();

        Ciclista ciclista = new Ciclista("Ana", 28);
        ciclista.pedalar(bike, 60);
        ciclista.beberAgua();
        ciclista.descansar(20);

        Trilha trilha = new Trilha("Trilha da Mata", 12.5, 3);
        trilha.descrever();
        System.out.printf("Tempo a 15 km/h: %.2f h%n", trilha.calcularTempo(15));

        // ===================== IMAGEM 3 =====================
        System.out.println("\n=== Imagem 3: Máscaras africanas ===");
        MascaraAfricana m1 = new MascaraAfricana("Songye", "madeira", 1920);
        MascaraAfricana m2 = new MascaraAfricana("Fang", "madeira e pigmentos", 1990);
        m1.descrever(anoAtual);
        m2.descrever(anoAtual);

        Artesao artesao = new Artesao("Kofi", "Songye", 25);
        artesao.apresentar();
        MascaraAfricana nova = artesao.esculpir("madeira", anoAtual);
        nova.descrever(anoAtual);

        Exposicao exposicao = new Exposicao("Arte Africana", 2);
        exposicao.adicionarPeca();
        exposicao.adicionarPeca();
        exposicao.adicionarPeca();   // deve falhar: exposição lotada
        exposicao.exibirOcupacao();
        exposicao.removerPeca();
        exposicao.exibirOcupacao();

        // ===================== IMAGEM 4 =====================
        System.out.println("\n=== Imagem 4: Rostos e penteados ===");
        Penteado p = new Penteado("Liso curto", 12.0, "preto");
        System.out.println(p);
        p.crescer(5);
        p.cortar(8);
        p.pintar("castanho");
        System.out.println(p);

        Rosto rosto = new Rosto("oval", "claro");
        rosto.sorrir();
        rosto.piscar();
        rosto.mudarExpressao("surpreso");

        Cabeleireiro cabeleireiro = new Cabeleireiro("Marcos", "Studio Hair", 40.0);
        cabeleireiro.apresentar();
        System.out.printf("Preço do atendimento: R$ %.2f%n", cabeleireiro.calcularPreco(p));
        cabeleireiro.atender(p, 3);
        System.out.println(p);
    }
}
