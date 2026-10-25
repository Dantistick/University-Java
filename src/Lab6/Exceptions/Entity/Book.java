package Lab6.Exceptions.Entity;

import Lab6.Exceptions.Exception.BookAlreadyBorrowedException;
import Lab6.Exceptions.Exception.BookNotBorrowedException;

public class Book {
    private final String title;
    private final String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
            this.title = title;
            this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void borrow(){
        if(isBorrowed)
            throw new BookAlreadyBorrowedException("Book already borrowed");

        isBorrowed = true;
    }

    public void returnBook(){
        if(!isBorrowed)
            throw new BookNotBorrowedException("Book already is not borrowed");

        isBorrowed = false;
    }
}
