package Glad.Gold.압축;

import java.util.Scanner;
import java.util.Stack;

public class 압축 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        Stack<String> stack = new Stack<>();
        int qLength = 0;
        for (int i = 0; i < S.length(); i++) {
            StringBuilder sb = new StringBuilder();
            char c = S.charAt(i);
            while(( c >= '0' && c <= '9')){
                sb.append(c);
                c= S.charAt(++i);
            }
            if(sb.length() > 0) stack.add(sb.toString());
            if (c == '(') stack.add(String.valueOf(c));
            else {
                if(qLength == 0) {
                    qLength = stack.pop().length();
                    stack.pop();
                }
                String K = stack.pop();
                int r = Integer.parseInt(K) % 10;
                qLength *= r;
                qLength += K.length() - 1;
            }

        }
        System.out.println(qLength);

        /*
        71(9) = 79
        562(79)
        33(567979)
        3 567979 567979 567979

        --스택
        9
        (
        71
        (
        562
        (
        33
        --
        ')' 만나면 9 꺼내기
        초기값이 없다면 한번더 꺼내기
        left = 71 꺼내기
        right = 9
        7

         567979

         */


    }
}
