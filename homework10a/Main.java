package homework10a;

public class Main {
    public static void main(String[] args) {
        int maxElements = 1_000_000;
        int[] testArray = new int[maxElements];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = i;
        }
        Long timeStart = System.currentTimeMillis();
        System.out.println("Concurrent total Sum is " + CalculateArraySum.getSum(testArray));
        Long timeEnd = System.currentTimeMillis();
        System.out.println("Total concurrent time is " + (timeEnd - timeStart) + " ms");

        System.out.println();
        timeStart = System.currentTimeMillis();
        System.out.println("Non-concurrent total Sum is " + foreachSum(testArray));
        timeEnd = System.currentTimeMillis();
        System.out.println("Total Non-concurrent time is " + (timeEnd - timeStart) + " ms");

    }

    private static Long foreachSum(int[] array) {
        Long totalSum = 0L;
        for (int el : array) {
            totalSum += el;
        }
        return totalSum;
    }
}
