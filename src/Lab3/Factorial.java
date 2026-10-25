package Lab3;

public class Factorial {

    static void main() {

        long factorial = 1;

        System.out.println("Число\tФакториал");

        for (int i = 1; i <= 20; i++) {
            factorial *= i;

            System.out.println(i + "\t" + factorial);
        }
    }
}