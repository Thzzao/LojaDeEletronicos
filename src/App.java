
public class App {
    public static void main(String[] args) throws Exception {
        boolean opcaoIsValid = false;
        Menu menu = new Menu();

        while(!opcaoIsValid) {

            String opcao = menu.mostrarMenuInicialEReceberResposta();

            switch (opcao) {
                case "1":
                    menu.mostrarOpcoesEquipamentos();
                    break;
                case "2":
                    menu.listarEquipamentosNaoSalvos();
                    break;
                case "3":
                    menu.limparEquipamentos();
                    break;
                case "4":
                    menu.gravarEquipamentos();
                    break;
                case "5":
                    menu.recuperarEquipamentos();
                    break;
                case "9":
                    opcaoIsValid = true;
                    menu.mostrarMensagemSair();
                break;
                default:
                    menu.mostrarMensagemInformeUmaOpcaoValida();
                    break;
            }
        }
        
    }
}
