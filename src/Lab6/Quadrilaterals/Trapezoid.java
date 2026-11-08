package Lab6.Quadrilaterals;

public class Trapezoid extends Quadrilateral {

    public Trapezoid(Point point1, Point point2, Point point3, Point point4) {
        super(point1, point2, point3, point4);
    }

    public double getBottomBase() {
        return getPoint1().distanceTo(getPoint2());
    }

    public double getTopBase() {
        return getPoint4().distanceTo(getPoint3());
    }

    public double getHeight() {
        return Math.abs(getPoint4().getY() - getPoint1().getY());
    }

    public double getArea() {
        return (getBottomBase() + getTopBase()) / 2 * getHeight();
    }
}
