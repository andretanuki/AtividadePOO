public class ImovelIndisponivelException extends Exception{

    public ImovelIndisponivelException() {
        super("Imóvel Indisponível");
    }

    public ImovelIndisponivelException(String message) {
        super(message);
    }

}
