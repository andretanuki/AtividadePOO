public class CpfInvalidoException extends Exception {

    public CpfInvalidoException() {
        super("Erro: CPF inválido");
    }

    public CpfInvalidoException(String message) {
        super(message);
    }
}
