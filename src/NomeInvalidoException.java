public class NomeInvalidoException extends Exception {

    public NomeInvalidoException() {
        super("Erro: Nome inválido");
    }

    public NomeInvalidoException(String message) {
        super(message);
    }
}
