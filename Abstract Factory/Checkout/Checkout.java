public class Checkout {

    public static void main(String[] args) {

        // Checkout - Brasil
        IFabricaCheckout fabricaBrasil = new FabricaBrasilCheckout();

        Checkout checkoutBrasil = new Checkout();
        checkoutBrasil.finalizarPedido(fabricaBrasil);


        // Checkout - Estados Unidos
        IFabricaCheckout fabricaEUA = new FabricaEstadosUnidosCheckout();

        Checkout checkoutEUA = new Checkout();
        checkoutEUA.finalizarPedido(fabricaEUA);


        // Checkout - Alemanha
        IFabricaCheckout fabricaAlemanha = new FabricaAlemanhaCheckout();

        Checkout checkoutAlemanha = new Checkout();
        checkoutAlemanha.finalizarPedido(fabricaAlemanha);
    }

    public void finalizarPedido(IFabricaCheckout fabrica) {

        IDocumentoFiscal documento = fabrica.criarDocumentoFiscal();
        IProcessadorPagamento pagamento = fabrica.criarProcessadorPagamento();
        IEtiquetaEnvio etiqueta = fabrica.criarEtiquetaEnvio();

        System.out.println("===== PEDIDO =====");
        System.out.println(documento.gerar());
        System.out.println(pagamento.processar(1000));
        System.out.println(etiqueta.gerar());
        System.out.println("==================");
        System.out.println();
    }
}