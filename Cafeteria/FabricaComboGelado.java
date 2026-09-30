public class FabricaComboGelado implements IFabricaCombo{

    @Override
    public IBebida criarBebida() {
        return new CafeGelado();
    }

    @Override
    public IAcompanhamento criarAcompanhamento() {
        return new Cookie();
    }
}
