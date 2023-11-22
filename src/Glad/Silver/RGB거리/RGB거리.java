package Glad.Silver.RGB거리;

import java.util.Arrays;
import java.util.Scanner;

public class RGB거리 {
    static int MAX = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //dp라는데요
        int N = sc.nextInt();
        sc.nextLine();
        int[][] values = new int[N][3];
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            for (int j = 0; j < 3; j++) {
                values[i][j] = Integer.parseInt(split[j]);
            }
        }
        int[][] dp = new int[N][3];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], MAX);
        }
        for (int i = 0; i < 3; i++) {
            dp[0][i] = values[0][i];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < values[0].length; k++) {
                    if(k == j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + values[i][j]);
                }
            }
        }
        int min = MAX;
        for (int i = 0; i < 3; i++) {
            min = Math.min(dp[dp.length - 1][i], min);
        }
        System.out.println(min);
    }
}
