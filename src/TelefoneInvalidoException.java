public class TelefoneInvalidoException extends Exception {
    public TelefoneInvalidoException() {
        super("Telefone inválido");
    }
    public TelefoneInvalidoException(String message) {
        super(message);
    }
}
