package Glad.Silver.동물원;

import java.util.Scanner;

public class 동물원 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if( N == 1) {
            System.out.println(3);
            System.exit(1);
        }
        int[] dp = new int[N + 1];
        dp[1] = 3;
        dp[2] = 7;

        for (int i = 3; i < N + 1; i++) {
            dp[i] = (2 * dp[i-1] + dp[i-2]) % 9901;
        }
        System.out.println(dp[N]);
        //arr[i] = arr[i-1] + ((arr[i-2] + (arr[i-1] - arr[i-2]) / 2) * 2 =
        //arr[i] = (2 arr[i-1] + arr[i-2] )
        // ==
        //arr[i-1] = 2arr[i-2] + arr[i-3]
    }
}
