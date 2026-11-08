package Lab6.Exceptions.Entity;

import Lab6.Exceptions.Exception.BookAlreadyBorrowedException;
import Lab6.Exceptions.Exception.BookNotBorrowedException;
import Lab6.Exceptions.Exception.BookNotFoundException;
import Lab6.Exceptions.Exception.MaxBooksLimitException;
import Lab6.Exceptions.Exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books;
    private final List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public void lendBook(String bookTitle, String userName)
            throws UserNotFoundException, BookNotFoundException,
                   MaxBooksLimitException, BookAlreadyBorrowedException {

        User user = getUser(userName);
        Book book = getBook(bookTitle);

        user.borrowBook(book);
    }

    public void returnBook(String bookTitle, String userName)
            throws UserNotFoundException, BookNotFoundException, BookNotBorrowedException {

        User user = getUser(userName);
        Book book = getBook(bookTitle);

        user.returnBook(book);
    }

    private Book getBook(String bookTitle) throws BookNotFoundException {

        for (Book b : books)
            if (b.getTitle().equalsIgnoreCase(bookTitle))
                return b;

        throw new BookNotFoundException("Книга \"" + bookTitle + "\" не найдена");
    }

    private User getUser(String userName) throws UserNotFoundException {

        for (User u : users)
            if (u.getName().equalsIgnoreCase(userName))
                return u;

        throw new UserNotFoundException("Пользователь " + userName + " не найден");
    }
}
