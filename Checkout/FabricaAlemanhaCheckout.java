public class FabricaAlemanhaCheckout implements IFabricaCheckout {

    @Override
    public IDocumentoFiscal criarDocumentoFiscal() {
        return new VatInvoice(19.0, "DE123456789");
    }

    @Override
    public IProcessadorPagamento criarProcessadorPagamento() {
        return new PagamentoSepaDebit("DE89370400440532013000");
    }

    @Override
public IEtiquetaEnvio criarEtiquetaEnvio() {
    return new EtiquetaDeutschePost("10115");
}
}