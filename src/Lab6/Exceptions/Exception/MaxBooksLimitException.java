package Lab6.Exceptions.Exception;

public class MaxBooksLimitException extends RuntimeException{

    public MaxBooksLimitException(String message){
        super(message);
    }
}
