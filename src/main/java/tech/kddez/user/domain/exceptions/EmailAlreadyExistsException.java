package tech.kddez.user.domain.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{

    public EmailAlreadyExistsException() {
        super("The email is already in use.");
    }

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
