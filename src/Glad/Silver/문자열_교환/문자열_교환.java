package Glad.Silver.문자열_교환;

import java.util.Scanner;

public class 문자열_교환 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        int countA = 0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == 'a') countA++;
        }
        int start = 0;
        int end = countA - 1;
        int minB = countA;
        while (start < word.length()) {
            int countB = 0;
            for (int j = start; j <= end; j++) {
                if(word.charAt(j % word.length()) == 'b') countB++;
            }
            if(minB > countB) minB = countB;
            start++;
            end++;
        }
        System.out.println(minB);
    }
}
