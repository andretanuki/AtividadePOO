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

    public void venderImovel(Imovel i, Cliente comprador){
        throw new UnsupportedOperationException("Unimplemented method");
    }

    public void alugarImovel(Imovel i , Cliente locatario, double valorMensal){
        throw new UnsupportedOperationException("Unimplemented method");
    }

    public List<Imovel> buscarImovelPorTipo(String tipo){
        throw new UnsupportedOperationException("Unimplemented method");
    }

    public List<Imovel> buscarImovelPorStatus(String status){
        throw new UnsupportedOperationException("Unimplemented method");
    }

    public void gerarRelatorio(){
        throw new UnsupportedOperationException("Unimplemented method");
    }
}

