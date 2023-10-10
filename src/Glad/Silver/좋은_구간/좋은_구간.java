package Glad.Silver.좋은_구간;

import java.util.Arrays;
import java.util.Scanner;
public class 좋은_구간 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int[] arr = new int[L];
        for (int i = 0; i < L; i++)
            arr[i] = sc.nextInt();
        int n = sc.nextInt();
        Arrays.sort(arr);
        int start = 0;
        int end = 1000;
        for (int i = 0; i < arr.length; i++) {
            if( arr[i] < n){
              start = Math.max(start,arr[i]);
            } else if( arr[i] > n){
              end = Math.min(end, arr[i]);
            }
            else if (arr[i] == n){
                System.out.println(0);
                return;
            }
        }
        int Left = n - start - 1;
        int Right = end - n - 1;
        int count = Left * Right + Left + Right;
        System.out.println(count);
    }
}
