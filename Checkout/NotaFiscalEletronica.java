public class NotaFiscalEletronica implements IDocumentoFiscal {

    public enum Operacao {
        DENTRO_ESTADO, INTERESTADUAL
    }

    public Operacao operacao;
    public String chaveAcesso;

    public NotaFiscalEletronica(Operacao operacao, String chaveAcesso) {
        this.operacao = operacao;
        this.chaveAcesso = chaveAcesso;
    }

    @Override
    public String gerar() {

        if (chaveAcesso.length() != 44) {
            return "Chave de acesso inválida.";
        }

        if (!chaveAcesso.matches("\\d{44}")) {
            return "Chave de acesso deve conter 44 dígitos.";
        }

        if (operacao == operacao.DENTRO_ESTADO) {

            return "Nota Fiscal Eletrônica gerada"
                    + " - CFOP: 5.102"
                    + ", ICMS: 18%"
                    + ", Chave de Acesso: " + chaveAcesso;

        } else if (operacao == operacao.INTERESTADUAL) {

            return "Nota Fiscal Eletrônica gerada"
                    + " - CFOP: 6.102"
                    + ", ICMS: 12%"
                    + ", Chave de Acesso: " + chaveAcesso;
        }

        return "Tipo de operação inválido.";
    }
}