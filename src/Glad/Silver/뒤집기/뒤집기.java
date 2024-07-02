package Glad.Silver.뒤집기;

import java.util.HashMap;
import java.util.Scanner;

public class 뒤집기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        HashMap<Integer, Integer> map = new HashMap<>();
        char next = ' ';
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) != next){
                next = S.charAt(i);
                map.put(next - '0', map.getOrDefault(next - '0', 0) + 1);
            }
        }
        if(map.size() == 1) {
            System.out.println(0);
        } else {
            Integer value = map.entrySet()
                    .stream()
                    .min((x, y) -> x.getValue() - y.getValue())
                    .get()
                    .getValue();

            System.out.println(value);
        }

    }
}
