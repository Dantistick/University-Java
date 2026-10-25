package Lab4;

import java.util.Scanner;

public class Aviasales {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int CAPACITY = 10;
    private static final boolean[] places = new boolean[CAPACITY];

     static void main() {

        while (hasEmptyPlace()) {
            System.out.print(
                    "Пожалуйста, введите 1 для бизнес-класса\n" +
                     "Пожалуйста, введите 2 для эконом-класса\n" +
                     ">> "
            );

            int input = scanner.nextInt();
            scanner.nextLine();

            if (input == 1) {
                addBusinessPlace();
            } else if (input == 2) {
                addEconomyPlace();
            }
        }

         System.out.println("Самолет улетел!");
    }

    private static void addBusinessPlace() {
        boolean hasPlace = false;

        for (int i = 0; i < CAPACITY / 2; ++i) {
            if (places[i])
                continue;

            places[i] = true;
            hasPlace = true;
            break;
        }

        if (hasPlace)
            return;

        System.out.print("Нет места в Бизнес-классе, хотите Эконом? (yes / no): ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("yes"))
            addEconomyPlace();
        else
            System.out.println("Следующий рейс отправляется через 3 часа!");

        System.out.println();
    }

    private static void addEconomyPlace() {
        boolean hasPlace = false;

        for (int i = CAPACITY / 2; i < CAPACITY; ++i) {
            if (places[i])
                continue;

            places[i] = true;
            hasPlace = true;
            break;
        }

        if (hasPlace)
            return;

        System.out.print("Нет места в Эконом-классе, хотите Бизнес? (yes / no): ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("yes"))
            addBusinessPlace();
        else
            System.out.println("Следующий рейс отправляется через 3 часа!");

        System.out.println();
    }

    private static boolean hasEmptyPlace() {
        for (boolean place : places) {
            if (!place)
                return true;
        }

        return false;
    }
}