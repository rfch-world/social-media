package world.rfch.exceptions;


public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 124L;

    public UserNotFoundException(String message) {
        super(message);
    }

}
