package Glad.Silver.부분수열의_합;

import java.util.Scanner;

public class 부분수열의_합 {
    static int[] arr;
    static int S;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        S = sc.nextInt();
        sc.nextLine();
        String nums = sc.nextLine();
        String[] splitNums = nums.split(" ");
        for (int i = 0; i < splitNums.length; i++) {
            arr[i] = Integer.parseInt(splitNums[i]);
        }
        backTracking(0, 0, 0);
        System.out.println(count);

    }
    static void backTracking(int length, int sum, int start) {
        if (arr.length + 1 == length) return;
        System.out.println(sum);
        if (length > 0 && sum == S) count++;
        for (int i = start; i < arr.length; i++) {
            backTracking(length + 1, sum + arr[i], i + 1);
        }
    }
}
