import java.util.List;
import java.util.Scanner;

class GerenciarAgenda{
    public static StringBuilder sb = new StringBuilder(1024*4);
    public static Scanner s = new Scanner(System.in);
    public static ServicoImobiliaria servico = new ServicoImobiliaria();
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
        sb.append("7-Relatórios;           ").append(MAGENTA).append("8-Sair do Sistema\n\n").append(RESET);
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
            limpaTela();
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
        try{
            System.out.println("====CADASTRO DE CLIENTE====\n");
            System.out.print("Nome: ");
            String nome = s.nextLine();
            System.out.print("CPF: ");
            String cpf = s.nextLine();
            System.out.print("Telefone: ");
            String telefone = s.nextLine();
            System.out.print("E-mail: ");
            String email = s.nextLine();

            Cliente c = new Cliente(nome, cpf, telefone, email);
            servico.cadastrarCliente(c);
        }catch(CpfInvalidoException | NomeInvalidoException | TelefoneInvalidoException | EmailInvalidoException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void cadastrarImovel() {
        Imovel imovel = null;
        try{
            System.out.println("====CADASTRO DE IMOVEL====\n");
            System.out.print("Logradouro: ");
            String logradouro = s.nextLine();
            System.out.print("Número: ");
            int numero = Integer.parseInt(s.nextLine());
            System.out.print("Bairro: ");
            String bairro = s.nextLine();
            System.out.print("Cidade: ");
            String cidade = s.nextLine();
            Endereco endereco = new Endereco(logradouro, numero, bairro, cidade);

            System.out.print("Valor: ");
            double valor = Double.parseDouble(s.nextLine());
            System.out.print("Área: ");
            double area = Double.parseDouble(s.nextLine());

            System.out.println("\nTipo do Imóvel: 1-Casa; 2-Apartamento; 3-Terreno");
            System.out.print("R: ");
            String tipo = s.nextLine();
            switch (tipo) {
                case "1":
                    System.out.print("Nº de Quartos: ");
                    int nrQuartos = Integer.parseInt(s.nextLine());
                    System.out.print("Possui Garagem (S/N): ");
                    boolean garagem = s.nextLine().trim().equalsIgnoreCase("S");
                    System.out.print("IPTU: ");
                    double iptuCasa = Double.parseDouble(s.nextLine());
                    imovel = new Casa(endereco, valor, area, nrQuartos, garagem, iptuCasa);
                    break;
                case "2":
                    System.out.print("Andar: ");
                    int andar = Integer.parseInt(s.nextLine());
                    System.out.print("Nº do Apartamento: ");
                    int numeroApt = Integer.parseInt(s.nextLine());
                    System.out.print("Valor do Condomínio: ");
                    double vlrCondominio = Double.parseDouble(s.nextLine());
                    System.out.print("IPTU: ");
                    double iptuApt = Double.parseDouble(s.nextLine());
                    imovel = new Apartamento(endereco, valor, area, andar, numeroApt, vlrCondominio, iptuApt);
                    break;
                case "3":
                    System.out.println("Tipo do Terreno: 1-Residencial; 2-Comercial");
                    System.out.print("R: ");
                    String tipoTerreno = s.nextLine();
                    TipoTerreno tt = (tipoTerreno.equals("2")) ? TipoTerreno.Comercial : TipoTerreno.Residencial;
                    imovel = new Terreno(endereco, valor, area, tt);
                    break;
                default:
                    System.out.println("\nTipo de Imóvel Inválido!");
                    return;
            }
        }catch(ValorImovelInvalidoException | AreaInvalidaException e){
            System.out.println("Erro: " + e.getMessage());
            return;
        }catch(NumberFormatException e){
            System.out.println("\nErro: valor numérico inválido.");
        }
        servico.cadastrarImovel(imovel);
        System.out.println("\nImóvel Cadastrado com Sucesso! Código: "+imovel.getCod());

    }

    private static void listarImoveis() {
        System.out.println("====LISTA DE IMOVEIS====\n");
        List<Imovel> imoveis = servico.getImoveis();
        if(imoveis.isEmpty()){
            System.out.println("\nNenhum Imóvel Cadastrado.");
            return;
        }
        for (Imovel i : imoveis) {
            System.out.println(i);
        }
    }

    private static void alugarImovel() {
        try{
            System.out.println("====ALUGAR IMOVEL====\n");
            Imovel imovel = lerImovel();
            if(imovel == null){
                System.out.println("\nTipo de Imóvel Inválido!");
                return;
            }

            System.out.print("Nome do Locatário: ");
            String nome = s.nextLine();
            System.out.print("CPF do Locatário: ");
            String cpf = s.nextLine();
            System.out.print("Telefone do Locatário: ");
            String telefone = s.nextLine();
            System.out.print("E-mail do Locatário: ");
            String email = s.nextLine();
            Cliente locatario = new Cliente(nome, cpf, telefone, email);

            System.out.print("Valor Mensal: "); 
            double valorMensal = Double.parseDouble(s.nextLine()); //NumberFormat

            servico.alugarImovel(imovel, locatario, valorMensal);

        }catch(NomeInvalidoException | CpfInvalidoException | TelefoneInvalidoException | EmailInvalidoException e){
            System.out.println("Erro: "+ e.getMessage()); 
        }catch(NumberFormatException e){
            System.out.println("\nErro: valor numérico inválido.");
        }
    }

    private static void buscarImovel() {
        System.out.println("====BUSCAR IMOVEL====\n");
        System.out.println("Buscar por: 1-Tipo (Casa/Apartamento/Terreno); 2-Status (Disponivel/Alugado/Vendido)");
        System.out.print("R: ");
        String opcao = s.nextLine();
        List<Imovel> resultado;
        if(opcao.equals("1")){
            System.out.print("Tipo: ");
            String tipo = s.nextLine();
            resultado = servico.buscarImovelPorTipo(tipo);
        }else if(opcao.equals("2")){
            System.out.print("Status: ");
            String status = s.nextLine();
            resultado = servico.buscarImovelPorStatus(status);
        }else{
            System.out.println("\nOpção Inválida!");
            return;
        }

        if(resultado.isEmpty()){
            System.out.println("\nNenhum Imóvel Encontrado.");
            return;
        }
        for (Imovel i : resultado) {
            System.out.println(i);
        }

    }

    private static void venderImovel() {
        try{
            System.out.println("====VENDER IMOVEL====");
            Imovel imovel = lerImovel();
            if(imovel == null){
                System.out.println("\nTipo de Imóvel Inválido!");
                return;
            }

            System.out.print("Nome do Comprador: ");
            String nome = s.nextLine();
            System.out.print("CPF do Comprador: ");
            String cpf = s.nextLine();
            System.out.print("Telefone do Comprador: ");
            String telefone = s.nextLine();
            System.out.print("E-mail do Comprador: ");
            String email = s.nextLine();
            Cliente comprador = new Cliente(nome, cpf, telefone, email);

            servico.venderImovel(imovel, comprador); //NumberFormat

        }catch(CpfInvalidoException | NomeInvalidoException | TelefoneInvalidoException | EmailInvalidoException e){
            System.out.println("Erro: " + e.getMessage());
        }catch(NumberFormatException e){
            System.out.println("\nErro: valor numérico inválido.");
        }
    }

    private static void relatorios() {
        System.out.println("====GERAR RELATORIO====");
        servico.gerarRelatorios();
    }

    private static Imovel lerImovel() throws NumberFormatException {
        Imovel imovel = null;

        System.out.println("\nTipo do Imóvel: 1-Casa; 2-Apartamento; 3-Terreno");
        System.out.print("R: ");
        String tipo = s.nextLine();

        System.out.print("Código do Imóvel: ");

        int cod = Integer.parseInt(s.nextLine());

        switch (tipo) {
            case "1":
                imovel = new Casa();
                break;
            case "2":
                imovel = new Apartamento();
                break;
            case "3":
                imovel = new Terreno();
                break;
            default:
                return null;
        }

        imovel.setCod(cod);

        return imovel;
    }
}

