package Glad.Gold.문자_해독;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 문자_해독 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int s = sc.nextInt();
        String W = sc.next();
        String S = sc.next();


        Map<Character, Integer> wMap = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < W.length(); i++) {
            wMap.put(W.charAt(i), wMap.getOrDefault(W.charAt(i),0) + 1 );
        }
        HashMap<Character, Integer> sMap = new HashMap<>();
        int start = 0;
        int end = W.length() - 1;
        for (int i = start; i <= end; i++) {
            sMap.put(S.charAt(i), sMap.getOrDefault(S.charAt(i), 0) + 1);
        }
        while (end < S.length()) {
            if(wMap.equals(sMap)){
                answer++;
            }
            if(end + 1 == S.length()) break;
            char newChar = S.charAt(++end);
            char oldChar = S.charAt(start++);

            sMap.put(newChar, sMap.getOrDefault(newChar, 0) + 1);
            sMap.put(oldChar, sMap.get(oldChar) -1);

            if(sMap.get(oldChar) == 0) sMap.remove(oldChar);

        }
        System.out.println(answer);

    }
}
