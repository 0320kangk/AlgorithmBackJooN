package Glad.Gold.오만식;

import java.util.Scanner;

public class 오민식 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        final int MOD = 987654321;
        long L = 1; // 최소공배수를 저장할 변수

        for (int i = 1; i <= N; i++) {
            L = lcm(L, i, MOD);
        }
        System.out.println(L);
    }

    // 최대공약수(GCD) 계산
    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // 최소공배수(LCM) 계산 (모듈러 연산 포함)
    public static long lcm(long a, long b, int mod) {
        return (a * (b / gcd(a, b))) % mod;
    }
}