public class FabricaPizzaQuatroQueijos extends absFabricaPizza{

    @Override
    public Pizza criarPizza(){
        return new PizzaQuatroQueijos();
    }
}