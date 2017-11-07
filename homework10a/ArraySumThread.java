package homework10a;

import java.util.concurrent.Callable;

public class ArraySumThread implements Callable<Long> {
    private int[] arr;
    private int begin;
    private int end;

    public ArraySumThread(int[] arr, int begin, int end) {
        this.arr = arr;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0L;
        for (int i = begin; i < end; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
