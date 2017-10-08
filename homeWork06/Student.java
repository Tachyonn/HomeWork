package homeWork06;

/*
На основе класса Human создайте класс студент
(переопределите метод вывода информации)
 */

public class Student extends Human {
    private int studentID;
    private String course;
    private String thesis; //тема диплома

    public Student(int studentID, String firstName, String surName, Sex sex, int age, String course, String thesis) {
        super(firstName, surName, sex, age);
        this.studentID = studentID;
        this.course = course;
        this.thesis = thesis;
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Номер студента: " + studentID + ", ");
        sb.append("факультет: " + course + ", ");
        sb.append("тема диплома: " + thesis);
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (studentID != student.studentID) return false;
        if (course != null ? !course.equals(student.course) : student.course != null) return false;
        return thesis != null ? thesis.equals(student.thesis) : student.thesis == null;
    }

    @Override
    public int hashCode() {
        int result = studentID;
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (thesis != null ? thesis.hashCode() : 0);
        return result;
    }


    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }
}
