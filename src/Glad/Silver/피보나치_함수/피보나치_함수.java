package Glad.Silver.피보나치_함수;

import java.util.Scanner;

public class 피보나치_함수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        for (int i = 0; i < testCount; i++) {
            int n = sc.nextInt();
            if (n == 0 || n==1){
                if (n == 0)
                    System.out.println(1 + " " + 0);
                if (n == 1)
                    System.out.println(0 + " " + 1);
                continue;
            }

            int[] arr = new int[n + 1];
            arr[0] = 1;
            arr[1] = 1;
            for(int j = 2; j <= n; j++){
                arr[j] = arr[j-1] + arr[j-2];
            }
            System.out.println( arr[n- 2] + " " + arr[n - 1]);
        }
    }

}
