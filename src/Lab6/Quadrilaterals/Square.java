package Lab6.Quadrilaterals;

public class Square extends Rectangle {

    public Square(Point point1, Point point2, Point point3, Point point4) {
        super(point1, point2, point3, point4);
    }

    public double getSide() {
        return getWidth();
    }

    @Override
    public double getArea() {
        return getSide() * getSide();
    }
}
