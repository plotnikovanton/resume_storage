package ru.javaops.webapp.model;

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

        String projectPath = "C:\\Users\\plotn\\IdeaProjects\\basejava";
        recursivelyListFiles(projectPath);
    }

    static void recursivelyListFiles(String path) {
        File root = new File(path);
        File[] list = root.listFiles();

        if (list != null) {
            for (File file : list) {
                if (file.isDirectory()) {
                    System.out.println(file.getAbsolutePath());
                    recursivelyListFiles(file.getAbsolutePath());
                } else {
                    System.out.println(file.getAbsoluteFile());
                }
            }
        }
    }
}

