package Glad.Silver.복권;

import java.util.Scanner;

public class 복권 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //1~N개의 수
        int M = sc.nextInt(); // 서로 다른 M개의 수
        int K = sc.nextInt(); // K개 이상 뽑는다면 당첨
        long total = combination(N, M);
        double answer = 0;
        while(M >= K) {
            double l = combination(M, K) * combination(N - M, M - K);
            answer += l/total;
            K++;
        }
        System.out.println(answer);
    }
    public static long combination(int n, int r) {
        int p = 1;
        int rf = 1;

        while (r > 0) {
            p *= n--;
            rf *= r--;
        }
        return p/rf;
    }
}
