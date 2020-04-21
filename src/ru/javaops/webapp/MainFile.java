package ru.javaops.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) {
        String filePath = ".\\.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("./src/ru/javaops/webapp");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        printFiles(new File("C:\\Users\\plotn\\IdeaProjects\\basejava"));
    }

    public static void printFiles(File root) {
        if (root.exists()) {
            printContent(root, 0);
        } else {
            System.out.println("Directory is not found");
        }
    }

    public static void printContent(File file, int intend) {
        for (int i = 0; i < intend; i++) {
            System.out.print("\t");
        }
        if (file.isFile()) {
            System.out.println("File " + file.getName());
        } else {
            System.out.println("Directory " + file.getName());
            File[] list = file.listFiles();
            for (File f : list) {
                printContent(f, intend + 1);
            }
        }
    }
}

