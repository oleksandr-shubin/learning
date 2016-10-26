package model.computer.program.filemanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileManager {
    public FileManager() {}

    public void copy(String source, String destination) {
        File sourceFile = new File(source);
        File destinationFile = new File(destination);
        if (sourceFile.exists() && destinationFile.exists()) {
            try (FileInputStream in = new FileInputStream(sourceFile);
                 FileOutputStream out = new FileOutputStream(destinationFile)) {
                int dataByte;
                while ((dataByte = in.read()) != -1) {
                    out.write(dataByte);
                }
                System.out.println("Copied successfully");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Create files before you do copy");
        }
    }
}
