package homeWork06;

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

public class Group {

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
            group[indexPointer++] = student;
            System.out.println("Студент " + student.getFirstName() + " " + student.getSurName() + " добавлен в группу.");
        } else {
            System.out.println("Такой студент уже есть в этой группе");
        }
    }

    public void remove(Student student) {
        int index = studentInGroup(student);
        if (index >= 0) {
            group[index] = null;
            indexPointer = index;
            System.out.println("Студент " + student.getFirstName() + " " + student.getSurName() + " удален из группы.");
        } else System.out.println("Нет такого студента");
    }

    public List<Student> search(String lastName) {
        List<Student> result = new ArrayList<>();
        for (int i = 0; i < group.length; i++) {
            if (group[i] != null && group[i].getSurName().equalsIgnoreCase(lastName)) {
                result.add(group[i]);
            }
        }
        if (result.size() == 0) {
            System.out.println("Ничего не найдено.");
        }
        return result;
    }

    @Override
    public String toString() {
        List<Student> sortedList = new ArrayList<>(Arrays.asList(group));
        removeNulls(sortedList);
        sortedList.sort((o1, o2) -> o1.getSurName().compareToIgnoreCase(o2.getSurName()));
        for (Student student : sortedList) {
            System.out.println(student);
        }
        return "";
    }

    private int studentInGroup(Student student) {
        for (int i = 0; i < group.length; i++) {
            if (group[i] != null && student.equals(group[i])) return i;
        }
        return -1;
    }

    private void removeNulls(List<Student> groupList) {
        groupList.removeIf(p -> p == null); //удаляем Null из списка с помощью лямбда функции
//        Iterator<Student> iterator = groupList.iterator();
//        while (iterator.hasNext()) {
//            if (iterator.next() == null) {
//                iterator.remove();
//            }
//        }
    }
}
