package Glad.Gold.램프;

import java.util.Scanner;

public class 램프 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }
        int K = sc.nextInt();
        int oddEven = K % 2;
        if (K > 50)
            K = 50;

        int[] zeroArr = new int[N];// 행별 0 개수
        //각 행의 0 개수 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i].charAt(j) == '0')
                    zeroArr[i]++;
            }
        }
        int max = 0;//최대값 찾기
        //
        for (int i = 0; i < N; i++) {
            int count = 0;//같은 패턴의 행 개수
            //홀 짝 여부가 같으며, 의 개수가 K이하인 행 찾기
            if (zeroArr[i] % 2 == oddEven && zeroArr[i]<= K){
                //같은 패턴의 행 찾기
                for (int j = 0; j < N; j++) {
                    if( i != j && arr[i].equals(arr[j]))
                        count++;
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}