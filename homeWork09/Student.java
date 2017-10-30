package homeWork09;

/*
На основе класса Human создайте класс студент
(переопределите метод вывода информации)
 */

public class Student extends Human {
    private long studentID;
    private String course;
    private String thesis; //тема диплома

    public Student(String firstName, String lastName, Sex sex, int age, String course, String thesis) {
        super(firstName, lastName, sex, age);
        this.studentID = StudentIDGenerator.getNewID();
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
        sb.append("Номер студента: ").append(studentID).append(", ");
        sb.append("факультет: ").append(course).append(", ");
        sb.append("тема диплома: ").append(thesis);
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
        int result = (int) studentID;
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (thesis != null ? thesis.hashCode() : 0);
        return result;
    }

    //секция геттеров/сеттеров
    public long getStudentID() {
        return studentID;
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
