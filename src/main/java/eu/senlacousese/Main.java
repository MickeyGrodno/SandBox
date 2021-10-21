package eu.senlacousese;

import java.io.*;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        int k1 = 2;
        int k2 = 9;
        newFile(k1, k2);
    }

    public static void newFile(int k1, int k2) throws Exception {
        String property = System.getProperty("line.separator");
        FileWriter nFile = new FileWriter("file1.txt");
        for (int i = k1; i <= k2; i++) {
            nFile.write(i+"\r\n");
        }
        nFile.close();
    }
}