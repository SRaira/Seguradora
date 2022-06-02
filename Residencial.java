package seguradora;

//criando a classe CONTRATO RESIDENCIAL
public class Residencial {


    //criando os atributos da classe
    private Cliente cliente;
    private String endereco;
    private double valorImovelR;
    private String zona;  // urbana suburbana e rural
    private String tipoResidencia; //apartamento ou casa

    public double calcularSeguro (){
        return (double) (getValorImovelR() * 0.02);
    }

    public double valorSeguroUrbano (){
        return (double) (getValorImovelR() * 0.01);
    }

    public double valorSeguroSuburbano (){
        return (double) (getValorImovelR() * 0.005);
    }

    public  double valorTipoResidencia () {
        return (double) (getValorImovelR() * 0.005);
    }

//CALCULO DO SUGURO
//2% do valor do móvel somados a:
//1% se zona urbana
//0,5% se zona suburbana
//0,5% se casa.



    //criando os GET AND SET


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getValorImovelR() {
        return valorImovelR;
    }

    public void setValorImovel(double valorImovelR) {
        this.valorImovelR = valorImovelR;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getTipoResidencia() {
        return tipoResidencia;
    }

    public void setTipoResidencia(String tipoResidencia) {
        this.tipoResidencia = tipoResidencia;
    }
}
