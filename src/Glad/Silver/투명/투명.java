package Glad.Silver.투명;

import java.util.Scanner;

public class 투명 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[101][101];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String[] split = sc.nextLine().split(" ");
            int x1 = Integer.parseInt(split[0]);
            int y1 = Integer.parseInt(split[1]);
            int x2 = Integer.parseInt(split[2]);
            int y2 = Integer.parseInt(split[3]);
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    arr[y][x]++;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if(arr[i][j] > M )answer++;
            }
        }
        System.out.println(answer);

    }
}
