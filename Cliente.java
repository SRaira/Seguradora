package seguradora;

//criando a classe CLIENTE
public class Cliente {


    //criando os atributos da classe
    private String tipoPessoa;
    private String nome;



    //criando os GET AND SET
    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
