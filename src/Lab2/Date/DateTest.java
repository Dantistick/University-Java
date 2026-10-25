package Lab2.Date;

public class DateTest {

     static void main() {

        Date date = new Date(9, 8, 2026);

        System.out.println("Месяц: " + date.getMonth());
        System.out.println("День: " + date.getDay());
        System.out.println("Год: " + date.getYear());

        System.out.println("Дата:");
        date.displayDate();

        date.setMonth(12);
        date.setDay(25);
        date.setYear(2026);

        System.out.println("После изменения:");
        date.displayDate();
    }
}
