package Lab5.TickTacToeGame;

import java.util.Scanner;

public class TicTacToeTest {

    static void main() {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe(scanner);

        String answer;

        do {
            game.launch();

            System.out.print("Сыграть ещё раз? (yes / no): ");
            answer = scanner.next();
        } while (answer.equalsIgnoreCase("yes"));

        System.out.println("Спасибо за игру!");
    }
}
