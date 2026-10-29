public class FabricaPizzaFrangoCatupiry extends absFabricaPizza{

	@Override
	public Pizza criarPizza() {
		return new PizzaFrangoCatupiry();
	}
}