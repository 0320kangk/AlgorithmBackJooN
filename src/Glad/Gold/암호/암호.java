package Glad.Gold.암호;

import java.util.Scanner;

public class 암호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String words = sc.next();
        String password = sc.next();
        //26*2 + 11
        //52+11
        //63
        long answer = 0;
        long multiplier = 1;
        int module = 900528;
        for (int i = 0; i < password.length() - 1; i++) {
            multiplier = (words.length() * multiplier) % module;
            answer = (answer + multiplier) % module;
        }
        System.out.println(answer);
        multiplier = 1;
        for (int i = password.length() - 1; i >= 0; i--) {
            answer = (answer + (words.indexOf(password.charAt(i))) * multiplier) % module;
            multiplier = ((words.length())  * multiplier) % module;
        }
        System.out.println( (answer + 1) % module);
    }
}
