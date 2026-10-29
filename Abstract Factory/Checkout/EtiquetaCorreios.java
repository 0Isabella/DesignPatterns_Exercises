public class EtiquetaCorreios implements IEtiquetaEnvio {

    public String cep;
    
    public EtiquetaCorreios(String cep) {
        this.cep = cep;
    }

    @Override
    public String gerar() {

        return "Etiqueta Correios gerada para o CEP: " + cep;
    }
}