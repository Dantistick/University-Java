package Lab6.Quadrilaterals;

import java.util.List;

public class QuadrilateralTest {

    static void main() {

        Quadrilateral quadrilateral = new Quadrilateral(
                new Point(0, 0), new Point(5, 1), new Point(4, 6), new Point(-1, 3));

        Trapezoid trapezoid = new Trapezoid(
                new Point(0, 0), new Point(8, 0), new Point(6, 4), new Point(2, 4));

        Parallelogram parallelogram = new Parallelogram(
                new Point(0, 0), new Point(6, 0), new Point(8, 3), new Point(2, 3));

        Rectangle rectangle = new Rectangle(
                new Point(0, 0), new Point(7, 0), new Point(7, 4), new Point(0, 4));

        Square square = new Square(
                new Point(1, 1), new Point(6, 1), new Point(6, 6), new Point(1, 6));

        System.out.println(quadrilateral + " - площадь не вычисляется");
        System.out.println();

        List<Trapezoid> shapes = List.of(trapezoid, parallelogram, rectangle, square);

        for (Trapezoid shape : shapes) {
            System.out.println(shape);
            System.out.printf("Площадь: %.2f%n%n", shape.getArea());
        }
    }
}
