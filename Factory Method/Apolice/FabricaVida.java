public class FabricaVida extends FabricaApolice {
    
    public static int contador = 1;
    public int idadeDoSegurado;
    public double capitalSegurado;
    public boolean fumante;
    public boolean atestadoMedico;

    public FabricaVida(int idadeDoSegurado, double capitalSegurado, boolean fumante, boolean atestadoMedico) {
        this.id = contador++;
        this.idadeDoSegurado = idadeDoSegurado;
        this.capitalSegurado = capitalSegurado;
        this.fumante = fumante;
        this.atestadoMedico = atestadoMedico;
    }

    @Override
    public Apolice criarApolice() {
        return new ApoliceVida(id, capitalSegurado, idadeDoSegurado, fumante, atestadoMedico);
    }
    
}
