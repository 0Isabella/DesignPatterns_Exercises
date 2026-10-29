import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizzaria {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Pizza> pizzas = new ArrayList<>();
       
        while(true){
            System.out.println("\nPara pedir uma nova pizza, digite o numer correspondente:");
            System.out.println("[ 0 ] - Sair");            
            System.out.println("[ 1 ] - Calabresa");
            System.out.println("[ 2 ] - Quatro Queijos");
            System.out.println("[ 3 ] - Frango com Catupiry");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 0 -> {
                    double total = 0;

                    System.out.println("\n+-Fim do pedido-+");
                    System.out.println("Foi pedido:");

                    for (Pizza pizza : pizzas) {
                        System.out.println("Pizza de " + pizza.nome);
                        total += pizza.preco;
                    }
                    
                    System.out.println("\nValor total: R$" + total);
                    
                    scanner.close();
                    return;
                } 

                case 1 -> {
                    Pizza pizzaCalabresa = new FabricaPizzaCalabresa().criarPizza();
                    pizzas.add(pizzaCalabresa);
                    pizzaCalabresa.resumoPedido();
                }
                case 2 -> {
                    Pizza pizzaQuatroQueijos = new FabricaPizzaQuatroQueijos().criarPizza();
                    pizzas.add(pizzaQuatroQueijos);
                    pizzaQuatroQueijos.resumoPedido();
                }
                case 3 -> {
                    Pizza pizzaFrangoCatupiry = new FabricaPizzaFrangoCatupiry().criarPizza();
                    pizzas.add(pizzaFrangoCatupiry);
                    pizzaFrangoCatupiry.resumoPedido();
                }

                default -> System.out.println("Opção inválida. Tente novamente.");
                
            }
        }
    }
}
