package homeWork12;

/*
    Стек динамический, авторасширение, автоуменьшение.
    Два конструктора - без параметров и с параметром черного списка. Если без параметров, тогда черный список будет
    создан автоматически и для работы с ним нужно будет с помощю геттера взять уже созданный, либо с помощью сеттера
    прописать свой.
    Попробовал сделать потокобезопасным.
 */

public class Stack {
    private Object[] stack;
    private StackBlacklist blacklist;
    private int pointer = -1;

    public Stack() {
        stack = new Object[10];
        blacklist = new StackBlacklist();
    }

    public Stack(StackBlacklist blacklist) {
        stack = new Object[10];
        this.blacklist = blacklist;
    }

    public synchronized void push(Object toPush) throws BlacklistedException {
        if (toPush == null) {
            throw new IllegalArgumentException("Argument is Null!");
        }
        if (blacklist.isBlacklisted(toPush)) {
            throw new BlacklistedException();
        }

        checkToExtend();

        stack[++pointer] = toPush;
    }

    private void checkToExtend() {
        if (pointer == stack.length - 1) {
            extendStack();
        }
    }

    private void extendStack() {
        Object[] tmpStack = new Object[stack.length + 5];
        System.arraycopy(stack, 0, tmpStack, 0, stack.length);
        stack = tmpStack;
    }

    public synchronized Object pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        checkToShrink();
        return stack[pointer--];
    }

    public synchronized boolean isEmpty() {
        return pointer < 0;
    }

    private void checkToShrink() {
        if ((stack.length - pointer) > 10 && stack.length > 10) {
            shrinkStack();
        }
    }

    private void shrinkStack() {
        Object[] tmpStack = new Object[size()];
        System.arraycopy(stack, 0, tmpStack, 0, size());
        stack = tmpStack;
    }

    public synchronized Object peek() {
        return stack[pointer];
    }


    public synchronized int size() {
        return pointer + 1;
    }

    public synchronized StackBlacklist getBlacklist() {
        return blacklist;
    }

    public synchronized void setBlacklist(StackBlacklist blacklist) {
        this.blacklist = blacklist;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = pointer; i >= 0; i--) {
            sb.append(stack[i].getClass().getName());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
