public class Smartwatch extends Equipamento {
    private String materialPulseira;
    private String cor;

    public Smartwatch(String nome, String marca, String modelo, double tamanhoTela, String materialPulseira, String cor) {
        super(nome, marca, modelo, tamanhoTela, 3);
        this.cor = cor;
        this.materialPulseira = materialPulseira;
    }

    public String getMaterialPulseira() {
        return materialPulseira;
    }
    public void setMaterialPulseira(String materialPulseira) {
        this.materialPulseira = materialPulseira;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        String stringBase = super.toString();
        String stringClasse = stringBase + "Material da pulseira: " + this.materialPulseira + "\n"
            + "Cor: " + this.cor + "\n";

        return stringClasse;
    }
}
