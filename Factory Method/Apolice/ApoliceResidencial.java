public class ApoliceResidencial extends Apolice {

    public double valorImovel;
    public boolean altoPadrao;
    public boolean escrituraOuContrato;

    public ApoliceResidencial(int id, double valorImovel, boolean altoPadrao, boolean escrituraOuContrato) {
        this.id = id;
        this.valorImovel = valorImovel;
        this.altoPadrao = altoPadrao;
        this.escrituraOuContrato = escrituraOuContrato;
    }

    public double calcularPremio(){

        double premioMensal = this.valorImovel * 0.015 / 12;

        if (altoPadrao == true){
            premioMensal *= 1.25;
        }

        return premioMensal;
    }

    public boolean validarContratacao(){
        return escrituraOuContrato;
    }

    public String listarDocumentos(){
        return "Documentos necessários: Escritura ou Contrato de Locação, Comprovante de Residência";
    }

    public void gerarResumo(){

        System.out.println("+ ------------------------------------------------------------------------------------- +\n") ;
        System.out.println("+ Resumo da Apólice Residencial +\n") ;
        System.out.println("+ ID da Apólice: RES-" + this.id + "\n");

            if (!this.validarContratacao()) {
                System.out.println("+ Contratação rejeitada \n");
                System.out.println("+ ------------------------------------------------------------------------------------- +\n") ;
                return;
            }

        System.out.println("+ Prêmio Mensal: R$: " + this.calcularPremio() + "\n") ;
        System.out.println("+ Escritura ou Contrato: " + (this.validarContratacao() ? "Presente" : "Ausente") + "\n");
        System.out.println("+ " + this.listarDocumentos() + "\n");
        System.out.println("+ ------------------------------------------------------------------------------------- +\n") ;
    }
}
