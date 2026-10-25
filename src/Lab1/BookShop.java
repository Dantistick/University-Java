package Lab1;

import java.util.Scanner;

public class BookShop {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в Книжный магазин!\n");

        System.out.print("Введите цену одной книги:");
        float oneBookPrice = scanner.nextFloat();

        System.out.print("Сколько книг хотите приобрести?:");
        int countOfBooks = scanner.nextInt();

        System.out.print("Какая у вас скидка(в процентах %):");
        int discount = scanner.nextInt();

        float price = oneBookPrice * countOfBooks * (1 - (float) discount /100);

        System.out.println("С вас " + price + "$");

        if(price >= 100){
            System.out.println("Бонус! Вы получаете подарочный купон!");
        }

    }
}
