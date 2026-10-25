package Lab4;

import java.util.Random;

public class Cubes {

    static void main() {

        Random random = new Random();

        int[] results = new int[11];

        for (int i = 0; i < 36_000_000; i++) {

            int val1 = random.nextInt(6) + 1;
            int val2 = random.nextInt(6) + 1;

            results[val1 + val2 - 2]++;
        }

        System.out.println("+--------+------------+");
        System.out.println("| Сумма  | Количество |");
        System.out.println("+--------+------------+");

        for (int i = 0; i < results.length; i++) {
            System.out.printf("| %-6d | %-10d |%n", i + 2, results[i]);
        }

        System.out.println("+--------+------------+");
    }
}