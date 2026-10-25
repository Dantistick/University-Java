package Lab6.Exceptions.Entity;

import Lab6.Exceptions.Exception.BookNotFoundException;
import Lab6.Exceptions.Exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books;
    private final List<User> users;

    public Library(){
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void registerUser(User user){
        users.add(user);
    }

    public void lendBook(String bookTitle, String userName){

        var user = getUser(userName);
        var book = getBook(bookTitle);

        if(user == null)
            throw new UserNotFoundException("User not found");

        if(book == null)
            throw new BookNotFoundException("Book not found");

        user.borrowBook(book);
    }

    public void returnBook(String bookTitle, String userName){

        var user = getUser(userName);
        var book = getBook(bookTitle);

        if(user == null)
            throw new UserNotFoundException("User not found");

        if(book == null)
            throw new BookNotFoundException("Book not found");

        user.returnBook(book);
    }

    private Book getBook(String bookName){

        for(var b : books)
            if(b.getTitle().equalsIgnoreCase(bookName))
                return b;

        return null;
    }

    private User getUser(String userName){

        for(var u : users)
            if(u.getName().equalsIgnoreCase(userName))
                return u;

        return null;
    }
}
