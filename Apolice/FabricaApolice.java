public abstract class FabricaApolice {
    public int id;
    
    public abstract Apolice criarApolice();

    public void emitirApolice() {
        Apolice apolice = criarApolice();
        apolice.gerarResumo();
    }
}