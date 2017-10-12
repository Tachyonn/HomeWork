package homeWork07;

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
            String firstName = reader.readLine();

            System.out.println("Enter last name:");
            String lastName = reader.readLine();

            System.out.println("Enter sex - male or female:");
            String sexInput = reader.readLine();
            Sex sex;
            if (sexInput.equalsIgnoreCase("male")) {
                sex = Sex.MALE;
            } else if (sexInput.equalsIgnoreCase("female")) {
                sex = Sex.FEMALE;
            } else {
                throw new IllegalArgumentException("Wrong sex!");
            }

            System.out.println("Enter age:");
            int age = Integer.parseInt(reader.readLine());

            System.out.println("Enter course:");
            String course = reader.readLine();

            System.out.println("Enter thesis:");
            String thesis = reader.readLine();

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
}
