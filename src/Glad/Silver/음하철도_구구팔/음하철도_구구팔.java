 package Glad.Silver.음하철도_구구팔;

import java.util.Scanner;

public class 음하철도_구구팔 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int xs = sc.nextInt();
        int ys = sc.nextInt();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int dx = sc.nextInt();
        int dy = sc.nextInt();

        if (dy == 0 && dx == 0 ) {
            System.out.println(x1 + " " + y1);
            return;
        }

        //dx 가 고정일 때
        if (dx == 0){
            if (dy > 0){
                if(ys > y1){
                    System.out.println(x1 + " " + ys);
                }else {
                    System.out.println(x1 + " " + y1);
                }
            }else {
                if(ys < y1){
                    System.out.println(x1 + " " + ys);
                }else {
                    System.out.println(x1 + " " + y1);
                }
            }
            return;
        }
        //dy가 고정일 때
        if (dy == 0){
            if (dx > 0){
                if(xs > x1){
                    System.out.println(xs + " " + y1);
                }else {
                    System.out.println(x1 + " " + y1);
                }
            }else {
                if(ys < y1){
                    System.out.println(xs + " " + y1);
                }else {
                    System.out.println(x1 + " " + y1);
                }
            }
            return;
        }
        double a1 = (double) dy /dx;
        double b1 =  y1 - a1 * x1;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];

        // y= 2x + 3
        for (int x = x1; x <= 100; x++) {
            int y = (int)(x * a1 + b1);
            double y2 = x * a1 + b1;
            if(y != y2) continue;
            int dist = (int)(Math.pow(y-ys, 2) + Math.pow(x-xs, 2));
            if (min > dist){
                min = dist;
                answer[0] = x;
                answer[1] = y;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
