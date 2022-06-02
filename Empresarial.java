package seguradora;

//criando a classe CONTRATO EMPRESARIAL
public class Empresarial {


//criando os atributos da classe
    private Cliente cliente;
    private double valorImovelE;
    private double numerosFuncionarios;
    private double visitasDiarias;
    private String ramo; ////criando os atributos da classe
    private double  calculoEmpresarial;

    public double calcularSeguro (){
        return (double) (getValorImovelE() * 0.04);
    }

    public double valorRamoIndustria (){
        return (double) (getValorImovelE() * 0.01);
    }

    public  double valorRamoComercio () {
        return (double) (getValorImovelE() * 0.005);
    }

//CALCULO DO SUGURO
//4% do valor do móvel somados a:
//0,2% a cada 10 funcionários
//0,3% a cada 200 visitas diárias
//1% se industria
//0,5% se comércio


    //criando os GET AND SET

    public double getCalculoEmpresarial() {
        return calculoEmpresarial;
    }

    public void setCalculoEmpresarial(double calculoEmpresarial) {
        this.calculoEmpresarial = calculoEmpresarial;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorImovelE() {
        return valorImovelE;
    }

    public void setValorImovelE(double valorImovelE) {
        this.valorImovelE = valorImovelE;
    }

    public double getNumerosFuncionarios() {
        return numerosFuncionarios;
    }

    public void setNumerosFuncionarios(double numerosFuncionarios) {
        this.numerosFuncionarios = numerosFuncionarios;
    }

    public double getVisitasDiarias() {
        return visitasDiarias;
    }

    public void setVisitasDiarias(double visitasDiarias) {
        this.visitasDiarias = visitasDiarias;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }
}
