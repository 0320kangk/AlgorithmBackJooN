package Glad.Gold.뒤집기_3;

import java.util.Scanner;

public class 뒤집기_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        String str = String.valueOf(word.charAt(0));

        for (int i = 1; i < word.length() ; i++) {
            if(str.charAt(i - 1) < word.charAt(i)){
                str = word.charAt(i) + str;
            } else {
                str = str + word.charAt(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        String answer = sb.append(str).reverse().toString();
        System.out.println(answer);

    }
}
