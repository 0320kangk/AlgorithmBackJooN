package Glad.Silver.나무꾼_이다솜;

import java.util.Arrays;
import java.util.Scanner;

public class 나무꾼_이다솜 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 개수
        long C = sc.nextInt(); //비용
        long W = sc.nextInt(); // 가격

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] =sc.nextLong();
        }
        Arrays.sort(arr);
        long max = 0;
        long bigLength = arr[arr.length - 1];
        for (int i = 1; i <= bigLength; i++) {
            long totalCost = 0;
            for (int j = 0; j < arr.length; j++) {
                long cost = 0;
                cost = arr[j] / i * W * i;
                long l = (long) Math.ceil( 1.0 * arr[j] / i);
                if(l > 1) cost = cost - C * (  l - 1);
                if (cost > 0) totalCost += cost;
            }
            max = Math.max(totalCost, max);
        }

        System.out.println(max);
    }
}

