public class FabricaComboTradicional implements IFabricaCombo{

    @Override
    public IBebida criarBebida() {
        return new Cafe();
    }

    @Override
    public IAcompanhamento criarAcompanhamento() {
        return new PaoDeQueijo();
    }
    
}
