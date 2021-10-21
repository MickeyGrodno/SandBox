package eu.senlacousese;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DifferentLines {
    public static void main(String[] args) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        try {
            BufferedReader f1 = new BufferedReader(new InputStreamReader(new FileInputStream(
                    "ZZ.txt"), "UTF8"));
            BufferedReader f2 = new BufferedReader(new InputStreamReader(new FileInputStream(
                    "ZZ1.txt"), "UTF8"));
            String st1;
            String st2;

            List<String> l1 = new ArrayList<>();
            List<String> l2 = new ArrayList<>();
            while ((st1 = f1.readLine()) != null) {
                sb1.append(st1);
                String str1;
                str1 = sb1.toString();
                l1 = Arrays.asList(str1.split(" "));
            }
            while ((st2 = f2.readLine()) != null) {
                String str2;
                sb2.append(st2);
                str2 = sb2.toString();
                l2 = Arrays.asList(str2.split(" "));
            }
            if (l1.equals(l2)) {
                System.out.println("Same");
            } else {
                System.out.println("Different");

                Iterator<String> iter1 = l1.iterator();
                Iterator<String> iter2 = l2.iterator();
                do {
                    st1 = iter1.next();
                    st2 = iter2.next();
                    if (!st1.equals(st2)) {
                        System.out.println(st1 + " " + st2);
                    }
                } while (iter1.hasNext());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
