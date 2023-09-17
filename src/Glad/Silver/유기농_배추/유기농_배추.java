package Glad.Silver.유기농_배추;

import java.util.*;

public class 유기농_배추 {
    static int[] dx = {1,0 ,-1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Queue<Integer[]> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int[][] arr = new int[M][N];
            int K = sc.nextInt();
            for (int j = 0; j < K; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[x][y] = 1;
            }
            int count = 0;
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[j][k] == 1) {
                        q.add(new Integer[] {j, k});
                        arr[j][k] = 0;
                        count++;
                        while(!q.isEmpty()){
                            Integer[] point = q.poll();
                            for (int l = 0; l < 4; l++) {
                                int x = point[0] + dx[l];
                                int y = point[1] + dy[l];
                                if ( (x < M && x>=0) &&
                                    (y < N && y>=0) &&
                                    arr[x][y] == 1){
                                    arr[x][y] = 0;
                                    q.add(new Integer[]{x, y});
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }

    }
}
