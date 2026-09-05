public interface IFabricaCheckout {

    IDocumentoFiscal criarDocumentoFiscal();

    IProcessadorPagamento criarProcessadorPagamento();

    IEtiquetaEnvio criarEtiquetaEnvio();
}