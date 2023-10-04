package Glad.Silver.기타줄;

import java.util.Scanner;

public class 기타줄 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int minSet = 1000;
        int minE = 1000;
        for (int i = 0; i < M; i++) {
            int set = sc.nextInt();
            int e = sc.nextInt();
            minSet = Math.min(set, minSet);
            minE = Math.min(minE, e);
        }
        int total;
        if(minSet / 6  < minE){
            int sum1 = N / 6 * minSet + (N % 6) * minE;
            //세트로만 사야하는 경우도있네
            int sum2 = (int)Math.ceil(N / 6.0) * minSet;
            total = Math.min(sum1, sum2);
        } else {
            total = minE * N;
        }
        System.out.println(total);
    }
}
