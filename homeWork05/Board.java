package homeWork05;

/**
  * 4. Создайте класс доска. Доска поделена на 4 части в каждую
 * часть доски можно положить одну из фигур. У доски должны
 * быть методы которые помещают и удаляют фигуру с доски.
 * Также должен быть метод который выводит информацию о
 * всех фигурах лежащих на доске и их суммарную площадь.
 */
public class Board {
    private Shape[] shapeBoard;

    public Board() {
        shapeBoard = new Shape[4];
    }

    public void put(Shape shape, int quarter) {
        if (isInRange(quarter)) {
            shapeBoard[quarter - 1] = shape;
        } else {
            System.out.println("Quarter must be from 1 to 4");
        }
    }

    public void remove(int quarter) {
        if (isInRange(quarter)) {
            shapeBoard[quarter - 1] = null;
        }
    }

    public void getStatus() {
        double sumPerimeter = 0;
        for (Shape shape : shapeBoard) {
            if (shape != null) {
                System.out.println(shape.getClass().getName());
                sumPerimeter += shape.getPerimeter();
            } else {
                System.out.println("Quarter is empty");
            }
        }
        System.out.printf("Sum of perimeters is %.2f", sumPerimeter);
        System.out.println();
    }

    private boolean isInRange(int quarter) {
        return (quarter > 0) && (quarter < 5);
    }
}
