package Glad.Silver.수_찾기;

import java.util.Arrays;
import java.util.Scanner;

public class 수_찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] values = new int[M];
        for (int i = 0; i < M; i++) {
            values[i] = sc.nextInt();
        }
        //이분탐색으로 찾아보기
        Arrays.sort(A);
        /*
        이분탐색
        left index ?
        right index?

        mid -> 답에 맞는 지 확인
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int left = 0;
            int right = N -1;
            while(left <= right) {
                int mid = (left + right) / 2;
                if (A[mid] < values[i]){
                    left = mid + 1;
                }else if (A[mid] > values[i]){
                    right = mid - 1;
                } else if (A[mid] == values[i]){
                    find = true;
                    break;
                }
            }
            if (find) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
