package Lab6.Exceptions.Entity;

import Lab6.Exceptions.Exception.BookAlreadyBorrowedException;
import Lab6.Exceptions.Exception.BookNotBorrowedException;
import Lab6.Exceptions.Exception.MaxBooksLimitException;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static final int MAX_BOOKS = 5;

    private final String name;
    private final List<Book> borrowedBooks;

    public User(String name) {
        this.name = name;
        borrowedBooks = new ArrayList<>(MAX_BOOKS);
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }

    public void borrowBook(Book book) throws MaxBooksLimitException, BookAlreadyBorrowedException {

        if (borrowedBooks.size() >= MAX_BOOKS)
            throw new MaxBooksLimitException("Пользователь " + name + " уже взял " + MAX_BOOKS + " книг - это максимум");

        book.borrow();
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) throws BookNotBorrowedException {

        if (!borrowedBooks.contains(book))
            throw new BookNotBorrowedException("Пользователь " + name + " не брал книгу \"" + book.getTitle() + "\"");

        book.returnBook();
        borrowedBooks.remove(book);
    }
}
