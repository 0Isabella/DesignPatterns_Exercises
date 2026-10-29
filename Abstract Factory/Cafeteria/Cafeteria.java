import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cafeteria{
    public static void main(String[] args) {
      

    Scanner scanner = new Scanner(System.in);

    List<IBebida> bebidas = new ArrayList<>();
    List<IAcompanhamento> acompanhamentos = new ArrayList<>();

   
    while(true){
        System.out.println("\nPara fazer um novo pedido, digite o numero correspondente:");
        System.out.println("[ 0 ] - Sair");            
        System.out.println("[ 1 ] - Combo Tradicional");
        System.out.println("[ 2 ] - Combo Gelado");
        System.out.println("[ 5 ] - Pão de Queijo");
        System.out.println("[ 6 ] - Cookie");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 0 -> {
                double total = 0;

                System.out.println("\n+-Fim do pedido-+");
                System.out.println("Foi pedido:");

                for (IBebida bebida : bebidas) {
               System.out.println(bebida.getNome());
                    total += bebida.getPreco();
                }

                for (IAcompanhamento acompanhamento : acompanhamentos) {
                System.out.println(acompanhamento.getNome());
                    total += acompanhamento.getPreco();
            }
                
                System.out.println("\nValor total: R$" + total);
                
                scanner.close();
                return;
            } 

            case 1 -> {
                IFabricaCombo fabrica = new FabricaComboTradicional();
                IBebida bebida = fabrica.criarBebida();
                IAcompanhamento acompanhamento = fabrica.criarAcompanhamento();

                bebidas.add(bebida);
                acompanhamentos.add(acompanhamento);
            }
            case 2 -> {
                IFabricaCombo fabrica = new FabricaComboGelado();
                IBebida bebida = fabrica.criarBebida();
                IAcompanhamento acompanhamento = fabrica.criarAcompanhamento();

                bebidas.add(bebida);
                acompanhamentos.add(acompanhamento);
            }

            case 3 -> bebidas.add(new Cafe());

            case 4 -> bebidas.add(new CafeGelado());

            case 5 -> acompanhamentos.add(new PaoDeQueijo());
            
            case 6 -> acompanhamentos.add(new Cookie());

            default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}