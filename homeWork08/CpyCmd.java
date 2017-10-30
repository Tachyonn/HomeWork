package homeWork08;

import java.io.*;

public class CpyCmd {

    public CpyCmd() {
    }

    public static void copyTo(File inputFile, File outputFile) {
        if (inputFile == null || outputFile == null) {
            throw new IllegalArgumentException("Argument(s) is NULL");
        }
        System.out.println("Copying " + inputFile.getAbsolutePath() + " to " + outputFile.getAbsolutePath());

        try (InputStream in = new FileInputStream(inputFile);
             OutputStream out = new FileOutputStream(outputFile)) {
            byte[] buffer = new byte[1024 * 1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Complete!");
    }

    public static void copyDir(String sourceDir, String destDir, String... extensions) {
        File srcDir = new File(sourceDir);
        if (!srcDir.isDirectory()) {
            throw new IllegalArgumentException("Source path is incorrect!");
        }
        File dstDir = new File(destDir);
        if (!dstDir.exists()) {
            dstDir.mkdirs();
        }
        CopyFileFilter fileFilter = new CopyFileFilter(extensions);
        File[] fileList = srcDir.listFiles(fileFilter);
        for (File currFile : fileList) {
            copyTo(currFile, new File(dstDir.getPath() + "\\" + currFile.getName()));
            //copyTo(currFile,new File(dstDir,currFile.getName())); // второй вариант
        }
    }
}
