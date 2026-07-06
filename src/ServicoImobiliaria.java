import java.util.ArrayList;
import java.util.List;

public class ServicoImobiliaria{
    private ArrayList<Cliente> clientes;
    private ArrayList<Imovel> imoveis;
    private ArrayList<Contrato> contratos;

    public ServicoImobiliaria() {
        clientes  = new ArrayList<Cliente>(1024);
        imoveis   = new ArrayList<Imovel>(1024);
        contratos = new ArrayList<Contrato>(1024);
    }

    public void cadastrarCliente(Cliente c) throws CpfJaExisteException{
        if(this.clientes.contains(c)) throw new CpfJaExisteException();
        clientes.add(c);
    }

    public void cadastrarImovel(Imovel i) throws ImovelIndisponivelException{
        if(this.imoveis.contains(i)) throw new ImovelIndisponivelException("O imovel já está cadastrado");
        imoveis.add(i);
    }

    public void venderImovel(Imovel i, Cliente comprador) {
        try{
            Cliente clienteSelecionado =  buscarCliente(comprador);
            Imovel imovelSelecionado =  buscarImovelDisponivel(i);

            if(clienteSelecionado==null)  throw new DadoIndisponivelException(comprador); 
            if(imovelSelecionado == null) throw new DadoIndisponivelException(i); 

            contratos.add(new Contrato(clienteSelecionado, imovelSelecionado, "Venda"));
            imovelSelecionado.setStatus(StatusImovel.Vendido);

            System.out.println("Venda Realizada com Sucesso");

        }catch(DadoIndisponivelException | ImovelIndisponivelException e){
            System.out.println("Erro ao Realizar a Venda: "+e.getMessage());
        }

    }

    public void alugarImovel(Imovel i , Cliente locatario, double valorMensal) {
        try{
            Cliente clienteSelecionado =  buscarCliente(locatario);
            Imovel imovelSelecionado = buscarImovelDisponivel(i);

            if(clienteSelecionado==null)  throw new DadoIndisponivelException(locatario); 
            if(imovelSelecionado == null) throw new DadoIndisponivelException(i); 

            Contrato novoContrato = new Contrato(clienteSelecionado, imovelSelecionado, "Aluguel", valorMensal);
            imovelSelecionado.setStatus(StatusImovel.Alugado);
            contratos.add(novoContrato);

        }catch (ImovelIndisponivelException | DadoIndisponivelException | ValorImovelInvalidoException e ){
            System.out.println("Erro ao Alugar Imovel: "+ e.getMessage());
        }
    }

    private Cliente buscarCliente(Cliente c){
        for (Cliente cliente : clientes) {
            if(c.equals(cliente)) return cliente;
        }
        return null;
    }

    private Imovel buscarImovelDisponivel(Imovel i) throws ImovelIndisponivelException{
        for (Imovel imovel : imoveis) {
            if(imovel.equals(i)){
                if(!(imovel.getStatus()==StatusImovel.Disponivel)) throw new ImovelIndisponivelException();
                return imovel;
            }
        }
        return null;
    }


    public List<Imovel> buscarImovelPorTipo(String tipo){
        List<Imovel> imoveis = new ArrayList<Imovel>();
        for (Contrato c: contratos) {
            if(c.getTipoContrato().equals(tipo)){
                imoveis.add(c.getImovel());
            }
        }   
        return imoveis;
    }

    public List<Imovel> buscarImovelPorStatus(String status){

        List<Imovel> imovelStatus  = new ArrayList<Imovel>();

        StatusImovel statusSelecionado;
        if(status.toUpperCase().equals("VENDIDO")) statusSelecionado = StatusImovel.Vendido;
        else if(status.toUpperCase().equals("ALUGADO")) statusSelecionado = StatusImovel.Alugado;
        else if(status.toUpperCase().equals("DISPONIVEL")) statusSelecionado = StatusImovel.Disponivel;
        else throw new IllegalArgumentException("Tipo de Status nao Existe");

        for (Imovel i: imoveis) {
            if(i.getStatus() == statusSelecionado){
                imovelStatus.add(i);
            }
        }   
        return imovelStatus;
    }

    public void gerarRelatorio(){
        int quantidadeImovelDisponivel = 0;
        int quantidadeImovelAlugado = 0;
        int quantidadeImovelVendido = 0;
        Imovel imovelMaisCaro = null;
        double valorMaisCaro=0 , totalVendidos =0, totalAlugueis=0;

        for (Imovel i : imoveis) {
            if(i.getStatus() == StatusImovel.Disponivel)quantidadeImovelDisponivel++;
            else if(i.getStatus()==StatusImovel.Vendido) quantidadeImovelVendido++;
            else if(i.getStatus()==StatusImovel.Alugado) quantidadeImovelAlugado++ ;

            double valorAtual = i.calculaValorFinal();
            if(valorAtual>valorMaisCaro){
                valorMaisCaro=valorAtual;
                imovelMaisCaro = i;
            }
        }
        for (Contrato c : contratos) {
            if(c.getTipoContrato().equals("Aluguel")) totalAlugueis+=c.getValorAcordado();
            else if(c.getTipoContrato().equals("Venda")) totalVendidos+=c.getValorAcordado();
            
        }

        System.out.println("=====RELATORIO IMOBILIARIO=====");
        System.out.println();
        System.out.println("Total de Imoveis Disponivel: "+quantidadeImovelDisponivel);
        System.out.println();
        System.out.println("Total de Imoveis Vendido: "+quantidadeImovelVendido);
        System.out.println("Total Arrecadado com Vendas: "+totalVendidos);
        System.out.println();
        System.out.println("Total de Imoveis Alugado: "+quantidadeImovelAlugado);
        System.out.println("Total Arrecadado com Alugueis: "+totalAlugueis);
        System.out.println();
        System.out.println("Imovel mais caro: \n" + ((imovelMaisCaro==null)?"Não há":imovelMaisCaro.toString()));
    }
}

