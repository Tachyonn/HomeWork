package homeWork06;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Student student = new Student(1, "Stanislav", "Lem", Sex.MALE, 20, "ФФиБ",
                "Где взять сепульку?");
        Student student2 = new Student(2, "Misha", "Dobkin", Sex.MALE, 30, "ФМО",
                "Как стать мэром?");
        Student student3 = new Student(3, "Yulia", "Tymoshenkina", Sex.FEMALE, 40, "ФМО",
                "Бьют за БЮТ");
        Student student4 = new Student(4, "Prosto", "Mimokrokodil", Sex.MALE, 17, "Test course",
                "Test thesis");
        Student student5 = new Student(5, "Vasya", "Dobkin", Sex.MALE, 35, "ФМО",
                "test thesis");

        System.out.println(student);
        Group group = new Group();
        try {
            group.add(student);
            group.add(student2);
            group.add(student3);
            group.add(student5);
        } catch (OutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        List<Student> searchResult = group.search("Dobkin");
        for (Student currentStudent : searchResult) {
            System.out.println(currentStudent.toString());
        }

        System.out.println(group);
        group.remove(student);

    }
}
