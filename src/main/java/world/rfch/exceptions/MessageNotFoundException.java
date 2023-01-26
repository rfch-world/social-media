package world.rfch.exceptions;

public class MessageNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 124L;

    public MessageNotFoundException(String message) {
        super(message);
    }
}
