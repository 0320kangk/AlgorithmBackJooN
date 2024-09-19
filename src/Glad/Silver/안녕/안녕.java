package Glad.Silver.안녕;

import java.util.Arrays;
import java.util.Scanner;

public class 안녕 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] st = sc.nextLine().split(" ");
        String[] hp = sc.nextLine().split(" ");
        int[][] infos = new int[N + 1][2];
        for (int i = 1; i < N + 1; i++) {
            infos[i][0] = Integer.parseInt(st[i -1]);
            infos[i][1] = Integer.parseInt(hp[i -1]);
        }
        Integer[][] hps = new Integer[N + 1][100];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(hps[i], 0);
        }
        //i = N번째 인사
        //j = 최대 피도로 수치
        // hps[i][j] = 가장 효율적인 행복 수치
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < 100; j++) {
                    if( j < infos[i][0] ){
                        hps[i][j] = hps[i-1][j];
                    } else {
                        hps[i][j] = Math.max(hps[i-1][j - infos[i][0]] + infos[i][1], hps[i-1][j]);
                    }
            }
        }

        System.out.println(hps[N][99]);
    }
}

