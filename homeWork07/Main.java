package homeWork07;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Student student = new Student("Stanislav", "Lem", Sex.MALE, 20, "ФФиБ",
                "Где взять сепульку?");
        Student student2 = new Student("Misha", "Dobkin", Sex.MALE, 30, "ФМО",
                "Как стать мэром?");
        Student student3 = new Student("Yulia", "Tymoshenkina", Sex.FEMALE, 40, "ФМО",
                "Бьют за БЮТ");
        Student student4 = new Student("Prosto", "Mimokrokodil", Sex.MALE, 17, "Test course",
                "Test thesis");
        Student student5 = new Student("Vasya", "Dobkin", Sex.MALE, 35, "ФМО",
                "test thesis");

        //  System.out.println(student);
        Group group = new Group();
        try {
            group.add(student3);
            group.add(student);
            group.add(student2);
            group.add(student5);
            group.add(student4);
            //group.addInteractive(); //интерактивно добавим студента
            //Thread.sleep(3000);
        } catch (OutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(group);

        //group.sortByAge();
        //group.sortByFirstName();
        //group.sortByLastName();
        //System.out.println(group);

        Voenkom voenkom = group;
        ArrayList<Student> recruits = new ArrayList<>(voenkom.getRecruits());
        for (Student currentRecruit : recruits) {
            System.out.println(currentRecruit);
        }

//        List<Student> searchResult = group.search("Dobkin");
//        System.out.println("Search results (List):");
//        for (Student currentStudent : searchResult) {
//            System.out.println(currentStudent);
//        }

//        System.out.println(group);
        //group.remove(student);

    }
}
