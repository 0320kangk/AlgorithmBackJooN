package Glad.Gold.캡틴_이다솜;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 캡틴_이다솜_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //1. 사면체 수 계산
        List<Integer> tetra = new ArrayList<>();
        int num = 1, sum = 1;
        while (sum <= N) {
            tetra.add(sum);
            num++;
            sum += (num * (num + 1)) / 2;
        }

        //답구하기
        //
        int[] dp = new int[N + 1]; // key : 대포알 수 value : 최소 사면체 수
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        //첫 번째 사면체에 필요한 대포알 수 부터 갱신
        for (int i = 0; i < tetra.size(); i++) {
            Integer t = tetra.get(i);
            for (int j = t; j <= N; j++) {
                if(dp[j-t] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j] ,dp[j-t] + 1);
                }
            }
        }
        System.out.println(dp[N]);
    }
}
