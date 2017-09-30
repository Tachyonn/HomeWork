package homeWork01;

public class TestCat {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik");
        Cat cat2 = new Cat("Grisha", "grey", 2, 3);
        Cat cat3 = new Cat();
        Cat cat4 = new Cat("Zhora", "silver", 2, 2);

        cat1.jump();
        cat2.meow();
        cat3.eat();

        cat1.fights(cat4);
        cat1.eat();
        cat1.fights(cat2);
        }
}
