public class FabricaBrasilCheckout implements IFabricaCheckout {

    @Override
    public IDocumentoFiscal criarDocumentoFiscal() {
        return new NotaFiscalEletronica(
            NotaFiscalEletronica.Operacao.DENTRO_ESTADO,
            "12345678901234567890123456789012345678901234"
        );
    }

    @Override
    public IProcessadorPagamento criarProcessadorPagamento() {
        return new PagamentoBrasil(
            PagamentoBrasil.Metodo.PIX,
            0.05
        );
    }

    @Override
    public IEtiquetaEnvio criarEtiquetaEnvio() {
        return new EtiquetaCorreios("80000-000");
    }
}