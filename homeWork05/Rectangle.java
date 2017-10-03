package homeWork05;

/**
 * 3. Создайте классы которые описывают как минимум 3
 * геометрические фигуры (они должны быть подклассами
 * Shape), при этом они в качестве свойств должны содержать
 * классы Point.
 */
public class Rectangle extends Shape {

    /*прямоугольник по трем точкам*/
    private Point vertexA;
    private Point vertexB;
    private Point vertexC;

    private double length;
    private double width;

    private boolean exists;

    public Rectangle() {
    }

    public Rectangle(Point vertexA, Point vertexB, Point vertexC) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
        checkPerpendicular(vertexA, vertexB, vertexC);
        length = vertexA.getDistance(vertexB);
        width = vertexA.getDistance(vertexC);
    }

    private void checkPerpendicular(Point vertexA, Point vertexB, Point vertexC) {
        /*смотрим перпендикулярность сторон*/
        Point vectorAB = getVector(vertexA, vertexB);
        Point vectorAC = getVector(vertexA, vertexC);
        Point vectorBC = getVector(vertexB, vertexC);

        exists = (isPerpendicular(vectorAB, vectorAC)
                || isPerpendicular(vectorAB, vectorBC)
                || isPerpendicular(vectorAC, vectorBC));
    }

    private Point getVector(Point vertexA, Point vertexB) {
        return new Point(vertexB.getX() - vertexA.getX(), vertexB.getY() - vertexA.getY());
    }

    private boolean isPerpendicular(Point vectorA, Point vectorB) {
        /*если ==0, то стороны перпендикулярны, у нас прямоугольник*/
        return (vectorA.getX() * vectorB.getX() + vectorA.getY() * vectorB.getY()) == 0;
    }

    @Override
    double getPerimeter() {
        if (exists) {
            return (length + width) * 2;
        } else {
            return -1;
        }
    }

    @Override
    double getArea() {
        if (exists) {
            return length * width;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        if (exists) {
            return "Rectangle " + vertexA + vertexB + vertexC;
        } else {
            return "Rectangle not exist";
        }
    }

    public boolean isExists() {
        return exists;
    }
}
