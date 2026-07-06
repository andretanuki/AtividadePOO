
public class DadoIndisponivelException extends Exception{

    public DadoIndisponivelException() {
        super("Tentativa de Acesso a Objeto nao Cadastrado na Base de Dados");
    }

    public DadoIndisponivelException(String message) {
        super(message);
    }

    public DadoIndisponivelException(Cliente c) {
        super("Cliente "+ c.getCpf() + "nao encontrado na nossa base de Dados");
    }

    public DadoIndisponivelException(Imovel i) {
        super("Imovel "+ i.getCod() + "nao encontrado na nossa base de Dados");
    }

}
