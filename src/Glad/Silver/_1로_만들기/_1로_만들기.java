package Glad.Silver._1로_만들기;

import java.util.Scanner;

public class _1로_만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int[] dp = new int[X + 1];
        if(X == 1){
            System.out.println(0);
        } else if ( X > 1 && X < 4){
            System.out.println(1);
        }else {
            dp[1] = 0;
            dp[2] = 1;
            dp[3] = 1;
            for (int i = 4; i <= X; i++) {
                int case1 = i;
                int case2 = i;
                if( i % 2 == 0) case1 = dp[i / 2];
                if (i % 3 == 0) case2 = dp[i / 3] ;
                int case3 = dp[i - 1] ;

                dp[i] = Math.min(case1, Math.min(case2, case3)) + 1;
            }
            int answer = dp[X];
            System.out.println(answer);
        }

    }
}
