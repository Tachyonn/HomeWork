package homeWork10;

import java.math.BigInteger;

public class FactorialThread implements Runnable {
    private int n;

    public FactorialThread() {
    }

    public FactorialThread(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        Thread th = Thread.currentThread();
        System.out.println(" " + th.getName() + " " + n + " -> " + " != " + factorialCalculate(n));
    }

    private BigInteger factorialCalculate(int n) {
        BigInteger fact = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(new BigInteger("" + i));
        }
        return fact;
    }
}
