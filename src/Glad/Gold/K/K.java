package Glad.Gold.K;

import java.util.Scanner;

public class K {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strA = sc.nextLine().split(" ");
        long[] sumA = new long[n + 1];
        for (int i = 1; i < sumA.length; i++) {
            sumA[i] = Integer.parseInt(strA[i-1]) + sumA[i - 1];
        }
        long min = Long.MAX_VALUE;
        int K = 0;
        for (int k = 1; k <= n/2; k++) { // s(i,j)  길이
            for (int i = k; i <= n; i++) { //
                for (int j = i + k; j <= n; j++) {
                    long result = Math.abs((sumA[i] - sumA[i-k]) - (sumA[j] -sumA[j-k]));
                    if(min >= result){
                        min = result;
                        K = k;
                    }
                }
            }
        }
        System.out.println(K);
        System.out.println(min);
    }
}
