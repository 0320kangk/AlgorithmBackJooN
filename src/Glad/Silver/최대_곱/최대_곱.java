package Glad.Silver.최대_곱;

import java.util.Scanner;


public class 최대_곱 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int K = sc.nextInt();

        int q =  S / K;
        int r = S % K;
        int answer = 1;
        //r만큼 개산
        for (int i = 0; i < r; i++) {
            answer *= (q + 1);
        }
        for (int i = r; i < K; i++) {
            answer *= q;
        }
        System.out.println(answer);
    }
}