package homeWork09;

/*Создайте класс описывающий человека (создайте метод
*выводящий информацию о человеке)
*/

public class Human {
    private String firstName;
    private String lastName;
    private Sex sex;
    private int age;

    public Human(String firstName, String lastName, Sex sex, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    public Human() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(firstName).append(" ").append(lastName).append(", ");
        sb.append("пол: ").append(sex).append(", ");
        sb.append("возраст: ").append(age);
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    //секция геттеров/сеттеров
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String lastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex.toString();
    }

    public void setSex(Sex sex) {

        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
