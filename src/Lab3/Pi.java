package Lab3;

public class Pi {

    static void main() {

        double p = 0;
        int index = 1;
        int sign = 1;

        int members = 0;

        System.out.println("Количество членов\tПриближенное PI");

        for (int i = 1; i <= 200_000; i++) {

            p += sign * (double) 4 / index;

            sign = -sign;
            index += 2;

            if (i % 10_000 == 0) {
                System.out.println(i + "\t\t\t" + p);
            }

            // Запоминаем только первое найденное значение
            if (members == 0 && p >= 3.14159 && p < 3.14160) {
                members = i;
            }
        }

        System.out.println();
        System.out.println("Первое значение, начинающееся с 3.14159:");
        System.out.println("Количество членов: " + members);
    }
}