

public class Notebook extends Equipamento {
    private String processador;
    private String memoriaRAM;
    private String sistemaOperacional;

    public Notebook(String nome, String marca, String modelo, double tamanhoTela, 
        String processador, String memoriaRAM, String sistemaOperacional) {
        super(nome, marca, modelo, tamanhoTela, 1);
        this.processador = processador;
        this.memoriaRAM = memoriaRAM;
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getProcessador() {
        return processador;
    }
    public void setProcessador(String processador) {
        this.processador = processador;
    }
    public String getMemoriaRAM() {
        return memoriaRAM;
    }
    public void setMemoriaRAM(String memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }
    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }


    @Override
    public String toString() {
         String stringBase = super.toString();
         String stringClasse = "Tipo: Notebook\n" + stringBase
              + "Processador: " + this.processador + "\n"
              + "RAM: " + this.memoriaRAM + "\n"
              + "Sistema Operacional: " + this.sistemaOperacional + "\n";
         
         return stringClasse;
    }



}
