public class PagamentoSepaDebit implements IProcessadorPagamento {

    public String iban;

    public PagamentoSepaDebit(String iban) {
        this.iban = iban;
    }

    @Override
    public String processar(double valor) {
        return "SepaDebit processado, valor: EUR " + valor + ", IBAN: " + iban;
    }
}
