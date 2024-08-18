package Glad.Gold.숌_사이_수열;

import java.util.*;

public class 숌_사이_수열 {
    static int[] X;
    static int[] X2;
    static int N ;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        String[] split = sc.nextLine().split(" ");
        X = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(split[i]);
        }
        X2 = new int[N * 2];
        Arrays.sort(X);
        Arrays.fill(X2, - 1);

        visited = new boolean[X2.length];
        backTracking(0);
        System.out.println(sb);

    }
    static void backTracking(int length){
        if (length == 2 * N) {
            for (int i = 0; i < 2 * N; i++) {
                sb.append(X2[i]).append(" ");
            }
            return;
        }
        if (sb.length() != 0) return;

        if (X2[length] != -1) {
            backTracking(length + 1);
            return;
        }
        for (int i = 0; i < N; i++) {
            if( visited[i]) continue;
            if(length + X[i] + 1 < N * 2 &&
                    X2[length] == -1 &&
                    X2[length + X[i] + 1] == -1  ){
                visited[i] = true;
                X2[length] = X2[length + X[i] + 1] = X[i];
                System.out.println(Arrays.toString(X2));
                backTracking(length + 1);
                X2[length] = X2[length + X[i] + 1] = -1;
                visited[i] = false;
            }
        }
    }
}
