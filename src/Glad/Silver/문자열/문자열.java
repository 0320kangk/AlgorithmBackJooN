package Glad.Silver.문자열;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        int equalsCount = 0;
        for (int i = 0; i <= B.length() - A.length(); i++) {
            equalsCount = Math.max(findEqualsChar(A, B.substring(i, A.length() + i)), equalsCount);
        }
        System.out.println(equalsCount);
        System.out.println(A.length() - equalsCount);
    }
    static int findEqualsChar(String A, String B){
        int count = 0;
        System.out.println(B);
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(i))
                count++;
        }
        return count;
    }
}
