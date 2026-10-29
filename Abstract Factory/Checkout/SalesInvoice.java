public class SalesInvoice implements IDocumentoFiscal {
    
    public double salesTax;
    public String ein;

    public SalesInvoice(double salesTax, String ein) {
        this.salesTax = salesTax;
        this.ein = ein;
    }

    @Override
    public String gerar() {
        return "Sales Invoice gerou - Sales Tax: " + salesTax + "%, EIN: " + ein;
    }
}