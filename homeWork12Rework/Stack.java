package homeWork12Rework;

/*
    Вторая версия стека
    Посторена на основе самописного списка, подобного ArrayList
 */

import java.util.EmptyStackException;

public class Stack {
    private ObjectArrayList stack;
    private StackBlacklist blacklist;

    public Stack() {
        stack = new ObjectArrayList();
        blacklist = new StackBlacklist();
    }

    public Stack(StackBlacklist blacklist) {
        stack = new ObjectArrayList();
        this.blacklist = blacklist;
    }

    public synchronized void push(Object toPush) throws BlacklistedException {
        if (toPush == null) {
            throw new IllegalArgumentException("Argument is Null!");
        }
        if (blacklist.isBlacklisted(toPush)) {
            throw new BlacklistedException();
        }
        stack.add(toPush);
    }

    public synchronized Object pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        Object result = stack.get();
        stack.remove();
        return result;
    }

    public synchronized Object peek() {
        return stack.get();
    }

    public synchronized int size() {
        return stack.size();
    }

    public synchronized StackBlacklist getBlacklist() {
        return blacklist;
    }

    public synchronized void setBlacklist(StackBlacklist blacklist) {
        this.blacklist = blacklist;
    }

    public synchronized boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
