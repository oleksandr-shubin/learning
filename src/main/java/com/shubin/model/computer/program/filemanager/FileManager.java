package com.shubin.model.computer.program.filemanager;

import com.shubin.model.computer.program.Launchable;

import java.io.*;
import java.util.Scanner;

public class FileManager implements Launchable {
    public FileManager() {}

    public void copy(File source, File destination) {
        if (source.exists() && destination.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(source));
                 PrintWriter out = new PrintWriter(new BufferedWriter(
                         new FileWriter(destination)))) {
                int dataByte;
                while ((dataByte = in.read()) != -1) {
                    out.write(dataByte);
                }
                System.out.println("Copied successfully");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Create files before you do copy");
        }
    }

    @Override
    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter name of source file: ");
                String sourceName = scanner.nextLine().trim();
                File source = new File(sourceName);
                System.out.print("Enter name of destination file: ");
                String destinationName = scanner.nextLine().trim();
                File destination = new File(destinationName);

                copy(source, destination);

                System.out.println("Enter q to quit or any other key to continue");
                String input = scanner.nextLine();
                if (input.equals("q")) {
                    System.out.println("Application is shutting down...");
                    break;
                }
            }
        }
    }
}
