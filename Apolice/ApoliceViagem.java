public class ApoliceViagem extends Apolice {
    
    int diasDeViagem;
    int coberturaMedica;
    boolean internacional;
    boolean passaporte;

    public ApoliceViagem(int id, int diasDeViagem, int coberturaMedica, boolean internacional, boolean passaporte) {
        this.id = id;
        this.diasDeViagem = diasDeViagem;
        this.coberturaMedica = coberturaMedica;
        this.internacional = internacional;
        this.passaporte = passaporte;
    }

    public double calcularPremio(){

        return diasDeViagem * 15 + (internacional ? 100 : 0);
    }

    public boolean validarContratacao(){

        if (internacional){
            return (passaporte && coberturaMedica >= 30000);
        }
        return true;
    }

    public String listarDocumentos(){
        return "Documentos necessários: Itinerário de Viagem e, quando aplicável, Passaporte";
    }

    public void gerarResumo(){

        System.out.println("+ ------------------------------------------------------------------------------------------- +\n") ;
        System.out.println("+ Resumo da Apólice de Viagem +\n") ;
        System.out.println("+ ID da Apólice: VIG-" + this.id + "\n");

            if (!this.validarContratacao()) {
                System.out.println("+ Contratação rejeitada \n");
                System.out.println("+ ------------------------------------------------------------------------------------------- +\n") ;
                return;
            }

        System.out.println("+ Prêmio Mensal: R$: " + this.calcularPremio() + "\n") ;

            if (internacional)
        System.out.println("+ Passaporte: " + (this.validarContratacao() ? "Válido" : "Inválido") + "\n");
            else
        System.out.println("+ Passaporte: " + (this.validarContratacao() ? "Não necessário" : "Inválido") + "\n");
    
        System.out.println("+ " + this.listarDocumentos() + "\n");
        System.out.println("+ ------------------------------------------------------------------------------------------- +\n") ;
    }
}
