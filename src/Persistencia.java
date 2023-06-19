import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Persistencia {
    
    private ArrayList<Equipamento> listaDeEquipamentos;

    public Persistencia() {
        this.listaDeEquipamentos = new ArrayList<Equipamento>();
    }

    public void entrarEquipamento(Equipamento equipamento){
        listaDeEquipamentos.add(equipamento);
    }

    public String exibirEquipamentos(){
        String resultado = "";

        if(listaDeEquipamentos.isEmpty())
        {
            resultado = "Entre com equipamentos primeiramente.";
            return resultado;
        }

        for (Equipamento equipamento : listaDeEquipamentos) {
            resultado += equipamento.toString() + "\n\n";
        }

        return resultado;
    }

    public void limparEquipamentos(){
        listaDeEquipamentos.clear();
    }

    public void gravarEquipamentos(){
        if(listaDeEquipamentos.isEmpty())
            throw new NullPointerException();

        try {
            String textoJaSalvo = "";
            
            try {
                InputStream is = new FileInputStream("equipamentos.txt");
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
    
                String linha;
                try {
                    linha = br.readLine();
                } catch (IOException e) {
                    linha = null;
                    Menu.mostrarMensagemErroGenericoIO();
                }
    
                while(linha != null){
                    textoJaSalvo += linha + "\n";
                    linha = br.readLine();
                }
    
                br.close();
            } catch (FileNotFoundException e) {
                Menu.mostrarMensagemArquivoNaoEncontrado();;
            }

            OutputStream os = new FileOutputStream("equipamentos.txt");
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            for (Equipamento equipamento : listaDeEquipamentos) {
                String informacoesDoEquipamento = equipamento.toString();
                String textoASalvar = textoJaSalvo + "\n" + informacoesDoEquipamento;
                bw.write(textoASalvar);
                bw.newLine();
            }

            bw.close();
            listaDeEquipamentos.clear();

        } catch (FileNotFoundException e) {
            Menu.mostrarMensagemArquivoNaoEncontrado();
        } catch (IOException e) {
            Menu.mostrarMensagemErroGenericoIO();
        }
        
    }

    public String recuperarEquipamentos() throws IOException{
        String resultado = "";
        
        try {
            InputStream is = new FileInputStream("equipamentos.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String linha;
            try {
                linha = br.readLine();
            } catch (IOException e) {
                linha = null;
                Menu.mostrarMensagemErroGenericoIO();
            }

            while(linha != null){
                resultado += linha + "\n";
                linha = br.readLine();
            }

            br.close();
        } catch (FileNotFoundException e) {
            Menu.mostrarMensagemArquivoNaoEncontrado();;
        }

        if(resultado.isBlank())
            resultado = "Não foram encontrados registros de Equipamento.";

        return resultado;
    }

}
