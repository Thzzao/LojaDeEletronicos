import java.io.IOException;

import javax.swing.JOptionPane;

public class Menu {
    private Persistencia persistencia;

    public Menu() {
        this.persistencia = new Persistencia();
    }

    public String mostrarMenuInicialEReceberResposta(){

        String mensagemMenuInicial = "Controle Loja de Eletrônicos\n" + "Opções\n"
            + "1. Entrar Eletrônicos\n"
            + "2. Exibir Eletrônicos\n"
            + "3. Limpar Eletrônicos\n"
            + "4. Gravar Eletrônicos\n"
            + "5. Recuperar Eletrônicos\n"
            + "9. Sair\n\n\n";

        String resposta = JOptionPane.showInputDialog(mensagemMenuInicial);
        return resposta;
    }

    public void mostrarMensagemInformeUmaOpcaoValida(){
        JOptionPane.showMessageDialog(null, "Favor informe uma opção válida", "Atenção", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensagemSair(){
        JOptionPane.showMessageDialog(null, "Obrigado, volte sempre", "Sair", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarOpcoesEquipamentos(){
        String mensagem = "Entrada de Equipamentos\n" + "Opções:\n"
            + "1. Notebook\n" + "2. Smartphone\n" + "3. Smartwatch\n\n";
        
        String opcao = JOptionPane.showInputDialog(mensagem);

        switch (opcao) {
            case "1":
                this.setDadosNotebook();
                break;
            case "2":
                this.setDadosSmartphone();
                break;
            case "3":
                this.setDadosSmartwatch();
                break;
            default:
                this.mostrarMensagemInformeUmaOpcaoValida();
                this.mostrarOpcoesEquipamentos();
                break;
        }
    }

    private void setDadosSmartwatch() {
        String nome = JOptionPane.showInputDialog("Informe o Nome do Equipamento");
        String marca = JOptionPane.showInputDialog("Informe a Marca do Equipamento");
        String modelo = JOptionPane.showInputDialog("Informe o Modelo do Equipamento");
        double tamanhoTela = 0;

        try {
            tamanhoTela = Double.parseDouble(JOptionPane.showInputDialog("Informe o Tamanho de Tela"
            + " do Equipamento").replace(',', '.'));
        } catch (NumberFormatException e) {
            this.mostrarMensagemInformeUmaOpcaoValida();
            this.setDadosSmartwatch();
        }

        String materialPulseira = JOptionPane.showInputDialog("Informe o Material da Pulseira");
        String cor = JOptionPane.showInputDialog("Informe a Cor");

        Equipamento equipamento = new Smartwatch(nome, marca, modelo, tamanhoTela, materialPulseira, cor);

        this.persistencia.entrarEquipamento(equipamento);

        int resposta = this.perguntarSeDesejaAdicionarNovoEquipamento();

        if(resposta == 0){
            this.mostrarOpcoesEquipamentos();
        } else {
            mostrarMensagemSair();
        }
    }

    private void setDadosSmartphone() {
        String nome = JOptionPane.showInputDialog("Informe o Nome do Equipamento");
        String marca = JOptionPane.showInputDialog("Informe a Marca do Equipamento");
        String modelo = JOptionPane.showInputDialog("Informe o Modelo do Equipamento");
        double tamanhoTela = 0;
        int quantidadeChips = 0;
        int anoFabricacao = 0;

        try {
            tamanhoTela = Double.parseDouble(JOptionPane.showInputDialog("Informe o Tamanho de Tela"
            + " do Equipamento").replace(',', '.'));

            quantidadeChips = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de Chips"));
            anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog("Informe o Ano de Fabricação"));

        } catch (NumberFormatException e) {
            this.mostrarMensagemInformeUmaOpcaoValida();
            this.setDadosSmartphone();
        }

        Equipamento equipamento = new Smartphone(nome, marca, modelo, tamanhoTela, 
            quantidadeChips, anoFabricacao);
        
        this.persistencia.entrarEquipamento(equipamento);

        int resposta = this.perguntarSeDesejaAdicionarNovoEquipamento();

        if(resposta == 0){
            this.mostrarOpcoesEquipamentos();
        } else {
            mostrarMensagemSair();
        }
    }

    private void setDadosNotebook() {
        String nome = JOptionPane.showInputDialog("Informe o Nome do Equipamento");
        String marca = JOptionPane.showInputDialog("Informe a Marca do Equipamento");
        String modelo = JOptionPane.showInputDialog("Informe o Modelo do Equipamento");
        double tamanhoTela = 0;

        try {
            tamanhoTela = Double.parseDouble(JOptionPane.showInputDialog("Informe o Tamanho de Tela"
            + " do Equipamento").replace(',', '.'));
        } catch (NumberFormatException e) {
            this.mostrarMensagemInformeUmaOpcaoValida();
            this.setDadosNotebook();
        }

        String processador = JOptionPane.showInputDialog("Informe o Processador");
        String memoriaRAM = JOptionPane.showInputDialog("Informe a Memória RAM");
        String sistemaOperacional = JOptionPane.showInputDialog("Informe o Sistema Operacional");

        Equipamento equipamento = new Notebook(nome, marca, modelo, tamanhoTela, 
            processador, memoriaRAM, sistemaOperacional);
        
        this.persistencia.entrarEquipamento(equipamento);
        int resposta = this.perguntarSeDesejaAdicionarNovoEquipamento();

        if(resposta == 0){
            this.mostrarOpcoesEquipamentos();
        } else {
            mostrarMensagemSair();
        }

    }

    private int perguntarSeDesejaAdicionarNovoEquipamento(){
        int resposta = JOptionPane.showOptionDialog(null, "Você deseja inserir novo equipamento?", "Confirmação", 
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 1);
        
        return resposta;
    }

    public void listarEquipamentosNaoSalvos() {
        JOptionPane.showMessageDialog(null,this.persistencia.exibirEquipamentos(),
            "Equipamentos não salvos", JOptionPane.INFORMATION_MESSAGE);
    }

    public void limparEquipamentos() {
        this.persistencia.limparEquipamentos();

        JOptionPane.showMessageDialog(null, "Dados limpos com sucesso", 
            "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public void gravarEquipamentos() {
        try {
            this.persistencia.gravarEquipamentos();
        } catch (NullPointerException e) {
            mostrarMensagemErroTentativaGravarSemInserirEquipamento();
            return;
        }

        JOptionPane.showMessageDialog(null, "Os dados foram armazenados com sucesso."  
            + "A memória temporária será esvaziada.", 
            "Informação", JOptionPane.INFORMATION_MESSAGE);
        
        this.limparEquipamentos();
    }

    public void recuperarEquipamentos() {
        String dadosRecuperados = null;

        try {
            dadosRecuperados = this.persistencia.recuperarEquipamentos();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Houve um erro inesperado." +
                " Tente novamente mais tarde.", "Atenção", JOptionPane.ERROR_MESSAGE);
        }

        JOptionPane.showMessageDialog(null, dadosRecuperados, "Equipamentos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarMensagemArquivoNaoEncontrado(){
        JOptionPane.showMessageDialog(null, "O arquivo de dados não foi encontrado.", 
            "Informação", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarMensagemErroGenericoIO(){
        JOptionPane.showMessageDialog(null, "Houve um problema ao efetuar o processo.", 
            "Informação", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarMensagemErroTentativaGravarSemInserirEquipamento(){
        JOptionPane.showMessageDialog(null, "Insira um equipamento primeiramente", 
            "Informação", JOptionPane.ERROR_MESSAGE);
    }
}
