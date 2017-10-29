package homeWork12;

public class StackBlacklist {
    private String[] blacklist;
    private int classNameCount;

    public StackBlacklist() {
        blacklist = new String[10];
        classNameCount = 0;
    }

    public synchronized void add(Object toAdd) throws BlacklistedException {
        if (toAdd == null) {
            throw new IllegalArgumentException("Argument is Null!");
        }
        if (isBlacklisted(toAdd)) {
            throw new BlacklistedException("Class already in List!");
        }
        if (blacklist.length == classNameCount) {
            extendBlacklist();
        }
        for (int i = 0; i < blacklist.length; i++) {
            if (blacklist[i] == null) {
                blacklist[i] = toAdd.getClass().getName();
                classNameCount++;
                return;
            }
        }
    }

    public synchronized boolean isBlacklisted(Object toCheck) {
        if (toCheck == null) {
            throw new IllegalArgumentException("Argument is Null!");
        }
        for (String currClassName : blacklist) {
            if (currClassName != null &&
                    currClassName.equals(toCheck.getClass().getName())) {
                return true;
            }
        }
        return false;
    }

    private void extendBlacklist() {
        String[] tmpList = new String[blacklist.length + 2];
        System.arraycopy(blacklist, 0, tmpList, 0, blacklist.length);
        blacklist = tmpList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String currStr : blacklist) {
            if (currStr != null) {
                sb.append(currStr).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
