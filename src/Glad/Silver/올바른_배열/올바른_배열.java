package Glad.Silver.올바른_배열;

import java.util.Arrays;
import java.util.Scanner;

public class 올바른_배열 {
    public static void main(String[] args) {

        //정렬 , n, n+1의 값 차이가 1이 나는지 확인, 맞다면 +1,
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }
        Arrays.sort(arr);
        int min = 4;
        int size = 4;
        for (int i = 0; i < arr.length - 1; i++) {
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] - arr[i] < 5) {
                    count++;
                }
            }
            if(min > 5 - count ) min = 5 - count;
        }
        System.out.println(min);
    }
}

