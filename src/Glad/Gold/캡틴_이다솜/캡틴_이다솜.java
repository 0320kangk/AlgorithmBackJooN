package Glad.Gold.캡틴_이다솜;

import java.util.*;

public class 캡틴_이다솜 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N+1];

        //1..2..3..4...5........ 등차 수열
        // (1+5)*5 /2
        int size = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i-1] + (i+ 1) * i / 2;
            if(N <= dp[i] ) {
                if(N == dp[i])size = i;
                else size = i -1;
                break;
            }

        }
        int[] tetras = new int[size];
        for (int i = 1; i <= size; i++) {
            tetras[i-1] = dp[i];
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        while (!q.isEmpty()){
            int[] node = q.poll();
            if(node[0] == 0 ){
                answer = node[1];
                break;
            }
            for (int i = tetras.length -1; i >= 0 ; i--) {
                int next = node[0] - tetras[i];
                if(next >= 0 && !set.contains(next)){
                    q.add(new int[]{next, node[1] + 1});
                    set.add(next);
                }
            }
        }
        System.out.println(answer);
    }
}
