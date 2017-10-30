package homeWork09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
    public UserInput() {
    }

    public Student getStudent() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String firstName, String surName, Sex sex, int age, String course, String thesis)
        try {
            System.out.println("Enter first name:");
            String firstName = checkString(reader.readLine());

            System.out.println("Enter last name:");
            String lastName = checkString(reader.readLine());

            System.out.println("Enter sex - male or female:");
            String sexInput = reader.readLine();
            Sex sex = checkSex(sexInput);

            System.out.println("Enter age:");
            int age = checkAge(Integer.parseInt(reader.readLine()));

            System.out.println("Enter course:");
            String course = checkString(reader.readLine());

            System.out.println("Enter thesis:");
            String thesis = checkString(reader.readLine());

            return new Student(firstName, lastName, sex, age, course, thesis);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int checkAge(int age) {
        return age > 16 ? age : 16;
    }

    private String checkString(String inputString) {
        return inputString.isEmpty() ? "default" : inputString;
    }

    private Sex checkSex(String sexInput) {
        if (sexInput.isEmpty()) {
            sexInput = "male";
        }
        Sex sex;
        if (sexInput.equalsIgnoreCase("male")) {
            sex = Sex.MALE;
        } else if (sexInput.equalsIgnoreCase("female")) {
            sex = Sex.FEMALE;
        } else {
            throw new IllegalArgumentException("Wrong sex!");
        }
        return sex;
    }
}