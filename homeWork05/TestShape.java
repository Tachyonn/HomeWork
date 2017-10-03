package homeWork05;

/**
 * 1. Создайте абстрактный класс Shape в котором есть два
 * абстрактных метода double getPerimetr() и double getArea().
 * 2. Создайте класс Point в котором есть два свойства double x
 * double y.
 * 3. Создайте классы которые описывают как минимум 3
 * геометрические фигуры (они должны быть подклассами
 * Shape), при этом они в качестве свойств должны содержать
 * классы Point.
 * 4. Создайте класс доска. Доска поделена на 4 части в каждую
 * часть доски можно положить одну из фигур. У доски должны
 * быть методы которые помещают и удаляют фигуру с доски.
 * Также должен быть метод который выводит информацию о
 * всех фигурах лежащих на доске и их суммарную площадь.
 * 5. * Нарисуйте UML диаграмму проекта
 */

public class TestShape {
    public static void main(String[] args) {
        Triangle tri1 = new Triangle(new Point(5, 0), new Point(5, 15), new Point(15, 0));
        Triangle tri2 = new Triangle(new Point(5, 5), new Point(10, 5), new Point(10, 15));
        //Triangle tri3 = new Triangle(new Point(5, 5), new Point(10, 5), new Point(10, 5)); //not exist
        //Rectangle rect1 = new Rectangle(new Point(5, 5), new Point(10, 5), new Point(5, 15));
        //Rectangle rect2 = new Rectangle(new Point(5, 5), new Point(11, 5), new Point(12, 15)); //not exist
        Rectangle rect3 = new Rectangle(new Point(5, 5), new Point(10, 5), new Point(10, 15));
        //Circle circ1 = new Circle(new Point(5, 5), 10);
        Circle circ2 = new Circle(new Point(5, 8), 15);
        //Circle circ3 = new Circle(new Point(5, 8), 0); //not exist

        Board board = new Board();
        board.put(tri1,1);
        board.put(tri2,2);
        board.put(rect3,3);
        board.put(circ2,4);
        board.getStatus();
        board.remove(2);
        board.getStatus();


    }
}
