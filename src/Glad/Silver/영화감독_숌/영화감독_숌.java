package Glad.Silver.영화감독_숌;

import java.util.Scanner;

public class 영화감독_숌 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int answer = 666;
        for (int i = 1666; i < 10000000; i++) {
            String s = String.valueOf(i);
            if(s.contains("666")) count++;
            if(count == N ) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
