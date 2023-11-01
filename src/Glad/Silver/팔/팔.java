package Glad.Silver.팔;

import java.util.*;
import java.util.stream.Collectors;

public class 팔 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String L = sc.next();
        String R = sc.next();
        int count8 =0;
        if (L.length() == R.length()){
            for (int i = 0; i < L.length(); i++) {
                if(L.charAt(i) == '8' && R.charAt(i) == '8')count8++;
                else if(L.charAt(i) == R.charAt(i)) continue;
                else break;

            }
        }

        System.out.println(count8);


    }
}
