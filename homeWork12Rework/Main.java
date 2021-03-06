package homeWork12Rework;

public class Main {
    public static void main(String[] args) throws BlacklistedException {

        Stack stack1 = new Stack();
        StackBlacklist blacklist1 = stack1.getBlacklist();

        // Тестируем черный список
        //blacklist1.add(new Integer(10));
        blacklist1.add(new Double(10));
        System.out.println(blacklist1);

        stack1.setBlacklist(blacklist1);

        stack1.push(new String());
        stack1.push(new Double(10));
        System.out.println(stack1.peek());


        // Тест операций со стеком
        System.out.println("Stack size " + stack1.size());
        System.out.println("Stack is empty? " + stack1.isEmpty());

        for (int i = 0; i < 20; i++) {
            stack1.push(new Integer(i));
        }

        System.out.println(stack1);

        stack1.peek();

        System.out.println("Stack size " + stack1.size());
        System.out.println("Stack is empty? " + stack1.isEmpty());

        for (int i = 0; i < 20; i++) {
            System.out.println("Popped " + stack1.pop());
        }
        stack1.pop();
        stack1.pop();
        stack1.pop(); // Тут исключение пустого стека
        stack1.pop();

        System.out.println("Stack size " + stack1.size());
        System.out.println("Stack is empty? " + stack1.isEmpty());
    }
}
