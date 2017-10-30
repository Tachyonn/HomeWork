package homeWork08a;

public class Main {
    public static void main(String[] args) {
        TxtFileUtils fu = new TxtFileUtils();
        String filename1 = "file1.txt";
        String filename2 = "file2.txt";
        String resultFilename = "file3.txt";

        String[] file1 = fu.parseStringsFromFile(filename1);
        String[] file2 = fu.parseStringsFromFile(filename2);

        StringBuilder sb = fu.findOverlap(file1, file2);
        System.out.println(sb.toString());

        fu.writeStringsToFile(resultFilename, sb.toString());

    }


}
