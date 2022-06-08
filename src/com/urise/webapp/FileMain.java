package com.urise.webapp;

import java.io.File;
import java.util.Objects;

public class FileMain {
    public static final String GREEN_COLOR = "\033[0;32m";
    public static final String NORMAL_COLOR = "\033[0m";
    public static final String LAST_NODE = "└──";
    public static final String NOT_LAST_NODE = "├──";
    public static final String LAST_BRANCH = "  ";
    public static final String NOT_LAST_BRANCH = "│ ";

    public static void main(String[] args) {
        printCurrentDirTree(new File("./"), "");
    }

    protected static void printCurrentDirTree(File dir, String offset) {
        File[] fileList = dir.listFiles();
        for (int i = 0; i < Objects.requireNonNull(fileList).length; i++) {
            File file = fileList[i];
            boolean lastNode = i == fileList.length - 1;
            if (file.isDirectory()) {
                System.out.println(offset
                        + (lastNode ? LAST_NODE : NOT_LAST_NODE)
                        + GREEN_COLOR + file.getName() + NORMAL_COLOR);
                printCurrentDirTree(file, lastNode ? offset + LAST_BRANCH : offset + NOT_LAST_BRANCH);
            } else {
                System.out.println(offset + (lastNode ? LAST_NODE : NOT_LAST_NODE) + file.getName());
            }
        }
    }
}
