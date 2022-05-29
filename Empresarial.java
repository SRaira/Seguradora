package seguradora;

//criando a classe CONTRATO EMPRESARIAL
public class Empresarial {


//criando os atributos da classe
    private Cliente cliente;
    private Float valorImovelE;
    private int numerosFuncionarios;
    private int visitasDiarias;
    private String ramo; ////criando os atributos da classe
    private Float calculoEmpresarial;

//CALCULO DO SUGURO
//4% do valor do móvel somados a:
//0,2% a cada 10 funcionários
//0,3% a cada 200 visitas diárias
//1% se industria
//0,5% se comércio


    //criando os GET AND SET

    public Float getCalculoEmpresarial() {
        return calculoEmpresarial;
    }

    public void setCalculoEmpresarial(Float calculoEmpresarial) {
        this.calculoEmpresarial = calculoEmpresarial;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Float getValorImovelE() {
        return valorImovelE;
    }

    public void setValorImovelE(Float valorImovelE) {
        this.valorImovelE = valorImovelE;
    }

    public int getNumerosFuncionarios() {
        return numerosFuncionarios;
    }

    public void setNumerosFuncionarios(int numerosFuncionarios) {
        this.numerosFuncionarios = numerosFuncionarios;
    }

    public int getVisitasDiarias() {
        return visitasDiarias;
    }

    public void setVisitasDiarias(int visitasDiarias) {
        this.visitasDiarias = visitasDiarias;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }
}
