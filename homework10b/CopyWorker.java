package homework10b;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyWorker {

    public void copyFiles(File sourceDir, File destinationDir) {
        String[] fileList = getFileList(sourceDir, destinationDir);
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (String fileName : fileList) {
            File currentFile = new File(sourceDir, fileName);
            if (currentFile.isDirectory()) {
                new CopyWorker().copyFiles(
                        new File(currentFile.getAbsolutePath()),
                        new File(destinationDir.getAbsolutePath(), currentFile.getName()));
                continue;
            }
            executorService.submit(new ThreadCopy(currentFile, new File(destinationDir, currentFile.getName())));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) ;
        System.out.println("Copy complete! Total " + fileList.length + " files copied.");
    }

    private String[] getFileList(File sourceDir, File destinationDir) {
        if (sourceDir == null || !sourceDir.isDirectory()) {
            throw new IllegalArgumentException("Source directory wrong!");
        }
        if (destinationDir == null || !destinationDir.isDirectory()) {
            destinationDir.mkdirs();
            System.out.println(destinationDir.getAbsolutePath() + " created!!");
        }
        return sourceDir.list();
    }
}
