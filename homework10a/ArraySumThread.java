package homework10a;

import java.util.concurrent.Callable;

public class ArraySumThread implements Callable<Long> {
    private int[] arr;

    public ArraySumThread(int[] arr) {
        this.arr = arr;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0L;
        for (Integer element : arr) {
            sum += element;
        }
        return sum;
    }
}
