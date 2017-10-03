package homeWork05;

/**
 * 2. Создайте класс Point в котором есть два свойства double x
 * double y.
 */
public class Point {
    private double x;
    private double y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point point) {
        return Math.sqrt(
                Math.pow(point.getY() - y, 2) +
                        Math.pow(point.getX() - x, 2)
        );
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
