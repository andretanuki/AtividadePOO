import java.util.Scanner;

class GerenciarAgenda{
    public static StringBuilder sb = new StringBuilder(1024*4);
    public static Scanner s = new Scanner(System.in);
    public static final String  CLEAR_SCREEN_HOME   = "\033[H\033[2J",
                                RESET               = "\033[0m",
                                YELLOW              = "\033[33m",
                                BLUE                = "\033[34m",
                                MAGENTA             = "\033[35m",
                                CYAN                = "\033[36m",
                                WHITE               = "\033[37m";

    public static void limpaTela(){
        System.out.println(CLEAR_SCREEN_HOME);
    }

    public static void pressioneEnter(){
        System.out.println("\nPressione <Enter> para Continuar");
        s.nextLine();
    }

    public static String escreveMenu(){
        sb.append(CLEAR_SCREEN_HOME);
        sb.append(BLUE).append("Digite a sua Opção:\n\n").append(RESET);
        sb.append("1-Cadastrar Cliente;    2-Cadastrar Imóvel;    3-Listar Imóveis;\n");
        sb.append("4-Vender Imóvel;        5-Alugar Imóvel;       6-Buscar Imóvel;\n");
        sb.append("7-Relatórios;           ").append(MAGENTA).append("8-Sair do Systema\n\n").append(RESET);
        sb.append("R:").append(BLUE);
        System.out.print(sb.toString());
        String resposta = s.nextLine();
        System.out.println(RESET);
        sb.setLength(0);
        return resposta;
    }

    public static void main(String[] args) {
        String resposta = null;
        do{
            resposta = escreveMenu();

            switch (resposta) {
                case "1":
                    cadastrarCliente();
                    break;
                case "2":
                    cadastrarImovel();
                    break;
                case "3":
                    listarImoveis();
                    break;
                case "4":
                    venderImovel();
                    break;
                case "5":
                    alugarImovel();
                    break;
                case "6":
                    buscarImovel();
                    break;
                case "7":
                    relatorios();
                    break;
                case "8":
                    System.out.println("\nSaindo...");
                    break;
                default:
                    System.out.println("\nOpção Invalida!");
                    break;
            }
            pressioneEnter();
        }while(!resposta.equals("8"));
        s.close();
    }

    private static void cadastrarCliente() {
    }

    private static void cadastrarImovel() {
    }

    private static void listarImoveis() {
    }

    private static void alugarImovel() {
    }

    private static void buscarImovel() {
    }

    private static void venderImovel() {
    }

    private static void relatorios() {
    }
}

