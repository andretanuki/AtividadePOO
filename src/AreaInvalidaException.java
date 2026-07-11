public class AreaInvalidaException extends Exception {

    public AreaInvalidaException() {
        super("Area inválida - O valor deve ser maior do que Zero");
    }

    public AreaInvalidaException(String message) {
        super(message);
    }
}
