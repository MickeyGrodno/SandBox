package eu.senlacousese;

import java.io.*;
import java.util.Scanner;

public class ReaderClass {
    public static void main(String[] args) throws IOException {
        File f = new File("text");
        getFileContent(f);
    }
    public static String getFileContent(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {

                System.out.println(sCurrentLine);
                sb.append(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
