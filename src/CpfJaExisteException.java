public class CpfJaExisteException extends Exception{

    public CpfJaExisteException() {
        super("CPF já existe na Base de Dados");
    }

    public CpfJaExisteException(String message) {
        super(message);
    }

}
