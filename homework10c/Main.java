package homework10c;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("d:/testdir1/");
        new Thread(new CheckDir(file)).start();
    }
}
