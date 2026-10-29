public class VatInvoice implements IDocumentoFiscal {
    
    public double umsatzsteuer;
    public String vatId;

    public VatInvoice(double umsatzsteuer, String vatId) {
        this.umsatzsteuer = umsatzsteuer;
        this.vatId = vatId;
    }

    @Override
    public String gerar() {
        return "VAT Invoice gerada - Umsatzsteuer: " + umsatzsteuer + "%, VAT-ID: " + vatId;
    }
}