public class ValorImovelInvalidoException extends Exception{

    public ValorImovelInvalidoException() {
        super("Valor do Imovel não pode Menor ou Igual a 0");
    }

    public ValorImovelInvalidoException(String message) {
        super(message);
    }

}
