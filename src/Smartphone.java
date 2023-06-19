

public class Smartphone extends Equipamento {
     protected int quantidadeChips;
     protected int anoFabricacao;

     public Smartphone(String nome, String marca, String modelo, double tamanhoTela, int quantidadeChips, int anoFabricacao) {
          super(nome, marca, modelo, tamanhoTela, 2);
          this.anoFabricacao = anoFabricacao;
          this.quantidadeChips = quantidadeChips;
     }

     public int getQuantidadeChips() {
          return quantidadeChips;
     }
     public void setQuantidadeChips(int quantidadeChips) {
          this.quantidadeChips = quantidadeChips;
     }
     public int getAnoFabricacao() {
          return anoFabricacao;
     }
     public void setAnoFabricacao(int anoFabricacao) {
          this.anoFabricacao = anoFabricacao;
     }

     @Override
     public String toString() {
          String stringBase = super.toString();
          String stringClasse = 
               "Tipo: Smartphone\n" + stringBase 
               + "Ano de fabricação: " + anoFabricacao + "\n"
               + "Quantidade de chips: " + quantidadeChips + "\n";
          
          return stringClasse;
     }

}