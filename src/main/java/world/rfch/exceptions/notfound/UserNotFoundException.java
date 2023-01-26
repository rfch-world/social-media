package world.rfch.exceptions.notfound;


public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 124L;

    public UserNotFoundException(String message) {
        super(message);
    }

}
