package world.rfch.exceptions;


public class SocialMediaNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 124L;

    public SocialMediaNotFoundException(String message) {
        super(message);
    }
}
