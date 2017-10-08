package homeWork06;

/*
В случае попытки добавления 11 студента создайте
собственное исключение и обработайте его.
 */

public class OutOfBoundsException extends Exception {
    @Override
    public String getMessage() {
        return "Group full, delete someone!";
    }
}
