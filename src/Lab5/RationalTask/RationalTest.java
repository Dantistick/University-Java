package Lab5.RationalTask;

public class RationalTest {

    static void main() {

        System.out.println("=== Rational tests ===");

        Rational zero = new Rational();
        System.out.println("Default constructor: " + zero);

        Rational a = new Rational(2, 4);
        Rational b = new Rational(3, 6);

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println("a + b = " + Rational.sum(a, b));

        System.out.println("a - b = " + Rational.subtraction(a, b));

        System.out.println("a * b = " + Rational.multiply(a, b));

        System.out.println("a / b = " + Rational.division(a, b));

        Rational c = new Rational(1, 2);
        Rational d = new Rational(1, 3);

        System.out.println("\nc = " + c);
        System.out.println("d = " + d);

        System.out.println("c + d = " + Rational.sum(c, d));
        System.out.println("c - d = " + Rational.subtraction(c, d));
        System.out.println("c * d = " + Rational.multiply(c, d));
        System.out.println("c / d = " + Rational.division(c, d));

        Rational negative = new Rational(-6, 8);
        System.out.println("\nNegative fraction: " + negative);

        Rational zeroFraction = new Rational(0, 10);
        System.out.println("Zero fraction: " + zeroFraction);

        Rational fraction = new Rational(1, 3);

        System.out.println("\nFloating point:");
        System.out.println("2 digits: " + fraction.toString(2));
        System.out.println("4 digits: " + fraction.toString(4));
        System.out.println("6 digits: " + fraction.toString(6));

        Rational x = new Rational(5, 12);
        Rational y = new Rational(7, 18);

        System.out.println("\nComplex example:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("x + y = " + Rational.sum(x, y));
        System.out.println("x - y = " + Rational.subtraction(x, y));
        System.out.println("x * y = " + Rational.multiply(x, y));
        System.out.println("x / y = " + Rational.division(x, y));
    }
}
