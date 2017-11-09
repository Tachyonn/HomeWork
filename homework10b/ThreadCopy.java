package homework10b;

import java.io.*;

public class ThreadCopy implements Runnable {
    private File from;
    private File to;


    public ThreadCopy(File from, File to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        copyTo(from, to);
    }

    public void copyTo(File inputFile, File outputFile) {
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
    }
}
