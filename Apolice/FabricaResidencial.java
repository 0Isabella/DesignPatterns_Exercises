public class FabricaResidencial extends FabricaApolice {
    
    public static int contador = 1;
    public double valorImovel;
    public boolean altoPadrao;
    public boolean escrituraOuContrato;
    

    public FabricaResidencial(double valorImovel, boolean altoPadrao, boolean escrituraOuContrato) {
        this.id = contador++;
        this.valorImovel = valorImovel;
        this.altoPadrao = altoPadrao;
        this.escrituraOuContrato = escrituraOuContrato;
    }

    @Override
    public Apolice criarApolice() {
        return new ApoliceResidencial(id, valorImovel, altoPadrao, escrituraOuContrato);
    }
} 
