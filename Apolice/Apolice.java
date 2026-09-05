public abstract class Apolice {
    public int id;

    public double calcularPremio(){
        return 0;
    }

    public boolean validarCobertura(){
        return true;
    }

    public String listarDocumentos(){
        return "";
    }

    public void gerarResumo(){
        System.out.println("Resumo da Apólice:");
    }
}