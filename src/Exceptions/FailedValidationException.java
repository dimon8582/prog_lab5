package Exceptions;

public class FailedValidationException extends RuntimeException{
    public FailedValidationException(String message) {
        super(message);
    }
}
