package homeWork05;

/**
 * 3. Создайте классы которые описывают как минимум 3
 * геометрические фигуры (они должны быть подклассами
 * Shape), при этом они в качестве свойств должны содержать
 * классы Point.
 */
public class Triangle extends Shape {
    /*вершины треугольника*/
    private Point vertexA;
    private Point vertexB;
    private Point vertexC;
    /*стороны треугольника*/
    private double sideA;
    private double sideB;
    private double sideC;
    /*существует или нет*/
    private boolean exists;

    public Triangle() {
    }

    public Triangle(Point vertexA, Point vertexB, Point vertexC) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
        sideA = vertexA.getDistance(vertexB);
        sideB = vertexB.getDistance(vertexC);
        sideC = vertexC.getDistance(vertexA);
        exists = ((sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA));
    }

    @Override
    double getPerimeter() {
        if (exists)
            return sideA + sideB + sideC;
        return -1;  //Треугольник не существует
    }

    @Override
    double getArea() {
        if (exists) {
            double p = (sideA + sideB + sideC) / 2;
            return Math.sqrt(p * ((p - sideA) * (p - sideB) * (p - sideC)));
        }
        return -1;  //Треугольник не существует
    }

    public boolean isExists() {
        return exists;
    }

    @Override
    public String toString() {
        if (exists) {
            return "Triangle " + vertexA + vertexB + vertexC;
        } else {
            return "Triangle not exist";
        }
    }
}
