package Lab1;

import java.util.Scanner;

public class TimeConverter {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Сколько времени ты проводишь за компьютером? (в минутах): ");
        int minutes = scanner.nextInt();

        int hours = minutes / 60;
        int days = hours / 24;

        String daysString =  days > 0 ? days + " дней " : "";
        String hoursString = hours > 0 ? hours + " часов" : "";

        System.out.println(minutes + " минут это " + daysString + hoursString);

        if(minutes < 120)
            System.out.println("Неплохо, но можно ещё поработать");
        else if(minutes <= 300)
            System.out.println("Хороший рабочий день");
        else
            System.out.println("Сделай перерыв, хватит кодить!");
    }
}
