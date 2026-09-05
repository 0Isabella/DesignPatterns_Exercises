public class EtiquetaDeutschePost implements IEtiquetaEnvio {
    
    public String plz;

    public EtiquetaDeutschePost(String plz) {
        this.plz = plz;
    }
    
    @Override
    public String gerar() {
        return "Etiqueta Deutsche Post gerada para o PLZ: " + plz;
    }
}