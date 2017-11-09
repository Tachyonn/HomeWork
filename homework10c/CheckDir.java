package homework10c;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CheckDir implements Runnable {

    private File dir;

    public CheckDir(File dir) {
        this.dir = dir;
        if (dir == null || !dir.isDirectory()) {
            throw new IllegalArgumentException("Wrong directory or is file!");
        }
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        List<String> list1 = new LinkedList<>(Arrays.asList(dir.list()));
        List<String> list2;
        while (!thread.isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2 = new LinkedList<>(Arrays.asList(dir.list()));

            if (list1.size() > list2.size()) {
                list1.removeAll(list2);
                System.out.println("Removed: ");
                System.out.println(list1);
            } else if (list2.size() > list1.size()) {
                list2.removeAll(list1);
                System.out.println("Added: ");
                System.out.println(list2);
            }
            list1 = new LinkedList<>(Arrays.asList(dir.list()));
        }
        System.out.println("Thread was interrupted!");
    }
}
