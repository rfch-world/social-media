package world.rfch.exceptions;

public class PostNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 124L;

    public PostNotFoundException(String message) {
        super(message);
    }
}
