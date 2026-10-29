public abstract class Pizza {
    
    public String nome;
    public double preco;

    public Pizza(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public String prepararPizza(){
        return "Preparando pizza de " + nome;
    }

    public String assandoPizza(){
        return "Assando pizza de " + nome;
    }

    public String cortarPizza(){
        return "Cortando pizza de " + nome;
    }

    public String embalarPizza(){
        return "Embalando pizza de " + nome;
    }

    public void resumoPedido(){
        System.out.println("\n \n+- Resumo do Pedido -+ \n");
        System.out.println(prepararPizza());
        System.out.println(assandoPizza());
        System.out.println(cortarPizza());
        System.out.println(embalarPizza());
        System.out.println("\n+- Pedido pronto! -+\n");
        System.out.println("Pizza de: " + nome);
        System.out.println("Valor: " + preco);
    }
}
