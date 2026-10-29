public class EtiquetaUSPS implements IEtiquetaEnvio {
    
    public String zipPlus4;

    public EtiquetaUSPS(String zipPlus4) {
        this.zipPlus4 = zipPlus4;
    }

    @Override
    public String gerar() {
        return "Etiqueta USPS gerada para o ZIP+4: " + zipPlus4;
    }
}