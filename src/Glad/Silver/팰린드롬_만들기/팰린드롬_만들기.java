package Glad.Silver.팰린드롬_만들기;

import java.util.*;

public class 팰린드롬_만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        TreeMap<Character, Integer> tMap = new TreeMap<>();
        for (int i = 0; i < name.length(); i++) {
            tMap.put(name.charAt(i), tMap.getOrDefault(name.charAt(i), 0) + 1);
        }
        System.out.println(tMap);
        //tmap이 짝수이면 모두가 2
        //홀수이면 1개만 1개
        boolean flag = false;
        if(name.length() % 2 == 0){
            for (Integer value : tMap.values()) {
                if (value % 2 == 1) flag = true;
            }
        } else  {
            int count = 0;
            for (Integer value : tMap.values()) {
                if (value % 2 == 1) count++;
            }
            if (count != 1) flag = true;
        }
        char[] chars = new char[name.length()];
        if(flag){
            System.out.println("I'm Sorry Hansoo");
        }
        else {
            int idx = 0;
            for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
                Integer value = entry.getValue();
                Character key = entry.getKey();
                if (value % 2 == 1) {
                    chars[name.length() / 2] = key;
                    value--;
                }
                for (int i = 0; i < value/2; i++) {
                    chars[idx] = key;
                    chars[name.length() - idx - 1] = key;
                    idx++;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char aChar : chars) {
                sb.append(aChar);
            }
            System.out.println(sb);
        }//AVAVVA

    }
}
