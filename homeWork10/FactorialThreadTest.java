package homeWork10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FactorialThreadTest {
    public static void main(String[] args) {
        ExecutorService exSer = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 100; i++) {
            exSer.submit(new FactorialThread(i + 1));
        }

        exSer.shutdown();
    }
}
