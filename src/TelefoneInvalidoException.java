public class TelefoneInvalidoException extends Exception {
    public TelefoneInvalidoException() {
        super("Erro: Telefone inválido");
    }
    public TelefoneInvalidoException(String message) {
        super(message);
    }
}
