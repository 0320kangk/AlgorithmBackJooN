package Glad.Gold.도로의_개수;

import java.util.Scanner;

public class 도로의_개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        long[][] arr = new long[M+ 1][N+1];
        boolean[][] roadConstructionH = new boolean[M + 1][N + 1];
        boolean[][] roadConstructionV = new boolean[M + 1][N + 1];

        for (int i = 0; i < K; i++) {
            String[] road = sc.nextLine().split(" ");
            Integer a = Integer.parseInt(road[0]);
            Integer b = Integer.parseInt(road[1]);
            Integer c = Integer.parseInt(road[2]);
            Integer d = Integer.parseInt(road[3]);
            //행이동
            if(a == c) {
                roadConstructionV[Math.min(b,d)][a] = true;
            }
            //열이동
            else if(b == d){
                roadConstructionH[b][Math.min(a ,c)] = true;
            }
        }
        arr[0][0] = 1;
        for (int i = 0; i < M + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if(i == 0 && j == 0)continue;
                long moveV = 0;
                long moveH = 0;
                if ( i > 0 && !roadConstructionV[i-1][j]){
                    moveV = arr[i-1][j];
                }
                if(j > 0 && !roadConstructionH[i][j-1]){
                    moveH = arr[i][j-1];
                }
                arr[i][j] = moveV + moveH;
            }

        }
        System.out.println(arr[M][N]);

    }

}
