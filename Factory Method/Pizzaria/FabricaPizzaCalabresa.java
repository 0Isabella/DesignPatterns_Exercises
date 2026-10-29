public class FabricaPizzaCalabresa extends absFabricaPizza{

    @Override
    public Pizza criarPizza() {
        return new PizzaCalabresa();
    }
}