package Glad.Gold.개근상;

import java.util.Arrays;
import java.util.Scanner;

public class 개근상 {

    static int n;
    static int dp[][][];
    static int DIV = 1_000_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dp = new int[n+ 1][3][4];

        for(int i=0; i<n+1; i++) {
            for(int j=0; j<3; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(solve(0, 0, 0));

    }

    static int solve(int day, int late, int absent) {
        if(dp[day][late][absent] != -1) return dp[day][late][absent];
        if (late > 1 || absent == 3) return 0;
        if(day == n)return 1;
        dp[day][late][absent] = 0;

        dp[day][late][absent] = solve(day + 1, late, 0)
                            + solve(day +1 , late + 1, 0)
                            + solve(day +1, late , absent + 1);
        return dp[day][late][absent] % DIV;

    }
}
