package Glad.Gold.호텔;

import java.util.Arrays;
import java.util.Scanner;

public class 호텔 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
           /*
            dp[c+100] = dp[c+100], 1 + dp[c]
            1+dp[c] > dp[c+100]
             */
        int C = sc.nextInt(); //고객
        int N = sc.nextInt(); //홍보 도시 수
        int[] personCost = new int[C + 100];
        Arrays.fill(personCost,100000);
        personCost[0] = 0;
        for (int i = 0; i < N; i++) {
            int cost = sc.nextInt();
            int person = sc.nextInt();
            for (int j = person; j < C + 100; j++) {
                personCost[j] = Math.min(personCost[j], cost + personCost[j-person]);
            }
        }
        int answer = 100000;
        for (int i = C; i < C + 100; i++) {
            answer = Math.min(answer, personCost[i]);
        }
        System.out.println(answer);
    }
}
