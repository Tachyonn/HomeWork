package homeWork03;

/**
 * Описать класс «Vector3d» (т.е. он должен описывать вектор в 3-х мерной,
 * декартовой системе координат). В качестве свойств этого класса возьмите
 * координаты вектора. Для этого класса реализовать методы сложения, скалярного и
 * векторного произведения векторов. Создайте несколько объектов этого класса и
 * протестируйте их.
 */
public class Vector3d {
    private double x, y, z;

    public Vector3d() {
    }

    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void add(Vector3d anotherVector) { //сложение векторов, складываем с текущим
        x += anotherVector.x;
        y += anotherVector.y;
        z += anotherVector.z;
    }

    public double scalarMult(Vector3d anotherVector) { //скалярное произведение, умножаем с текущим
        return ((x * anotherVector.x) + (y * anotherVector.y) + (z * anotherVector.z));
    }

    public Vector3d vectorMult(Vector3d anotherVector) { //векторное произведение, умножаем с текущим
        double resultX, resultY, resultZ;                   //this ставлю для наглядности
        resultX = this.y * anotherVector.z - this.z * anotherVector.y;
        resultY = -(this.x * anotherVector.z - this.z * anotherVector.x);
        resultZ = this.x * anotherVector.y - this.y * anotherVector.x;
        return new Vector3d(resultX, resultY, resultZ);
    }

    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
