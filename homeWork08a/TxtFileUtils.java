package homeWork08a;

import java.io.*;

public class TxtFileUtils {

    public static String[] parseStringsFromFile(String filename) {
        StringBuilder sb = readFile(filename);
        String[] list = sb.toString().split("\\W");
        return list;
    }

    public static void writeStringsToFile(String outputFile, String... arr) {
        File outFile = validityCheck(outputFile, false);
        try(PrintWriter pw = new PrintWriter(outFile)){
            for(String currString:arr){
                pw.write(currString);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static StringBuilder readFile(String filename) {
        return readFile(validityCheck(filename, true));
    }

    private static StringBuilder readFile(File inputFile) {
        validityCheck(inputFile, true);
        StringBuilder sb = new StringBuilder();
        String currentLine;
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            while ((currentLine = br.readLine()) != null) {
                sb.append(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
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

    public static StringBuilder findOverlap(String[] file1, String[] file2) {
        StringBuilder sb = new StringBuilder();
        for (String outerString : file1) {
            for (String innerString : file2) {
                if (outerString.equals(innerString)) {
                    sb.append(innerString).append(System.lineSeparator());
                }
            }
        }
        return sb;
    }
}