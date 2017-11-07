package homework10a;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CalculateArraySum {
    private static int step = 5000;
    private static int maxThreads = 100;

    public CalculateArraySum() {
    }


    public static Long getSum(int[] array) {

        ArrayList<Future<Long>> result = new ArrayList<>();
        ExecutorService exServ = Executors.newFixedThreadPool(maxThreads);

        for (int i = 0; i < array.length; ) {
            if (i + step < array.length) {
                result.add(exServ.submit(new ArraySumThread(array, i, i + step)));
                //System.out.println("Range from " + i + " to " + (i + step));
                i += step;
            } else {
                result.add(exServ.submit(new ArraySumThread(array, i, array.length)));
                //System.out.println("Range from " + i + " to " + (array.length));
                i += step;
            }
        }

        Long totalSize = 0L;
        for (Future<Long> future : result) {
            try {
                totalSize += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        exServ.shutdown();
        return totalSize;
    }
}
