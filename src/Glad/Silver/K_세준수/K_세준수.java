package Glad.Silver.K_세준수;

import java.util.Arrays;
import java.util.Scanner;

public class K_세준수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N + 1];
        //false는 소수
        //true는 소수가 아닌 수
        for (int i = 2; i <= N; i++) {
            if(arr[i] != 0) continue;
            for (int j = 1; i*j <= N; j++) {
                arr[i*j] = i;
            }
        }
        int count = 0;
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i <= N; i++) {
           if(K >= arr[i]) count++;
        }
        System.out.println(count);
    }
}
