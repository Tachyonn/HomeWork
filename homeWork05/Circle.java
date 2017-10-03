package homeWork05;

/**
 * 3. Создайте классы которые описывают как минимум 3
 * геометрические фигуры (они должны быть подклассами
 * Shape), при этом они в качестве свойств должны содержать
 * классы Point.
 */
public class Circle extends Shape {
    private Point center;
    private double radius;

    private boolean exists;

    public Circle() {
    }

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
        exists = !(radius == 0);
    }

    @Override
    public double getPerimeter() {
        if (exists) {
            return 2 * Math.PI * radius;
        } else {
            return -1;
        }
    }

    @Override
    public double getArea() {
        if (exists) {
            return Math.pow(Math.PI * radius, 2);
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        if (exists) {
            return "Circle center " + center + " radius " + radius;
        } else {
            return "Circle not exist";
        }
    }

    public boolean isExist() {
        return exists;
    }
}
