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

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrow() throws BookAlreadyBorrowedException {
        if (isBorrowed)
            throw new BookAlreadyBorrowedException("Книга \"" + title + "\" уже выдана");

        isBorrowed = true;
    }

    public void returnBook() throws BookNotBorrowedException {
        if (!isBorrowed)
            throw new BookNotBorrowedException("Книга \"" + title + "\" не была выдана");

        isBorrowed = false;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" (" + author + ")" + (isBorrowed ? " - выдана" : " - в наличии");
    }
}
