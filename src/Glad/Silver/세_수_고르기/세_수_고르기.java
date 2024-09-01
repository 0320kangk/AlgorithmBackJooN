package Glad.Silver.세_수_고르기;

import java.util.Scanner;
public class 세_수_고르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int answer = 0;
        if(M == 0) System.out.println(answer);
        else {
            int[] arr = new int[1002];
            sc.nextLine();
            String[] split = sc.nextLine().split(" ");
            for (int i = 0; i < M; i++) {
                arr[Integer.parseInt(split[i])]++;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= 1000; i++) {
                for (int j = i; j <= 1000; j++) {
                    for (int k = j; k <= 1001; k++) {
                        if(arr[i]  == 0 && arr[j] ==  0 && arr[k] == 0){
                            int abs = Math.abs(N - i * j * k);
                            if( abs < min) min = abs;
                        }
                        if (N <= i * j)break;
                    }
                }
            }
            answer = min;
            System.out.println(answer);
        }
    }
}
