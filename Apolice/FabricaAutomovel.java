public class FabricaAutomovel extends FabricaApolice {

    public double fipe;
    public int idade;
    public int tempoHabilitado;
    public int cobertura;
    public static int contador = 1;

    public FabricaAutomovel(double fipe, int idade, int tempoHabilitado, int cobertura) {
        this.id = contador++;
        this.fipe = fipe;
        this.idade = idade;
        this.tempoHabilitado = tempoHabilitado;
        this.cobertura = cobertura;
    }

    @Override
    public Apolice criarApolice() {
        return new ApoliceAutomovel(id, fipe, idade, tempoHabilitado, cobertura);
    }
}