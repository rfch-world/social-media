package world.rfch.exceptions.notfound;

public class CommentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 124L;

    public CommentNotFoundException(String message) {
        super(message);
    }
}
