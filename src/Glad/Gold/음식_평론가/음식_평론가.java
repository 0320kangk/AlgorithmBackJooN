package Glad.Gold.음식_평론가;

import java.util.Scanner;

public class 음식_평론가 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        System.out.println( gcd(N, M));
        System.out.println(M - gcd(N, M));

    }
    //유클리드 호제법
    static int gcd(int n, int m) {
        if (m==0)return n;
        return gcd(m, n % m);
    }
}
