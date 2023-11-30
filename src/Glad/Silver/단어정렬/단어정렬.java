package Glad.Silver.단어정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 단어정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<String> list = new ArrayList<String>();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String word = sc.nextLine();
            if(!list.contains(word))
                list.add(word);
        }
        Collections.sort(list, (w1,w2) -> {
            if (w1.length() != w2.length() )
                return w1.length() - w2.length();
            else
                return w1.compareTo(w2);
        });
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
