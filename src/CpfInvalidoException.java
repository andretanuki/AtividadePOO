public class CpfInvalidoException extends Exception {

    public CpfInvalidoException() {
        super("CPF inválido");
    }

    public CpfInvalidoException(String message) {
        super(message);
    }
}
