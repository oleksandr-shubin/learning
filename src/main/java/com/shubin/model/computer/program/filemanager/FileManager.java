package com.shubin.model.computer.program.filemanager;

import com.shubin.model.computer.program.Launchable;

import java.io.*;
import java.util.Scanner;

public class FileManager implements Launchable {
    public FileManager() {}

    private void copy(String source, String destination) {
        File sourceFile = new File(source);
        File destinationFile = new File(destination);
        if (sourceFile.exists() && destinationFile.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(sourceFile));
                 PrintWriter out = new PrintWriter(new BufferedWriter(
                         new FileWriter(destinationFile)))) {
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

    @Override
    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter name of source file: ");
                String source = scanner.nextLine().trim();
                System.out.print("Enter name of destination file: ");
                String destination = scanner.nextLine().trim();

                copy(source, destination);

                System.out.println("Enter q to quit or any other key to continue");
                String input = scanner.nextLine();
                if (input.equals("q")) {
                    System.out.println("Application is shutting down...");
                    break;
                }
                break;
            }
        }
    }
}
