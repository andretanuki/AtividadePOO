public class EmailInvalidoException extends Exception {
    public EmailInvalidoException() {
        super("Erro: Email inválido");
    }
    public EmailInvalidoException(String message) {
        super(message);
    }
}
