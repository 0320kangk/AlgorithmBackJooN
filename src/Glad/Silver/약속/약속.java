package Glad.Silver.약속;

import java.util.Arrays;
import java.util.Scanner;

public class 약속 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String AB = sc.nextLine();
            String[] sp = AB.split(" ");
            arr[i] = Integer.parseInt(sp[0]) - Integer.parseInt(sp[1]);
        }
        Arrays.sort(arr);
        //2,5
        if (arr.length % 2 == 0){
            System.out.println(Math.abs(arr[arr.length / 2] - arr[arr.length / 2 - 1]) +1 );
        }else{
            System.out.println(1);
        }

    }
}
