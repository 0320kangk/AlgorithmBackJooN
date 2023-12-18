package Glad.Silver.삼각형으로_자르기;

import java.util.Scanner;

public class 삼각형으로_자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] points = new int[N][2];

        for (int i = 0; i < N; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        //모든 삼각형 넓이 구하기
        double maxArea = 0;
        for (int a = 0; a < N-2; a++) {
            for (int b = a + 1; b < N - 1; b++) {
                for (int c = b + 1; c < N; c++) {
                   double area = Math.abs ((points[a][0] * points[b][1]) + (points[b][0] * points[c][1] + points[c][0] * points[a][1]) -
                           (points[b][0] * points[a][1] + points[c][0] * points[b][1] + points[a][0] * points[c][1]))
                           / 2.0;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        System.out.println(maxArea);
    }
}
