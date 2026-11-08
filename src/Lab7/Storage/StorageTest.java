package Lab7.Storage;

import java.util.Comparator;

public class StorageTest {

    static void main() {

        // ---------------- Storage<User> ----------------
        Storage<User> users = new Storage<>();

        users.add(new User("Alexei", 22));
        users.add(new User("Valera", 16));
        users.add(new User("Maria", 31));
        users.add(new User("Dima", 9));
        users.add(new User("Olga", 19));

        System.out.println("=== Storage<User> ===");
        System.out.println("Все пользователи: " + users.getAll());
        System.out.println("Старше 18: " + users.filter(u -> u.getAge() > 18));
        System.out.println("По возрасту: " + users.sort(Comparator.comparingInt(User::getAge)));

        String searchName = "Maria";
        System.out.println("Поиск по имени " + searchName + ": " +
                users.find(u -> u.getName().equals(searchName))
                        .map(User::toString)
                        .orElse("не найден"));

        System.out.println("Поиск по имени Ivan: " +
                users.find(u -> u.getName().equals("Ivan"))
                        .map(User::toString)
                        .orElse("не найден"));

        // ---------------- Storage<Product> ----------------
        Storage<Product> products = new Storage<>();

        products.add(new Product("Ручка", 2.50));
        products.add(new Product("Наушники", 45.00));
        products.add(new Product("Книга", 15.99));
        products.add(new Product("Монитор", 220.00));
        products.add(new Product("Клавиатура", 120.00));
        products.add(new Product("Флешка", 9.90));

        System.out.println("\n=== Storage<Product> ===");
        System.out.println("Все товары: " + products.getAll());
        System.out.println("Дешевле 20: " + products.filter(p -> p.getPrice() < 20));
        System.out.println("По цене: " + products.sort(Comparator.comparingDouble(Product::getPrice)));

        boolean removed = products.remove(p -> p.getPrice() > 100);
        System.out.println("Удалены товары дороже 100: " + removed);
        System.out.println("Осталось: " + products.getAll());

        System.out.println("Повторное удаление (> 100): " + products.remove(p -> p.getPrice() > 100));
    }
}
