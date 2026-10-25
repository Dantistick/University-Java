package Lab6.Exceptions.Entity;

import Lab6.Exceptions.Exception.MaxBooksLimitException;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Book> borrowedBooks;

    public User(String name) {
        this.name = name;
        borrowedBooks = new ArrayList<>(5);
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {

        if(borrowedBooks.size() == 5)
            throw new MaxBooksLimitException("Max Book limit 5");

        borrowedBooks.add(book);
        book.borrow();
    }

    public void returnBook(Book book){

        borrowedBooks.remove(book);
        book.returnBook();
    }
}
