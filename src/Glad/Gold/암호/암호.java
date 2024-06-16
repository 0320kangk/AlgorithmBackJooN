package Glad.Gold.암호;

import java.util.Scanner;

public class 암호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String words = sc.next();
        String password = sc.next();
        int answer = 0;
        for (int i = 0; i < password.length() - 1; i++) {
            answer = (answer + words.length() *  (i + 1)) % 900528;
        }
        for (int i = 0; i < password.length(); i++) {
            answer += ((words.indexOf(password.charAt(i))) * words.length())  % 900528;
        }
        //abcdedasdacxv
        //aaa 시작하여
        //-> b c k 까지 가는데 걸리는 개수
        //k = 워드 위치(11) + 워드 위치(3) * 문자열 개수 +
        System.out.println(answer);
    }
}
