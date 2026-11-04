package pedidos;

import java.math.BigDecimal;
import java.util.Locale;

public class PedidosApp {

    public static void main(String[] args) {
        Pedido modelo = new Pedido("(modelo)", "-");
        modelo.adicionarItem(new ItemPedido("Café 500g", 10, new BigDecimal("18.90")));
        modelo.adicionarItem(new ItemPedido("Açúcar 1kg", 20, new BigDecimal("4.50")));
        modelo.adicionarItem(new ItemPedido("Filtro de papel", 5, new BigDecimal("7.20")));

        CatalogoDePedidos catalogo = new CatalogoDePedidos();
        catalogo.registrar("reposicao-mensal", modelo);

        Pedido a = catalogo.criar("reposicao-mensal");
        a.setCliente("Mercado Central");
        a.setEnderecoEntrega("Rua das Flores, 120");

        Pedido b = catalogo.criar("reposicao-mensal");
        b.setCliente("Padaria Boa Massa");
        b.setEnderecoEntrega("Av. Paraná, 800");
        b.getItens().get(0).setQuantidade(20); // Café 500g -> 20

        Pedido c = catalogo.criar("reposicao-mensal");
        c.setCliente("Restaurante do Porto");
        c.setEnderecoEntrega("Rua do Cais, 45");
        c.adicionarItem(new ItemPedido("Adoçante 100ml", 12, new BigDecimal("6.00")));

        imprimir(modelo);
        imprimir(a);
        imprimir(b);
        imprimir(c);

        // ----- critérios de aceitação (seção 6) -----
        System.out.println();
        verificar("CA-01", "ids diferentes entre os quatro pedidos",
                idsDiferentes(modelo, a, b, c));
        verificar("CA-02", "total do modelo continua R$ 315,00",
                iguais(modelo.valorTotal(), "315.00"));
        verificar("CA-03", "totais A = 315,00; B = 504,00; C = 387,00",
                iguais(a.valorTotal(), "315.00")
                        && iguais(b.valorTotal(), "504.00")
                        && iguais(c.valorTotal(), "387.00"));
        verificar("CA-04", "modelo continua com 3 itens",
                modelo.getItens().size() == 3);
        verificar("CA-05", "nenhum item das cópias é a mesma instância do modelo",
                semItensCompartilhados(modelo, a, b, c));
        verificar("CA-06", "criar(\"inexistente\") lança IllegalArgumentException",
                lancaExcecao(catalogo));
        verificar("CA-07", "cliente do modelo continua \"(modelo)\"",
                modelo.getCliente().equals("(modelo)"));

        // ----- desafio (RF12): 100.000 cópias de cada tipo -----
        int copias = 100_000;

        long inicio = System.nanoTime();
        for (int i = 0; i < copias; i++) {
            modelo.clonar();
        }
        long msManual = (System.nanoTime() - inicio) / 1_000_000;

        inicio = System.nanoTime();
        for (int i = 0; i < copias; i++) {
            modelo.clonarPorSerializacao();
        }
        long msSerializacao = (System.nanoTime() - inicio) / 1_000_000;

        System.out.println();
        System.out.println("Tempo de " + copias + " cópias:");
        System.out.println("clonar():                " + msManual + " ms");
        System.out.println("clonarPorSerializacao(): " + msSerializacao + " ms");
    }

    // ----- apoio ao teste -----

    private static void imprimir(Pedido p) {
        System.out.println("Pedido #" + p.getId()
                + " | " + p.getCliente()
                + " | " + p.getEnderecoEntrega()
                + " | itens=" + p.getItens().size()
                + " | total=R$ " + String.format(Locale.forLanguageTag("pt-BR"), "%.2f", p.valorTotal()));
    }

    private static void verificar(String id, String descricao, boolean ok) {
        System.out.println(id + " " + descricao + ": " + (ok ? "OK" : "FALHA"));
    }

    private static boolean iguais(BigDecimal valor, String esperado) {
        return valor.compareTo(new BigDecimal(esperado)) == 0;
    }

    private static boolean idsDiferentes(Pedido... pedidos) {
        for (int i = 0; i < pedidos.length; i++) {
            for (int j = i + 1; j < pedidos.length; j++) {
                if (pedidos[i].getId() == pedidos[j].getId()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean semItensCompartilhados(Pedido modelo, Pedido... copias) {
        for (Pedido copia : copias) {
            for (ItemPedido itemCopia : copia.getItens()) {
                for (ItemPedido itemModelo : modelo.getItens()) {
                    if (itemCopia == itemModelo) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean lancaExcecao(CatalogoDePedidos catalogo) {
        try {
            catalogo.criar("inexistente");
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }
}
