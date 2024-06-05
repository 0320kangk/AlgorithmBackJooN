package Glad.Gold.울타리_치기;

import java.util.Scanner;

public class 울타리_치기 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1];
        int add = 1;
        dp[1] = 1;
        for (int i = 1; i < n + 1; i++) {
            if ( i % 6 == 0){
                add++;
                dp[i] = dp[i - 1] +add;
            } else if ( i % 6 == 1 && i != 1) {
                dp[i] = dp[i - 1] +  add - 1;
            } else {
                dp[i] = dp[i - 1] +  add;
            }
        }
        System.out.println(dp[n]);
    }
}
