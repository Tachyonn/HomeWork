package homeWork07;

/*
Создайте класс группа — который содержит массив из 10
объектов класса студент. Реализуйте методы добавления,
удаления студента и метод поиска студента по фамилии. В
случае попытки добавления 11 студента создайте
собственное исключение и обработайте его. Определите
метод toString() для группы так, что бы он выводил список
студентов в алфавитном порядке.
 */

import java.util.*;

public class Group implements Voenkom {

    private Student[] group;
    private int indexPointer;

    public Group() {
        group = new Student[10];
        indexPointer = 0;
    }

    public void add(Student student) throws OutOfBoundsException {
        if (indexPointer > 10) {
            throw new OutOfBoundsException(); //написать свое исключение
        }
        if (student == null) {
            throw new IllegalArgumentException("Argument is Null");
        }
        if (studentInGroup(student) < 0) {
            for (int i = 0; i < group.length; i++) {
                if (Objects.isNull(group[i])) {
                    group[i] = student;
                    break;
                }
            }
            indexPointer++;
            System.out.println(student.getStudentID() + " " + "Студент " + student.getFirstName()
                    + " " + student.lastName() + " добавлен в группу.");
        } else {
            System.out.println("Такой студент уже есть в этой группе");
        }
    }

    // интерактивный
    public void addInteractive() throws OutOfBoundsException {
        UserInput userInput = new UserInput();
        add(userInput.getStudent());
    }

    public void remove(Student student) {
        int index = studentInGroup(student);
        if (index >= 0) {
            group[index] = null;
            indexPointer--;
            System.out.println("Студент " + student.getFirstName() + " " + student.lastName() + " удален из группы.");
        } else System.out.println("Нет такого студента");
    }

    public List<Student> search(String lastName) {
        List<Student> result = new ArrayList<>();
        for (int i = 0; i < group.length; i++) {
            if (group[i] != null && group[i].lastName().equalsIgnoreCase(lastName)) {
                result.add(group[i]);
            }
        }
        if (result.size() == 0) {
            System.out.println("Ничего не найдено.");
        }
        return result;
    }

    public void sortByLastName() {
        sortBy("LastName");
    }

    public void sortByFirstName() {
        sortBy("FirstName");
    }

    public void sortByAge() {
        sortBy("Age");
    }


    private void sortBy(String sortType) {
        List<Student> currentList = removeNulls();
        if (!currentList.isEmpty()) {

            switch (sortType) {
                case "LastName": {
                    System.out.println("Sorting by Last name:");
                    Collections.sort(currentList, Comparator.comparing(Student::getLastName));
                    break;
                }
                case "FirstName": {
                    System.out.println("Sorting by First name:");
                    Collections.sort(currentList, Comparator.comparing(Student::getFirstName));
                    break;
                }
                case "Age": {
                    System.out.println("Sorting by Age:");
                    Collections.sort(currentList, (Comparator.comparingInt(Student::getAge)));
                    break;
                }
                default: {
                    Collections.sort(currentList, Comparator.comparing(Student::getLastName));
                }
            }
        }
        group = currentList.toArray(new Student[10]);
    }

    private List<Student> removeNulls() {
        List<Student> noNullsList = new ArrayList<>(Arrays.asList(group));
        noNullsList.removeIf(Objects::isNull);
        return noNullsList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < group.length; i++) {
            if (!(group[i] == null)) {
                sb.append(group[i]);
            }
        }
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    /*
    Возвращает индекс найденного студента,
    либо -1 если студент не найден
     */
    private int studentInGroup(Student student) {
        for (int i = 0; i < group.length; i++) {
            if (group[i] != null && student.equals(group[i])) return i;
        }
        return -1;
    }

    // реализация интерфейса Voenkom
    @Override
    public List<Student> getRecruits() {
        ArrayList<Student> recruitsList = new ArrayList<>();
        for (int i = 0; i < group.length; i++) {
            if (!(group[i] == null)) {
                if (group[i].getAge() > 17) {
                    recruitsList.add(group[i]);
                }
            }
        }
        return recruitsList;
    }
}
