public class Cafe implements IBebida{

    @Override
    public String getNome() {
        return "Café";
    }

    @Override
    public double getPreco() {  
        return 8.00;
    }
}