package model.computer.program.filemanager;

import java.io.*;

public class FileManager {
    public FileManager() {}

    public void copy(String source, String destination) {
        File sourceFile = new File(source);
        File destinationFile = new File(destination);
        if (sourceFile.exists() && destinationFile.exists()) {
            try (FileReader in = new FileReader(sourceFile);
                 FileWriter out = new FileWriter(destinationFile)) {
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
