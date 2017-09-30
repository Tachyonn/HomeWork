package homeWork01;

public class Cat {
    private String name;
    private String color;
    private int weight;
    private int age;

    public Cat() {
        name = "Default cat";
        color = "black";
        weight = 1;
        age = 1;
    }

    public Cat(String name) {
        this.name = name;
        color = "black";
        weight = 1;
        age = 1;
    }

    public Cat(String name, String color, int weight, int age) {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.age = age;
    }

    public void fights(Cat anotherCat) {
        Cat winnerCat = null;
        System.out.println(this.name + " fights vs " + anotherCat.getName() + "...");
        if (this.weight > anotherCat.weight && this.age > anotherCat.age) { //this для логической наглядности
            winnerCat = this;
        } else {
            winnerCat = anotherCat;
        }
        System.out.println("And the Winner is " + winnerCat.getName() + "!!");
    }

    public void meow() {
        System.out.println(name + " meows!");
    }

    public void jump() {
        System.out.println(name + " is jumping!");
    }

    public void eat() {
        System.out.println(name + " eating!");
        weight += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }
}
