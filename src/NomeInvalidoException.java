public class NomeInvalidoException extends Exception {

    public NomeInvalidoException() {
        super("Nome inválido");
    }

    public NomeInvalidoException(String message) {
        super(message);
    }
}
