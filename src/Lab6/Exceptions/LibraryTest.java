package Lab6.Exceptions;

import Lab6.Exceptions.Entity.Book;
import Lab6.Exceptions.Entity.Library;
import Lab6.Exceptions.Entity.User;
import Lab6.Exceptions.Exception.BookAlreadyBorrowedException;
import Lab6.Exceptions.Exception.BookNotBorrowedException;
import Lab6.Exceptions.Exception.BookNotFoundException;
import Lab6.Exceptions.Exception.MaxBooksLimitException;
import Lab6.Exceptions.Exception.UserNotFoundException;

public class LibraryTest {

    private static final Library library = new Library();

    static void main() {

        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("Мастер и Маргарита", "Михаил Булгаков"));
        library.addBook(new Book("Преступление и наказание", "Фёдор Достоевский"));
        library.addBook(new Book("Война и мир", "Лев Толстой"));
        library.addBook(new Book("Три товарища", "Эрих Мария Ремарк"));
        library.addBook(new Book("Маленький принц", "Антуан де Сент-Экзюпери"));
        library.addBook(new Book("Шерлок Холмс", "Артур Конан Дойл"));

        library.registerUser(new User("Alexei"));
        library.registerUser(new User("Valera"));

        System.out.println("=== Обычная выдача и возврат ===");
        lend("1984", "Alexei");
        giveBack("1984", "Alexei");

        System.out.println("\n=== BookAlreadyBorrowedException ===");
        lend("Война и мир", "Alexei");
        lend("Война и мир", "Valera");

        System.out.println("\n=== BookNotBorrowedException ===");
        giveBack("Три товарища", "Valera");
        giveBack("Война и мир", "Valera");

        System.out.println("\n=== UserNotFoundException ===");
        lend("1984", "Unknown");

        System.out.println("\n=== BookNotFoundException ===");
        lend("Гарри Поттер", "Alexei");

        System.out.println("\n=== MaxBooksLimitException ===");
        lend("1984", "Valera");
        lend("Мастер и Маргарита", "Valera");
        lend("Преступление и наказание", "Valera");
        lend("Три товарища", "Valera");
        lend("Маленький принц", "Valera");
        lend("Шерлок Холмс", "Valera");

        System.out.println("\n=== Состояние библиотеки ===");
        for (Book book : library.getBooks())
            System.out.println(book);
    }

    private static void lend(String title, String userName) {
        try {
            library.lendBook(title, userName);
            System.out.println(userName + " взял книгу \"" + title + "\"");
        } catch (UserNotFoundException | BookNotFoundException
                 | MaxBooksLimitException | BookAlreadyBorrowedException e) {
            System.out.println("Ошибка [" + e.getClass().getSimpleName() + "]: " + e.getMessage());
        }
    }

    private static void giveBack(String title, String userName) {
        try {
            library.returnBook(title, userName);
            System.out.println(userName + " вернул книгу \"" + title + "\"");
        } catch (UserNotFoundException | BookNotFoundException | BookNotBorrowedException e) {
            System.out.println("Ошибка [" + e.getClass().getSimpleName() + "]: " + e.getMessage());
        }
    }
}
