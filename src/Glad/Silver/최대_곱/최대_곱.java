package Glad.Silver.최대_곱;

import java.util.Scanner;


public class 최대_곱 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int K = sc.nextInt();

        // S를 K로 나누어 기본 값을 구합니다.
        int q = S / K;
        int r = S % K;
        long result = 1;
        // r개의 수는 q+1로 설정하고, 나머지는 q로 설정하여 곱합니다.
        for (int i = 0; i < r; i++) {
            result *= (q + 1);
        }
        System.out.println(K);
        System.out.println(r);
        // 3, 0 1 2,  3 4 => r=3, k=5
        for (int i = r; i < K; i++) {
            result *= q;
        }

        System.out.println(result);
    }
}