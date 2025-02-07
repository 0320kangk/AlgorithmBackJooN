package Glad.Silver.랜선_자르기;

import java.util.Arrays;
import java.util.Scanner;

public class 랜선_자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();

        int[] cables = new int[K];
        for (int i = 0; i < K; i++) {
            cables[i] = sc.nextInt();
        }

        Arrays.sort(cables);
        long left = 1;
        long right = cables[cables.length - 1];
        long answer = 0;
        while(left <= right){
            long mid = (left + right) / 2;
            long count = 0;
            //target 값
            for (int i = 0; i < cables.length; i++) {
                count += cables[i] / mid;
            }
            //count가 크면 랜선 길이를 늘려야함
            if(count >= N){
                left = mid + 1;
                answer = mid;
            } else {
                right = mid -1;
            }
        }
        System.out.println(answer);
    }
}
