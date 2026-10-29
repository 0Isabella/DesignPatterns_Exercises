public class PagamentoCartaoCredito implements IProcessadorPagamento {

    public boolean avs;
    public String zipCode;

    public PagamentoCartaoCredito(boolean avs, String zipCode) {
        this.avs = avs;
        this.zipCode = zipCode;
    }

    @Override
    public String processar(double valor) {

        if (!zipCode.matches("\\d{5}-\\d{4}")) {
            return "ZIP+4 inválido.";
        }

        return "Pagamento por Cartão de Crédito processado, valor: $" + valor + ", AVS check: " + avs + ", USPS ZIP+4: " + zipCode;
    }
}
