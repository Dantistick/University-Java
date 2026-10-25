package Lab4;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    static void main() {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        do {

            System.out.println("\nПоиграем в игру! Угадайте число от 1 до 1000\n");

            int guessNumber = random.nextInt(1000) + 1;
            int input = -1;

            while (guessNumber != input) {

                System.out.print("Введите число: ");
                input = scanner.nextInt();

                if (input < guessNumber)
                    System.out.println("Слишком маленькое. Попробуйте снова ;(\n");

                if (input > guessNumber)
                    System.out.println("Слишком большое. Попробуйте снова ;(\n");
            }

            System.out.println("Поздравляем! Вы угадали число!");
            System.out.print("Хотите сыграть еще раз? (yes or no): ");

            scanner.nextLine();
            String canPlayAgain = scanner.nextLine();

            if (!canPlayAgain.equalsIgnoreCase("yes"))
                playAgain = false;

        } while (playAgain);

        System.out.println("Спасибо за игру!");
        scanner.close();
    }
}