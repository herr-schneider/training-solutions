package exceptions;

public class InvalidTimeException extends RuntimeException{

    public InvalidTimeException(String massage){
        super(massage);
    }
}
