package Glad.Silver.단어_나누기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 단어_나누기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                StringBuilder sb = new StringBuilder();
                StringBuilder r1 = new StringBuilder(word.substring(0, i)).reverse();
                System.out.println(r1);
                StringBuilder r2 = new StringBuilder(word.substring(i, j)).reverse();
                StringBuilder r3 = new StringBuilder(word.substring(j)).reverse();
                sb.append(r1).append(r2).append(r3);
                list.add(sb.toString());
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
