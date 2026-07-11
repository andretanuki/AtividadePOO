public class EmailInvalidoException extends Exception {
    public EmailInvalidoException() {
        super("Email inválido");
    }
    public EmailInvalidoException(String message) {
        super(message);
    }
}
