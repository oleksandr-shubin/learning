package model.computer;

public class ComputerAccessException extends IllegalStateException {
    private static final String message = "You can't use" +
            " this program because computer is off!";

    public ComputerAccessException() {
        super(message);
    }

    public ComputerAccessException(Throwable cause) {
        super(message, cause);
    }
}
