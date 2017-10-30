package homeWork08;

import java.io.File;
import java.io.FileFilter;

public class CopyFileFilter implements FileFilter {
    private String[] extensions;

    public CopyFileFilter(String[] extensions) {
        super();
        this.extensions = extensions;
    }

    private boolean checkExtension(String ext) {
        for (String currExt : extensions) {
            if (currExt != null && currExt.equals(ext)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean accept(File pathname) {
        int pointerIndex = pathname.getName().lastIndexOf(".");
        if (pointerIndex == -1) {
            return false;
        }
        String ext = pathname.getName().substring(pointerIndex + 1);
        return checkExtension(ext);
    }

}
