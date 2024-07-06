package Glad.Silver.수리공_항승;

import java.util.Arrays;
import java.util.Scanner;

public class 수리공_항승 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] arr = new int[N];
        sc.nextLine();
        String[] split = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(arr);
        int startIdx = 0;
        int count = N;
        for (int i = 1; i < N; i++) {
            if(arr[i] - arr[startIdx] + 1 <= L) {
                count--;
            } else{
                startIdx = i;
            }
        }
        System.out.println(count);
    }
}
