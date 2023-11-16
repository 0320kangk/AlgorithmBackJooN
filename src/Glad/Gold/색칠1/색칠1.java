package Glad.Gold.색칠1;

import java.util.Arrays;
import java.util.Scanner;

public class 색칠1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long W = sc.nextInt();
        long H = sc.nextInt();
        long f = sc.nextInt();
        long c = sc.nextInt();
        long[] point1 = {sc.nextInt(), sc.nextInt()};
        long[] point2 = {sc.nextInt(), sc.nextInt()};
        long WH = W * H;
        if (f > W- f) {
            f = W-f;
        }
        if (f <= point1[0]) {
            WH -= (point2[0] - point1[0]) * (point2[1] - point1[1]) * (c+1);
        }
        else if(f < point2[0]) {
            WH -= (f-point1[0]) * (point2[1] - point1[1]) * 2 * (c + 1);
            WH -= (point2[0] - f) * (point2[1] - point1[1]) * (c+1);
        }else {
            WH -= (point2[0] - point1[0]) * (point2[1] - point1[1]) *2 * (c+1);
        }
        System.out.println(WH);
    }
}
