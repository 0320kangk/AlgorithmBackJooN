package Glad.Silver.소트인사이드;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 소트인사이드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] split = String.valueOf(N).split("");
        Arrays.sort(split, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(s);
        }
        System.out.println(sb);
    }
}
