package eu.senlacousese;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class ReaderClass {
    public static void main(String[] args) throws IOException {
        File f = new File("branches.txt");
        getFileContent(f);
    }

    public static String getFileContent(File file) throws IOException {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {

                if (sCurrentLine.contains("<brtp>")) {
                    sCurrentLine = sCurrentLine.trim().substring(6);
                    sCurrentLine = sCurrentLine.substring(0, sCurrentLine.length() - 7);
                    set.add(sCurrentLine);
                }
            }

            set.stream().sorted();
            set.forEach(a -> System.out.println(a));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
