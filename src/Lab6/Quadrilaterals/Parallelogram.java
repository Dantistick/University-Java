package Lab6.Quadrilaterals;

public class Parallelogram extends Trapezoid {

    public Parallelogram(Point point1, Point point2, Point point3, Point point4) {
        super(point1, point2, point3, point4);
    }

    public double getBase() {
        return getBottomBase();
    }

    @Override
    public double getArea() {
        return getBase() * getHeight();
    }
}
