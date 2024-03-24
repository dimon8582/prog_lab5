package Exceptions;

public class AlreadyUsedIdException extends RuntimeException{
    public AlreadyUsedIdException(String message) {
        super(message);
    }
}
