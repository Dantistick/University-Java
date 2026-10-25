package Lab5.RationalTask;

public class Rational {
    private int numerator;
    private int denominator;

    public Rational() {
        numerator = 0;
        denominator = 1;
    }

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }

        this.numerator = numerator;
        this.denominator = denominator;

        reduceTheFraction();
    }

    public static Rational sum(Rational a, Rational b) {
        Rational result = new Rational(
                a.numerator * b.denominator + b.numerator * a.denominator,
                a.denominator * b.denominator
        );

        return result;
    }

    public static Rational subtraction(Rational a, Rational b) {
        Rational result = new Rational(
                a.numerator * b.denominator - b.numerator * a.denominator,
                a.denominator * b.denominator
        );

        return result;
    }

    public static Rational multiply(Rational a, Rational b) {
        Rational result = new Rational(
                a.numerator * b.numerator,
                a.denominator * b.denominator
        );

        return result;
    }

    public static Rational division(Rational a, Rational b) {
        if (b.numerator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        Rational result = new Rational(
                a.numerator * b.denominator,
                a.denominator * b.numerator
        );

        return result;
    }

    public void reduceTheFraction() {
        if (numerator == 0) {
            denominator = 1;
            return;
        }

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        int gcd = findGCD(Math.abs(numerator), denominator);

        numerator /= gcd;
        denominator /= gcd;
    }

    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    @Override
    public String toString() {
        if (numerator == 0) {
            return "0";
        }

        if (numerator % denominator == 0) {
            return numerator + "";
        }

        return numerator + "/" + denominator;
    }

    public String toString(int n) {
        return String.format("%." + n + "f", (double) numerator / denominator);
    }
}