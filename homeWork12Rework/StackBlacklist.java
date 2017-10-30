package homeWork12Rework;

public class StackBlacklist {
    private ObjectArrayList blacklist;

    public StackBlacklist() {
        blacklist = new ObjectArrayList();
    }

    public synchronized void add(Object toAdd) throws BlacklistedException {
        if (toAdd == null) {
            throw new IllegalArgumentException("Argument is Null!");
        }
        if (isBlacklisted(toAdd)) {
            throw new BlacklistedException("Class already in List!");
        }
        blacklist.add(toAdd.getClass().getName());
    }

    public synchronized boolean isBlacklisted(Object toCheck) {
        if (toCheck == null) {
            throw new IllegalArgumentException("Argument is Null!");
        }
        return blacklist.contains(toCheck.getClass().getName());
    }

    @Override
    public String toString() {
        return blacklist.toString();
    }
}
