package homeWork09;

import java.io.*;

public class FSLayer {
    public static void groupToFile(File filename, Group group) {
        validityCheck(filename, false);
        String[] arrayToWrite = group.toString().split(System.lineSeparator());
        writeStringsToFile(filename, arrayToWrite);
    }

    public static Group groupFromFile(File inputFile) {
        validityCheck(inputFile, true);
        Group group = new Group();
        StringBuilder sb = readFile(inputFile);
        String[] allStudents = sb.toString().split(System.lineSeparator());
        try {
            for (int i = 0; i < allStudents.length; i += 2) {
                group.add(parseStudent(allStudents[i], allStudents[i + 1]));
            }
        } catch (OutOfBoundsException e) {
            e.getMessage();
        }
        return group;
    }

    private static Student parseStudent(String... inStrings) {
        String[] firstLine = inStrings[0].split("([ ,:])");
        String firstName = firstLine[0];
        String lastName = firstLine[1];
        Sex sex = firstLine[5].equals("мужской") ? Sex.MALE : Sex.FEMALE;
        int age = Integer.parseInt(firstLine[9]);
        String[] secondLine = inStrings[1].split("([ ,:])");
        String course = secondLine[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 12; i < secondLine.length; i++) {
            sb.append(secondLine[i]).append(" ");
        }
        String thesis = sb.toString();
        Student student = new Student(firstName, lastName, sex, age, course, thesis);
        return student;
    }

    private static StringBuilder readFile(File inputFile) {
        StringBuilder sb = new StringBuilder();
        String currentLine;
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            while ((currentLine = br.readLine()) != null) {
                sb.append(currentLine).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }


    private static void writeStringsToFile(File outputFile, String... arr) {
        try (PrintWriter pw = new PrintWriter(outputFile)) {
            for (String currString : arr) {
                pw.println(currString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static File validityCheck(String filename, boolean checkExistence) {
        if (filename == null || filename.equals("")) {
            throw new IllegalArgumentException("Wrong filename!");
        }
        File checkedFile = new File(filename);
        return validityCheck(checkedFile, checkExistence);
    }

    private static File validityCheck(File checkedFile, boolean checkExistence) {
        if (checkedFile == null) {
            throw new IllegalArgumentException("File is Null!");
        }
        if (checkedFile.isDirectory()) {
            throw new IllegalArgumentException("File is Directory!");
        }
        if (checkExistence && !checkedFile.exists()) {
            throw new IllegalArgumentException("File isn't exists!");
        } else if (!checkedFile.exists()) {
            try {
                checkedFile.createNewFile();
            } catch (IOException e) {
                e.getMessage();
            }
        }
        return checkedFile;
    }
}
