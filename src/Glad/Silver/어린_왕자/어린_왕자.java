package Glad.Silver.어린_왕자;

import java.util.Scanner;

public class 어린_왕자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {

            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int planetCount = sc.nextInt();
            int[][] pArr = new int[planetCount][3];
            //두점이 한 행성에 포함됨 = 0
            //두점이 어느 행성에도 포함 안됨 =0
            //두 점중 하나가 포함됨 = 1
            for (int j = 0; j < pArr.length; j++) {
                pArr[j][0] = sc.nextInt();
                pArr[j][1] = sc.nextInt();
                pArr[j][2] = sc.nextInt();
            }
            //(x-a)^2 + (y-b)^2 < r^2
            // a b 는 행성의 좌표  x y는 시작점 혹은 도착점?
            int count = 0;
            for (int j = 0; j < pArr.length; j++) {
                int f1 = (int) (Math.pow(x1 - pArr[j][0], 2) + Math.pow(y1 - pArr[j][1], 2));
                int f2 = (int) (Math.pow(x2 - pArr[j][0], 2) + Math.pow(y2 - pArr[j][1], 2));
                int rr = (int) Math.pow(pArr[j][2], 2);
                if ((f1 < rr && f2 > rr) ||
                        f1 > rr && f2 < rr){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
