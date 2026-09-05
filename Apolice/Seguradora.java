public class Seguradora {
    public static void main(String[] args) {

        // Testes para Apólice de Automóvel
		FabricaApolice fabricaAuto = new FabricaAutomovel(60000, 30, 5, 100000);
        fabricaAuto.emitirApolice();

        FabricaApolice fabricaAuto2 = new FabricaAutomovel(60000, 30, 5, 10);
        fabricaAuto2.emitirApolice();

        // Testes para Apólice Residencial
        FabricaApolice fabricaResidencial = new FabricaResidencial(300000, true, true);
        fabricaResidencial.emitirApolice();

        FabricaApolice fabricaResidencial2 = new FabricaResidencial(500000, false, false);
        fabricaResidencial2.emitirApolice();

	}
}