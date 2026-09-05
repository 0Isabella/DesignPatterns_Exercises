public class Seguradora {
    public static void main(String[] args) {

		FabricaApolice fabricaAuto = new FabricaAutomovel(60000, 30, 5, 100000);
        fabricaAuto.emitirApolice();

        FabricaApolice fabricaAuto2 = new FabricaAutomovel(60000, 30, 5, 10);
        fabricaAuto2.emitirApolice();

	}
}