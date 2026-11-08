package Lab1;

import java.util.Scanner;

public class TimeConverter {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Сколько времени ты проводишь за компьютером? (в минутах): ");
        int minutes = scanner.nextInt();

        int days = minutes / (24 * 60);
        int hours = minutes % (24 * 60) / 60;
        int restMinutes = minutes % 60;

        String daysString = days > 0 ? days + " д. " : "";
        String hoursString = hours > 0 ? hours + " ч. " : "";
        String minutesString = restMinutes > 0 || minutes == 0 ? restMinutes + " мин." : "";

        System.out.println(minutes + " минут это " + daysString + hoursString + minutesString);

        if(minutes < 120)
            System.out.println("Неплохо, но можно ещё поработать");
        else if(minutes <= 300)
            System.out.println("Хороший рабочий день");
        else
            System.out.println("Сделай перерыв, хватит кодить!");
    }
}
