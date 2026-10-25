package Lab1;

import java.util.Scanner;

public class RandomNicknameGenerator {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите свое имя: ");
        String name = scanner.nextLine();

        System.out.print("Сколько вам лет: ");
        int age = scanner.nextInt();

        if(age < 18)
            name += " Junior";
        else if(age <= 40)
            name += " Pro";
        else
            name += " Boss";

        System.out.println("Теперь ты: " + name);
    }
}
