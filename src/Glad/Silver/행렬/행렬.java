package Glad.Silver.행렬;

import java.util.Scanner;

public class 행렬 {
    public static void main(String[] args) {

        /*
        한칸씩 비교하면서 확인하는 문제
        만약 다르다면 9칸 전체를 바꾸자.
        바꾸는 수는 겹치지 않도록 조정
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[][] A = new boolean[N][M];
        boolean[][] B = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String values = sc.next();
            for (int j = 0; j < M; j++) {
                if (values.charAt(j) == '1')
                    A[i][j] = true;
            }
        }
        for (int i = 0; i < N; i++) {
            String values = sc.next();
            for (int j = 0; j < M; j++) {
                if (values.charAt(j) == '1')
                    B[i][j] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if( A[i][j] != B[i][j]){
                    count++;
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            A[i + k][j + l] = !A[i + k][j + l];
                        }
                    }
                }
            }
        }
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j])
                    flag = true;
            }
        }
        if (flag)
            System.out.println(-1);
        else
            System.out.println(count);
    }
}
