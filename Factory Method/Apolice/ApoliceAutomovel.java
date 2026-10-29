public class ApoliceAutomovel extends Apolice {

    public double fipe;
    public int condutorIdade;
    public int tempoHabilidado;
    public int cobertura;

    public ApoliceAutomovel(int id, double fipe, int condutorIdade, int tempoHabilidado, int cobertura) {
        this.id = id;
        this.fipe = fipe;
        this.condutorIdade = condutorIdade;
        this.tempoHabilidado = tempoHabilidado;
        this.cobertura = cobertura;
    }

    @Override
    public double calcularPremio() {

        double premioMensal = this.fipe * 0.08 / 12;

        if (condutorIdade < 25){
            premioMensal *= 1.3;
        }
        if (tempoHabilidado < 2){
            premioMensal *= 1.2;
        }

        return premioMensal;
    }

    @Override
    public boolean validarContratacao() {

        return cobertura >= 50000;
    }

    @Override
    public String listarDocumentos() {
        return "Documentos necessários: CNH, CRLV, Comprovante de Residência";
    }

    @Override
    public void gerarResumo() {

        System.out.println("+ -------------------------------------------------------------- +\n") ;
        System.out.println("+ Resumo da Apólice de Automóvel +\n") ;
        System.out.println("+ ID da Apólice: AUTO-" + this.id + "\n");

            if (!this.validarContratacao()) {
                System.out.println("+ Contratação rejeitada \n");
                System.out.println("+ -------------------------------------------------------------- +\n") ;
                return;
            }

        System.out.println("+ Prêmio Mensal: R$: " + this.calcularPremio() + "\n") ;
        System.out.println("+ Cobertura: " + (this.validarContratacao() ? "Válida" : "Inválida") + "\n");
        System.out.println("+ " + this.listarDocumentos() + "\n");
        System.out.println("+ -------------------------------------------------------------- +\n") ;
    }
}