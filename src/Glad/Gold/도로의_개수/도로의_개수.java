package Glad.Gold.도로의_개수;

import java.util.Arrays;
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
                roadConstructionH[Math.min(a ,c)][b] = true;
            }
        }
        arr[0][0] = 1;
        boolean colFlag = false;
        for (int i = 0; i < M + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if( arr[i][j] == 0 && ){

                }
            }

        }
        for (int i = 0; i < M + 1; i++) {
            System.out.println(Arrays.toString(arr[i]));
            System.out.println(Arrays.toString(roadConstruction[i]));

        }
        System.out.println(arr[M][N]);

    }

}
