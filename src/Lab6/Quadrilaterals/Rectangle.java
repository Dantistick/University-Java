package Lab6.Quadrilaterals;

public class Rectangle extends Parallelogram {

    public Rectangle(Point point1, Point point2, Point point3, Point point4) {
        super(point1, point2, point3, point4);
    }

    public double getWidth() {
        return getPoint1().distanceTo(getPoint2());
    }

    public double getLength() {
        return getPoint1().distanceTo(getPoint4());
    }

    @Override
    public double getArea() {
        return getWidth() * getLength();
    }
}
