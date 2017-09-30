package homeWork02;


//В качестве свойств возьмите длины сторон
//        треугольника. Реализуйте метод, который будет возвращать площадь этого
//        треугольника. Создайте несколько объектов этого класса и протестируйте их.


public class Triangle {
    private double sideA, sideB, sideC;
    public boolean isExists;

    public Triangle() {
    }

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        if ((sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA))
            isExists = true;
    }

    public double getPerimeter() {
        if (isExists) {
            double p = (sideA + sideB + sideC) / 2;
            return Math.sqrt(p * ((p - sideA) * (p - sideB) * (p - sideC)));
        } else {
            return -1; //Треугольник не существует
        }
    }
}
