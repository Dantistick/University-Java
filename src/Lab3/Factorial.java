package Lab3;

public class Factorial {

    static void main() {

        long factorial = 1;

        System.out.println("Число\tФакториал");

        for (int i = 1; i <= 20; i++) {
            factorial *= i;

            System.out.println(i + "\t" + factorial);
        }

        System.out.println();
        System.out.println("Почему не получится вычислить 100! в long:");
        System.out.println("Максимум long = " + Long.MAX_VALUE + " (~9.2 * 10^18).");
        System.out.println("Уже 21! = 51090942171709440000 (~5.1 * 10^19) не помещается в long - происходит переполнение,");
        System.out.println("а 100! содержит 158 цифр. Для таких чисел нужен класс java.math.BigInteger.");
    }
}