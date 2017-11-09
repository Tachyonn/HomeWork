package homework10b;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File sourceDir = new File("d:/testdir1/");
        File destinationDir = new File("d:/testdir2/");
        new CopyWorker().copyFiles(sourceDir, destinationDir);
    }
}
