package Glad.Gold.고층_건물;

import java.util.Scanner;

public class 고층_건물 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] buildings = new int[N];
        for (int i = 0; i < N; i++) {
            buildings[i] = sc.nextInt();
        }
        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            System.out.println("i: " + i);
            for (int j = 0; j < N; j++) {
                if (j == i)
                    continue;
                // i j 를 이으는 직선 만들기, y=ax + b
                double a = (double) (buildings[i] - buildings[j])/(i - j);
                double b = buildings[i] - a * i;
                boolean flag = false;
//                System.out.println("j: " + j);
                int left = Math.min(i, j);
                int right = Math.max(i, j);
                for (int k = left + 1; k < right; k++) {
                    double y = a * k + b;
                    System.out.println((int)y);
                    System.out.println("k: " + k);
                    if ((double) buildings[k] >= y){
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    count++;
                }
//                System.out.println("count: " + count);

            }
//            System.out.println(count);
//            System.out.println(i);
            maxCount  = Math.max(maxCount, count);
        }
        System.out.println(maxCount);
    }

}
