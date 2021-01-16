package exceptions;

public class InvalidTimeException extends RuntimeException{

    public InvalidTimeException(String massage){
        super(massage);
    }

    public InvalidTimeException(String massage, Exception e){
        super(massage, e);
    }
}
