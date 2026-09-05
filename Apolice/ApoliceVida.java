public class ApoliceVida extends Apolice {

    public int idadeDoSegurado;
    public double capitalSegurado;
    public boolean fumante;
    public boolean atestadoMedico;

    public ApoliceVida(int id, double capitalSegurado, int idadeDoSegurado, boolean fumante, boolean atestadoMedico) {
        this.id = id;
        this.capitalSegurado = capitalSegurado;
        this.idadeDoSegurado = idadeDoSegurado;
        this.fumante = fumante;
        this.atestadoMedico = atestadoMedico;
    }

    public double calcularPremio(){
        
        double premioMensal = idadeDoSegurado * 12 + capitalSegurado * 0.002;

        if (fumante == true){
            premioMensal *= 1.5;
        }
        
        return premioMensal;
    }

    public boolean validarContratacao(){

        return (capitalSegurado > 500000 && atestadoMedico == false) ? false : true;
    }

    public String listarDocumentos(){
        return "Documentos necessários: Documento de identidade, CPF e, quando aplicável, Atestado Médico";
    }

    public void gerarResumo(){

        System.out.println("+ ------------------------------------------------------------------------------------------- +\n") ;
        System.out.println("+ Resumo da Apólice de Vida +\n") ;
        System.out.println("+ ID da Apólice: VID-" + this.id + "\n");

            if (!this.validarContratacao()) {
                System.out.println("+ Contratação rejeitada \n");
                System.out.println("+ ------------------------------------------------------------------------------------------- +\n") ;
                return;
            }

        System.out.println("+ Prêmio Mensal: R$: " + this.calcularPremio() + "\n") ;

            if (capitalSegurado > 500000)
                System.out.println("+ Atestado Médico: " + (this.validarContratacao() ? "Presente" : "Ausente") + "\n");

        System.out.println("+ Atestado Médico: " + (this.validarContratacao() ? "Não necessário" : "Inválido") + "\n");
        System.out.println("+ " + this.listarDocumentos() + "\n");
        System.out.println("+ ------------------------------------------------------------------------------------------- +\n") ;
    }
}
