public class FabricaViagem extends FabricaApolice {
    
    public static int contador = 1;
    public int diasDeViagem;
    public int coberturaMedica;
    public boolean internacional;
    public boolean passaporte;

    public FabricaViagem(int diasDeViagem, int coberturaMedica, boolean internacional, boolean passaporte) {
        this.id = contador++;
        this.diasDeViagem = diasDeViagem;
        this.coberturaMedica = coberturaMedica;
        this.internacional = internacional;
        this.passaporte = passaporte;
    }

    @Override
    public Apolice criarApolice() {
        return new ApoliceViagem(id, diasDeViagem, coberturaMedica, internacional, passaporte);
    }
    
}
