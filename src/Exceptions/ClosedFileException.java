package Exceptions;

public class ClosedFileException extends Exception {
    public ClosedFileException() {}
    public ClosedFileException(String msg) {
        super(msg);
    }
}
