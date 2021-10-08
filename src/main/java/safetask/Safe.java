package safetask;
//        Есть набор предметов, задаваемый заранее, предметы могут повторяться.
//        Предмет имеет 2 параметра (обязательных, остальные добавлять на усмотрение): объем (целое значение) и ценность (целое значение).
//        Предметы неделимы. Также задаётся сейф с обязательным параметром его объёма (целое значение).
//        Нужно написать программу, которая наполняет сейф набором предметов таким образом, чтобы ценность этого набора была максимальной.


import java.util.LinkedList;
import java.util.Scanner;

public class Safe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("введите слово");
        String line = scan.nextLine();
        String[] split = line.split(" ");
        int count = 0;
//        for (int i = 0; i < split.length(); i++) {
//
//            char word = split.charAt(i);
//
//            if (word == 'а' || word == 'у' || word == 'о' || word == 'ы' || word == 'и' || word == 'э'||
//                    word == 'я'|| word=='ю'|| word=='ё'|| word =='е'){
//                count++;
//            }
//
//
//        }
        System.out.println(count +" " + split);
    }
}
