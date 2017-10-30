package homeWork12Rework;

public class ObjectArrayList {
    private Object[] list;
    private int pointer = -1;

    public ObjectArrayList() {
        list = new Object[10];
    }

    public synchronized void add(Object toAdd) {
        if (toAdd == null) {
            throw new IllegalArgumentException("Argument is Null!");
        }
        checkToExtend();
        list[++pointer] = toAdd;
    }

    private void checkToExtend() {
        if (pointer == list.length - 1) {
            extendList();
        }
    }

    private void extendList() {
        Object[] tmpList = new Object[list.length + 5];
        System.arraycopy(list, 0, tmpList, 0, list.length);
        list = tmpList;
    }

    public synchronized Object get() {
        return list[pointer];
    }

    public synchronized void remove() {
        if (this.isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
        checkToShrink();
        pointer--;
    }

    public synchronized boolean isEmpty() {
        return pointer < 0;
    }

    private void checkToShrink() {
        if ((list.length - pointer) > 10 && list.length > 10) {
            shrinkList();
        }
    }

    private void shrinkList() {
        Object[] tmpList = new Object[size()];
        System.arraycopy(list, 0, tmpList, 0, size());
        list = tmpList;
    }

    public synchronized boolean contains(Object toFind) {
        if (toFind == null) {
            throw new IllegalArgumentException("Argument is Null!");
        }
        for (int i = 0; i < size(); i++) {
            if (list[i] != null && list[i].equals(toFind)) {
                return true;
            }
        }
        return false;
    }

    public synchronized int size() {
        return pointer + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = pointer; i >= 0; i--) {
            sb.append(list[i].toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
