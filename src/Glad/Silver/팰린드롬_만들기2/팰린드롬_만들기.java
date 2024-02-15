package Glad.Silver.팰린드롬_만들기2;

import java.util.Scanner;

public class 팰린드롬_만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int length = word.length();
        while(word.length() != 1){
            if (word.charAt(0) == word.charAt(word.length() - 1) ){
                if (!check(word)){
                    word = word.substring(1);
                    length ++;
                } else {
                    break;
                }
            } else {
                word = word.substring(1);
                length++;
            }
        }
        System.out.println(length );
    }
    static boolean check(String word) {
        int length = word.length();
        boolean result = true;
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)){
                result = false;
                break;
            }
        }
        return result;
    }
}
