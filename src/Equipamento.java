import java.io.Serializable;

public abstract class Equipamento implements Serializable{
    private String nome;
    private String marca;
    private String modelo;
    private double tamanhoTela;

    public Equipamento(String nome, String marca, String modelo, double tamanhoTela, int tipo) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.tamanhoTela = tamanhoTela;
    }

    public double getTamanhoTela() {
        return tamanhoTela;
    }

    public void setTamanhoTela(float tamanhoTela) {
        this.tamanhoTela = tamanhoTela;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        
        String texto = "Marca: " + this.marca + "\n"
            + "Nome: " + this.nome + "\n" 
            + "Modelo: " + this.modelo + "\n"
            + "Tamanho da tela: " + this.tamanhoTela + "\n";
        return texto;
    }

}

