public class PagamentoBrasil implements IProcessadorPagamento {

    public enum Metodo {
        PIX, BOLETO
    }
    public Metodo metodo;
    public double valor;

    public PagamentoBrasil(Metodo metodo, double valor) {
        this.metodo = metodo;
        this.valor = valor;
    }

    @Override
    public String processar(double valor) {

        if(metodo == Metodo.PIX) {
            double desconto = 0.05;
            double valorFinal = valor - (valor * desconto);
            return "Pagamento via PIX processado no Brasil, valor final: R$ " + valorFinal;

        } else if(metodo == Metodo.BOLETO) {
            return "Pagamento via Boleto processado no Brasil, valor final: R$ " + valor + ", com compensação em 3 dias úteis";
        }
        return "Método de pagamento inválido.";
    }
}
