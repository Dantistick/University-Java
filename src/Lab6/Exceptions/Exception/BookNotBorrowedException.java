package Lab6.Exceptions.Exception;

public class BookNotBorrowedException extends RuntimeException{

    public BookNotBorrowedException(String message){
        super(message);
    }
}
