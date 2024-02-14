package Glad.Silver.온라인_판매;

import java.util.Arrays;
import java.util.Scanner;

public class 온라인_판매 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int max = 0;
        int selectPrice = 0;
        for (int i = 0; i < M; i++) {
            int count = Math.min(M- i, N);
            int totalPrice = arr[i] * (count);
            if(totalPrice > max) {
                max = Math.max(totalPrice, max);
                selectPrice = arr[i];
            }
        }
        System.out.println(selectPrice + " "+ max);
    }
}
