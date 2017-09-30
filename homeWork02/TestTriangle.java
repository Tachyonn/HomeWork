package homeWork02;

public class TestTriangle {

    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(3, 4, 5);
        Triangle triangle2 = new Triangle(5, 4, 25);
        Triangle triangle3 = new Triangle(10, 15, 18);


        System.out.println(triangle1.getPerimeter());
        System.out.println(triangle2.getPerimeter());
        System.out.println(triangle3.getPerimeter());
    }
}
