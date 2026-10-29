public class FabricaEstadosUnidosCheckout implements IFabricaCheckout {

    @Override
    public IDocumentoFiscal criarDocumentoFiscal() {
        return new SalesInvoice(7.25, "12-3456789");
    }

    @Override
    public IProcessadorPagamento criarProcessadorPagamento() {
        return new PagamentoCartaoCredito(true, "90210-1234");
    }

    @Override
    public IEtiquetaEnvio criarEtiquetaEnvio() {
        return new EtiquetaUSPS("90210-1234");
    }
}